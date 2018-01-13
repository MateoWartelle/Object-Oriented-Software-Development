import java.util.ArrayList;

public class HorizontalSweep implements SearchStrategy {
	ArrayList<String> SubmarineCoord = new ArrayList<String>();
	ArrayList<String> CarrierCoord = new ArrayList<String>();
	int searchCount = 0;

	public void find(String[][] Grid) {
		int ShipCount = 0;
		for (int row = 0; row < Grid.length; row++) {
			for (int col = 0; col < Grid.length; col++) {
				if (Grid[row][col] == "SUBMARINE") {
					SubmarineCoord.add("(" + col + "," + row + ")");
					searchCount++;
					if (SubmarineCoord.size() == 3) {
						ShipCount++;
					}
				} else if (Grid[row][col] == "CARRIER") {
					CarrierCoord.add("(" + col + "," + row + ")");
					searchCount++;
					if (CarrierCoord.size() == 5) {
						ShipCount++;
					}
				} else {
					searchCount++;
				}

				if (ShipCount == 2) {
					return;

				}
			}

		}
	}

	public String GetStrategy() {
		return "Horizontal Sweep";
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
