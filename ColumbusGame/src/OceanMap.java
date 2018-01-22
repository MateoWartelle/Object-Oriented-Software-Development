import java.awt.Point;
import java.util.Random;

public class OceanMap {
	boolean[][] Grid = new boolean[10][10];
	Point shipLocation;
	boolean [][] islands;
	int dimension;
	int islandCount;
	Random rand = new Random();
	
	public OceanMap(int dimension, int islandCount) {
		this.dimension = dimension;
		this.islandCount = islandCount;
		CreateGrid();
		shipLocation = placeShip();
	}
	private void CreateGrid() {
		islands = new boolean[dimension][dimension];
		for(int x = 0; x < dimension; x++)
			for(int y = 0; y < dimension; y++)
				islands[x][y]= false;

	}
	
	public Point placeShip() {
		int x = 0;
		int y = 0;
		x = rand.nextInt(dimension);
		y = rand.nextInt(dimension);
		return new Point(x,y);
	}

	public boolean[][] getMap() {
		return Grid;
	}
	public Point getShipLocation() {
		return shipLocation;
	
	}
}
