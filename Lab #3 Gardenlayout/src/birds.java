import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

@SuppressWarnings("unused")
public class birds {
	Boolean moveable;
	Image birdImage;
	Point2D position;
	
	public birds (Point2D position, Boolean moveable) {
		this.moveable = moveable;
		this.position = position;
		loadBirdImage();
	}
	private void loadBirdImage() {
		try {
			Image birdImage = new Image("bird.png", 50, 50, true, true);
		} catch (Exception ex) {
			System.out.println("Unable to open file" + birdImage + "'");
			ex.printStackTrace();
		}

	}

}
