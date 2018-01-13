import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;

public class Main {
	String[][] Grid = new String[25][25];
	SearchStrategy searchstrategy;
	static ArrayList<String> games = new ArrayList<String>();

	public Main() {
		searchstrategy = new RandomSearch();
	}

	public void setStrategy(SearchStrategy strategy) {
		searchstrategy = strategy;
	}

	public String[][] readInputFile() {
		String fileName = "src/input.txt";
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				String game = scanner.nextLine();
				games.add(game);
			}
			scanner.close();

		} catch (Exception ex) {
			System.out.println("Unable to open file" + fileName + "'");
			ex.printStackTrace();
		}
		return Grid;
	}

	public void PlaceShips(String Coord) {
		int pairCount = 0;
		StringTokenizer tokenizer = new StringTokenizer(Coord, "()");
		while (tokenizer.hasMoreTokens()) {
			String pair = tokenizer.nextToken();
			String[] cord = pair.split(",");
			int x = Integer.parseInt(cord[0]);
			int y = Integer.parseInt(cord[1]);
			if (pairCount < 5) {
				Grid[y][x] = "CARRIER";
				pairCount++;
			} else if (pairCount >= 5) {
				Grid[y][x] = "SUBMARINE";
				pairCount++;
			}
		}
	}

	public void initGrid() {
		for (int row = 0; row < Grid.length; row++) {
			for (int col = 0; col < Grid.length; col++) {
				Grid[row][col] = "EMPTY";
			}
		}
	}

	public void Ships() {
		searchstrategy.find(Grid);
		System.out.println("Strategy: " + searchstrategy.GetStrategy());
		System.out.println(searchstrategy.TotalSearchCounts());
		System.out.println(searchstrategy.FindCarrier() + " " + searchstrategy.FindSubmarine());
	}

	public static void main(String[] args) {
		int i = 0;
		Main BattleShipGameplay = new Main();
		BattleShipGameplay.initGrid();
		BattleShipGameplay.readInputFile();
		BattleShipGameplay.PlaceShips(games.get(i));
		while (i < 3) {
			System.out.println("Game " + (i + 1) + ":");
			// Horizontal Sweep
			BattleShipGameplay.setStrategy(new HorizontalSweep());
			BattleShipGameplay.initGrid();
			BattleShipGameplay.readInputFile();
			BattleShipGameplay.PlaceShips(games.get(i));
			BattleShipGameplay.Ships();
			// Random Search
			BattleShipGameplay.setStrategy(new RandomSearch());
			BattleShipGameplay.initGrid();
			BattleShipGameplay.readInputFile();
			BattleShipGameplay.PlaceShips(games.get(i));
			BattleShipGameplay.Ships();
			// EveryThirdandFifth
			BattleShipGameplay.setStrategy(new EveryThirdAndFifth());
			BattleShipGameplay.initGrid();
			BattleShipGameplay.readInputFile();
			BattleShipGameplay.PlaceShips(games.get(i));
			BattleShipGameplay.Ships();
			i++;
			
		}

	}
}
