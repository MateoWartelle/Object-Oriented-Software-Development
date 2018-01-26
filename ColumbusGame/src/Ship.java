import java.awt.Point;
import java.io.File;
import java.util.Observable;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class Ship extends Observable{
	Point currentLocation;
	OceanMap oceanMap;
	
	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getShipLocation();
	}
	
	public void notifyObservers() {
		
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}
	
	public void goEast() {
		if(currentLocation.getX() < oceanMap.size - 1) {
			if(!oceanMap.isIsland(currentLocation.x+1, currentLocation.y)) {
				currentLocation.x++;
				setChanged();
				notifyObservers(currentLocation);
			}
		}
	}
	
	public void goWest() {
		if(currentLocation.getX() > 0) {
			if(!oceanMap.isIsland(currentLocation.x-1, currentLocation.y)) {
				currentLocation.x--;
				setChanged();
				notifyObservers(currentLocation);
			}
		}
	}
	
	public void goNorth() {
		if(currentLocation.y > 0) {
			if(!oceanMap.isIsland(currentLocation.x, currentLocation.y-1)) {
				currentLocation.y--;
				setChanged();
				notifyObservers(currentLocation);
			}
		}
	}
	
	public void goSouth() {
		if(currentLocation.y < oceanMap.size - 1 )
			if(!oceanMap.isIsland(currentLocation.x, currentLocation.y+1)) {
				currentLocation.y++;
				setChanged();
				notifyObservers(currentLocation);
			}
		}
}


