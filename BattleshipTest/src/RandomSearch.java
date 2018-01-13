import java.util.ArrayList;

public class RandomSearch implements SearchStrategy {
	ArrayList<String> SubmarineCoord = new ArrayList<String>();
	ArrayList<String> CarrierCoord = new ArrayList<String>();
	ArrayList<String> AlreadyVisited = new ArrayList<String>();
	int searchCount = 0;

	public void find(String[][] Grid) {
		int ShipCount = 0;
		while (ShipCount < 2) {
			int column = 0 + (int) (Math.random() * ((Grid.length - 0)));
			int row = 0 + (int) (Math.random() * ((Grid.length - 0)));
			String check = "(" + column + "," + row + ")";
			if (AlreadyVisited.contains(check) != true) {
				AlreadyVisited.add(check);
				if (Grid[row][column] == "SUBMARINE" && SubmarineCoord.contains(check) != true) {
					SubmarineCoord.add("(" + column + "," + row + ")");
					searchCount++;
					if (SubmarineCoord.size() == 3)
						ShipCount++;
				} else if (Grid[row][column] == "CARRIER" && CarrierCoord.contains(check) != true) {
					CarrierCoord.add("(" + column + "," + row + ")");
					searchCount++;
					if (CarrierCoord.size() == 5)
						ShipCount++;
				} else {
					searchCount++;
				}
			}
		}
		SubmarineCoord.sort((String h6, String h7) -> {
			if(h6.hashCode() > h7.hashCode()) return 1;
			if(h6.hashCode() < h7.hashCode()) return -1;
			return 0;	
		});
		CarrierCoord.sort((String h8, String h9) -> {
			if(h8.hashCode() > h9.hashCode()) return 1;
			if(h8.hashCode() < h9.hashCode()) return -1;
			return 0;	
		});

	}

	public String GetStrategy() {
		return "Random Search";
	}

	public String FindSubmarine() {
		return "Submarine found : " + SubmarineCoord.get(0) + " to " + SubmarineCoord.get(SubmarineCoord.size() - 1);
	}

	public String FindCarrier() {
		return "Carrier found: " + CarrierCoord.get(0) + " to " + CarrierCoord.get(CarrierCoord.size() - 1);
	}

	public String TotalSearchCounts() {
		return "Number of Cells searched: " + searchCount;
	}

}
