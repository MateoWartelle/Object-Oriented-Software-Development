import java.awt.Point;
import java.io.File;
import java.util.Observable;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class Ship extends Observable {
	Point currentLocation;
	OceanMap oceanMap;

	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getShipLocation();
		setChanged();
		notifyObservers(currentLocation);

	}

	public Point getShipLocation() {
		return currentLocation;
	}

	public void goEast() {
		if (currentLocation.x < oceanMap.getDimensions() - 1
				&& oceanMap.isIsland(currentLocation.x + 1, currentLocation.y) == false) {
			currentLocation.x++;
			setChanged();
			notifyObservers(currentLocation);
		}
	}

	public void goWest() {
		if (currentLocation.x > 0 && oceanMap.isIsland(currentLocation.x - 1, currentLocation.y) == false) {
			currentLocation.x--;
			setChanged();
			notifyObservers(currentLocation);
		}
	}

	public void goNorth() {
		if (currentLocation.y > 0 && oceanMap.isIsland(currentLocation.x, currentLocation.y - 1) == false) {
			currentLocation.y--;
			setChanged();
			notifyObservers(currentLocation);
		}
	}

	public void goSouth() {
		if (currentLocation.y < oceanMap.getDimensions() - 1
				&& oceanMap.isIsland(currentLocation.x, currentLocation.y + 1) == false) {
			currentLocation.y++;
			setChanged();
			notifyObservers(currentLocation);
		}
	}
}
