import java.awt.Point;
import java.util.Random;

import javafx.stage.Stage;

@SuppressWarnings("unused")
public class OceanMap {
	int[][] Grid = new int[10][10];
	int numberofPirates = 2;
	Point shipLocation;
	Point pirateLocation;
	Point pirateLocation2;
	int dimension;
	int islandCount;
	int size;
	Random rand = new Random();

	public OceanMap(int dimension, int islandCount) {
		this.dimension = dimension;
		this.islandCount = islandCount;
		CreateGrid();
		createIslands();
		shipLocation = placeShip();
		pirateLocation = placePirates();
		pirateLocation2 = placePirates();
	}
	/* 
	 * Creates the Grid, Sets all cells to 0
	 */
	private void CreateGrid() {
		Grid = new int[dimension][dimension];
		for (int x = 0; x < dimension; x++)
			for (int y = 0; y < dimension; y++)
				Grid[x][y] = 0;

	}
	/* 
	 * Places the ship at one random Point
	 */
	public Point placeShip() {
		boolean placeShip = false;
		int x = 0;
		int y = 0;
		while (!placeShip) {
			x = rand.nextInt(dimension);
			y = rand.nextInt(dimension);
			if (Grid[x][y] == 0) {
				placeShip = true;
			}
		}
		return new Point(x, y);
	}
	/* 
	 * Places the pirates at random Points
	 */
	public Point placePirates() {
		int x = 0;
		int y = 0;
		x = rand.nextInt(dimension);
		y = rand.nextInt(dimension);
		if (Grid[x][y] == 0) {
			Grid[x][y] = 2;
		}
		return new Point(x, y);
	}
	/* 
	 * Places Islands on the map at random
	 */
	public void createIslands() {
		int i = islandCount;
		while (i > 0) {
			int x = rand.nextInt(dimension);
			int y = rand.nextInt(dimension);
			if (Grid[x][y] == 0) {
				Grid[x][y] = 1;
				i--;
			}

		}
	}

	public int[][] getMap() {
		return Grid;
	}

	public Point getShipLocation() {
		return shipLocation;

	}

	public Point getPirateLocation() {
		return pirateLocation;
	}
	
	public Point getPirateLocation2() {
		return pirateLocation2;
	}

	//pirateLocation2 = placePirates();
	
	public int getDimensions() {
		return dimension;
	}

	public Point getIslandLocation() {
		return shipLocation;
	}

	public boolean isIsland(int x, int y) {
		if (Grid[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}
}
