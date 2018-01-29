import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

@SuppressWarnings("unused")
public class PirateShip implements Observer {

	OceanMap ocean;
	Point currentLocation;
	Point pirateLocation;
	Point pirateLocation2;
	int[][] Grid;
	Random rand = new Random();

	public PirateShip(OceanMap oceanMap) {
		this.ocean = oceanMap;
		pirateLocation = oceanMap.getPirateLocation();
		pirateLocation2 = oceanMap.getPirateLocation2();
	}

	public Point getPirateLocation() {
		return pirateLocation;
	}

	public Point getPirateLocation2() {
		return pirateLocation2;
	}
	/* 
	 * Updates the PirateMovement and Pirate2Movement based on the Ship's movement
	 */
	@Override
	public void update(Observable observable, Object objectobserving) {

		if (observable instanceof Ship) {
			currentLocation = ((Ship) observable).getShipLocation();
			Piratemovement();
			Pirate2movement();
			
		}	
	}
	/*
	 * Moves the pirateShip while checking if the next position is NOT an Island
	 */
	public void Piratemovement() {
		if ((pirateLocation.x - currentLocation.x < 0)
				&& (ocean.isIsland(pirateLocation.x + 1, pirateLocation.y)) == false) {
			pirateLocation.x++;
		} else if ((pirateLocation.x - currentLocation.x > 0)
				&& (ocean.isIsland(pirateLocation.x - 1, pirateLocation.y)) == false) {
			pirateLocation.x--;
		}

		if ((pirateLocation.y - currentLocation.y < 0)
				&& (ocean.isIsland(pirateLocation.x, pirateLocation.y + 1) == false)) {
			pirateLocation.y++;
		} else if ((pirateLocation.y - currentLocation.y > 0)
				&& (ocean.isIsland(pirateLocation.x, pirateLocation.y - 1) == false)) {
			pirateLocation.y--;
		}

	}
	/* 
	 * Moves the pirateShip while checking if the next position is NOT an Island
	 */
	public void Pirate2movement() {
		if ((pirateLocation2.x - currentLocation.x < 0)
				&& (ocean.isIsland(pirateLocation2.x + 1, pirateLocation2.y)) == false) {
			pirateLocation2.x++;
		} else if ((pirateLocation2.x - currentLocation.x > 0)
				&& (ocean.isIsland(pirateLocation2.x - 1, pirateLocation2.y)) == false) {
			pirateLocation2.x--;
		}

		if ((pirateLocation2.y - currentLocation.y < 0)
				&& (ocean.isIsland(pirateLocation2.x, pirateLocation2.y + 1) == false)) {
			pirateLocation2.y++;
		} else if ((pirateLocation2.y - currentLocation.y > 0)
				&& (ocean.isIsland(pirateLocation2.x, pirateLocation2.y - 1) == false)) {
			pirateLocation2.y--;
		}
	}
}
