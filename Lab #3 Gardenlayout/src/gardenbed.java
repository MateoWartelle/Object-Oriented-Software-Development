
import javafx.scene.shape.Rectangle;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

@SuppressWarnings("unused")
public class gardenbed implements Garden_Interface {
	Point2D rectPosition;
	Color colorofflowerbed;
	Boolean moveable;
	Rectangle rectangle;

	public gardenbed(Point2D position, Color colorofflowerbed, Boolean moveable) {
		this.rectPosition = position;
		this.colorofflowerbed = colorofflowerbed;
		this.moveable = moveable;

		rectangle = new Rectangle();
		rectangle.setX(position.getX());
		rectangle.setY(position.getY());
		rectangle.setWidth(75.0f);
		rectangle.setHeight(150.0f);
		rectangle.setFill(colorofflowerbed);
		rectangle.setStrokeWidth(1);
		rectangle.setStroke(Color.BLACK);

	}

	public Node getRectangle() {
		return rectangle;
	}

	@Override
	public void move(double dx, double dy) {
		rectangle.setY(rectangle.getY() + dy);
		rectangle.setX(rectangle.getX() + dx);

	}

}
