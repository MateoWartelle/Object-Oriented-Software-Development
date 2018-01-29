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
	/* 
	 * Moves to the right and checks to make sure is NOT an island
	 */
	public void goEast() {
		if (currentLocation.x < oceanMap.getDimensions() - 1
				&& oceanMap.isIsland(currentLocation.x + 1, currentLocation.y) == false) {
			currentLocation.x++;
			setChanged();
			notifyObservers(currentLocation);
		}
	}
	/* 
	 * Moves to the left and checks to make sure is NOT an island
	 */
	public void goWest() {
		if (currentLocation.x > 0 && oceanMap.isIsland(currentLocation.x - 1, currentLocation.y) == false) {
			currentLocation.x--;
			setChanged();
			notifyObservers(currentLocation);
		}
	}
	/* 
	 * Moves up and checks to make sure is NOT an island
	 */
	public void goNorth() {
		if (currentLocation.y > 0 && oceanMap.isIsland(currentLocation.x, currentLocation.y - 1) == false) {
			currentLocation.y--;
			setChanged();
			notifyObservers(currentLocation);
		}
	}
	/* 
	 * Moves down and checks to make sure is NOT an island
	 */
	public void goSouth() {
		if (currentLocation.y < oceanMap.getDimensions() - 1
				&& oceanMap.isIsland(currentLocation.x, currentLocation.y + 1) == false) {
			currentLocation.y++;
			setChanged();
			notifyObservers(currentLocation);
		}
	}
}
