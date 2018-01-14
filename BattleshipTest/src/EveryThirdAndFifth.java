import java.util.ArrayList;

public class EveryThirdAndFifth implements SearchStrategy {
	ArrayList<String> SubmarineCoord = new ArrayList<String>();
	ArrayList<String> CarrierCoord = new ArrayList<String>();
	int searchCount;
	int ShipCount = 0;

	public void find(String[][] Grid) {
		for (int row = 0; row < Grid.length; row++) {
			for (int column = 0; column < Grid.length; column++) {
				if (row % 3 == 0 || row % 5 == 0) {
					if (Grid[row][column] == "SUBMARINE") {
						SubmarineCoord.add("(" + column + "," + row + ")");
						CheckUp(Grid, row, column);
						CheckDown(Grid, row, column);
						CheckLeft(Grid, row, column);
						CheckRight(Grid, row, column);
					}
					if (Grid[row][column] == "CARRIER") {
						CarrierCoord.add("(" + column + "," + row + ")");
						CheckUp(Grid, row, column);
						CheckDown(Grid, row, column);
						CheckLeft(Grid, row, column);
						CheckRight(Grid, row, column);
					}
					if (SubmarineCoord.size() == 3) {
						ShipCount++;
					}
					if (CarrierCoord.size() == 5) {
						ShipCount++;
					}
					if (ShipCount == 2) {
						return;
					}
				} else if (column % 3 == 0 || column % 5 == 0) {
					if (Grid[row][column] == "SUBMARINE") {
						SubmarineCoord.add("(" + column + "," + row + ")");
						CheckUp(Grid, row, column);
						CheckDown(Grid, row, column);
						CheckLeft(Grid, row, column);
						CheckRight(Grid, row, column);
					}
					if (Grid[row][column] == "CARRIER") {
						CarrierCoord.add("(" + column + "," + row + ")");
						CheckUp(Grid, row, column);
						CheckDown(Grid, row, column);
						CheckLeft(Grid, row, column);
						CheckRight(Grid, row, column);
					}
					if (SubmarineCoord.size() == 3) {
						ShipCount++;
					}
					if (CarrierCoord.size() == 5) {
						ShipCount++;
					}
					if (ShipCount == 2) {
						return;
					}
				}
			}
		}
	}

	public void CheckUp(String[][] Grid, int x, int y) {
		for (int i = x; i < Grid.length; i++) {
			for (int j = y; j < Grid[i].length; j++) {
				if (i > 0) {
					if (Grid[i][j] == "SUBMARINE") {
						SubmarineCoord.add("(" + j + "," + i + ")");
						searchCount++;
					} else if (Grid[i][j] == "CARRIER") {
						CarrierCoord.add("(" + j + "," + i + ")");
						searchCount++;
					}
				}
			}
		}
	}

	public void CheckDown(String[][] Grid, int x, int y) {
		for (int i = x; i < Grid.length; i++) {
			for (int j = y; j < Grid[i].length; j++) {
				if (i < Grid.length - 1) {
					if (Grid[i][j] == "SUBMARINE") {
						SubmarineCoord.add("(" + j + "," + i + ")");
						searchCount++;
					} else if (Grid[i][j] == "CARRIER") {
						CarrierCoord.add("(" + j + "," + i + ")");
						searchCount++;
					}
				}
			}
		}
	}

	public void CheckLeft(String[][] Grid, int x, int y) {
		for (int i = x; i < Grid.length; i++) {
			for (int j = y; j < Grid[i].length; j++) {
				if (j > 0) {
					if (Grid[i][j] == "SUBMARINE") {
						SubmarineCoord.add("(" + j + "," + i + ")");
						searchCount++;
					} else if (Grid[i][j] == "CARRIER") {
						CarrierCoord.add("(" + j + "," + i + ")");
						searchCount++;
					}
				}
			}
		}

	}

	public void CheckRight(String[][] Grid, int x, int y) {
		for (int i = x; i < Grid.length; i++) {
			for (int j = y; j < Grid[i].length; j++) {
				if (j < Grid[i].length - 1) {
					if (Grid[i][j] == "SUBMARINE") {
						SubmarineCoord.add("(" + j + "," + i + ")");
					} else if (Grid[i][j] == "CARRIER") {
						CarrierCoord.add("(" + j + "," + i + ")");
					}
				}
			}
		}

	}

	public String GetStrategy() {
		return "Every Third and Fifth";
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
