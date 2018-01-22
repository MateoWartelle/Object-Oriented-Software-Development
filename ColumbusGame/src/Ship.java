import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class Ship {
	Point currentLocation;
	OceanMap oceanMap;

	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getShipLocation();
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}

	public void goEast() {
		// TODO Auto-generated method stub
		
	}

	public void goWest() {
		// TODO Auto-generated method stub
		
	}

	public void goNorth() {
		// TODO Auto-generated method stub
		
	}

	public void goSouth() {
		// TODO Auto-generated method stub
		
	}
		
	
}
