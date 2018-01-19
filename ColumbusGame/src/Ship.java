import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


@SuppressWarnings("unused")
public class Ship {
	private Point x;
	private Point y;
	
	public Ship() {
		
	}
	public Ship(Point x, Point y) {
		this.x = x;
		this.y = y;
	}
	public Point getShipLocation() {
		return x;
		
	}
	  public String toString() {
	        return "(" + x + ", " + y + ")";
	    } 

	public Ship(OceanMap oceanMap) {
		// TODO Auto-generated constructor stub
	}
	
	
}
