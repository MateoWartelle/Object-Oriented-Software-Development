import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

@SuppressWarnings("unused")
public class flower implements Garden_Interface {
	Point2D position;
	Color colorofflower;
	Boolean moveable;
	Circle circle;

	public flower(Point2D position, Color colorofflower, Boolean moveable) {
		this.position = position;
		this.colorofflower = colorofflower;
		this.moveable = moveable;
		
		circle = new Circle();
		circle.setCenterX(position.getX());
		circle.setCenterY(position.getY());
		circle.setRadius(7);
		circle.setFill(colorofflower);
		circle.setStrokeWidth(1);
		circle.setStroke(Color.BLACK);
	}

	public Node getCircle() {
		return circle;
	}
	
	@Override
	public void move(double dx, double dy) {
		circle.setCenterY(circle.getCenterY() + dy);
		circle.setCenterX(circle.getCenterX() + dx);
		
	}
	public Point2D getPosition() {
		return position;
	}

}
