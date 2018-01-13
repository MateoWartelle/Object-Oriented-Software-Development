import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;

@SuppressWarnings("unused")
public class Main {
	String[][] Grid = new String[25][25];
	SearchStrategy searchstrategy;
	ArrayList<String> games = new ArrayList<String>();

	public Main() {
		searchstrategy = new RandomSearch();
	}

	public void setStrategy(SearchStrategy strategy) {
		searchstrategy = strategy;
	}

	public String[][] readInputFile(String fileName) {
		try {
			Scanner scanner = new Scanner(fileName);
			while (scanner.hasNextLine()) {
				String game = scanner.nextLine();
				games.add(game);
			}
			scanner.close();

		} catch (Exception ex) {
			System.out.println("Unable to open file '" + fileName + "'");
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

	public static void main(String[] args) {
		Main Test = new Main();

	}
}
