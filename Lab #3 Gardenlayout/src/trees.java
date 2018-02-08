import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

@SuppressWarnings("unused")
public class trees implements Garden_Interface {
	Point2D position;
	Color coloroftree;
	Boolean moveable;
	Circle circle;

	public trees(Point2D position, Color coloroftree, Boolean moveable) {
		this.position = position;
		this.coloroftree = coloroftree;
		this.moveable = moveable;
		
		circle = new Circle();
		circle.setCenterX(position.getX());
		circle.setCenterY(position.getY());
		circle.setRadius(20);
		circle.setFill(coloroftree);
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
