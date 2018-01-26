import java.awt.Point;
import java.util.Random;

import javafx.stage.Stage;

public class OceanMap {
	boolean[][] Grid = new boolean[10][10];
	Point shipLocation;
	boolean[][] islands;
	int dimension;
	int islandCount;
	int size;
	Random rand = new Random();
	
	

	public OceanMap(int dimension, int islandCount) {
		this.dimension = dimension;
		this.islandCount = islandCount;
		CreateGrid();
		placeIslands();
		shipLocation = placeShip();
	}

	private void CreateGrid() {
		islands = new boolean[dimension][dimension];
		for (int x = 0; x < dimension; x++)
			for (int y = 0; y < dimension; y++)
				islands[x][y] = false;

	}

	public Point placeShip() {
		boolean placeShip = false;
		int x = 0;
		int y = 0;
		while (!placeShip) {
			x = rand.nextInt(dimension);
			y = rand.nextInt(dimension);
			if (islands[x][y] == false) {
				placeShip = true;
			}
		}
		return new Point(x, y);
	}

	private void placeIslands() {
		int islandsToPlace = islandCount;
		while (islandsToPlace > 0) {
			int x = rand.nextInt(dimension);
			int y = rand.nextInt(dimension);
			if (islands[x][y] == false) {
				islands[x][y] = true;
				islandsToPlace--;
			}
		}
	}

	public boolean[][] getMap() {
		return Grid;
	}

	public Point getShipLocation() {
		return shipLocation;

	}

	public boolean check_if_ocean(int x, int y) {
		if (!islands[x][y])
			return true;
		else
			return false;
	}

	public int getDimensions() {
		return dimension;
	}

	public Point getIslandLocation() {
		return shipLocation;
	}

	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean isIsland(int x, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}
