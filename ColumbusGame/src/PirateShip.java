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
		pirateLocation = oceanMap.placePirates();
		pirateLocation2 = oceanMap.placePirates();
	}

	public Point getPirateLocation() {
		return pirateLocation;
	}

	public Point getPirateLocation1() {
		return pirateLocation2;
	}

	@Override
	public void update(Observable observable, Object objectobserving) {

		if (observable instanceof Ship) {
			currentLocation = ((Ship) observable).getShipLocation();
			Piratemovement();
		}
	}

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
}
