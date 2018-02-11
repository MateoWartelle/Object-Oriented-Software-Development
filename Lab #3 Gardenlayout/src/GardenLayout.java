import java.awt.Button;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

@SuppressWarnings("unused")
public class GardenLayout extends Application {
	AnchorPane root;
	Scene scene;
	Rectangle flowerHolder;

	@Override
	public void start(Stage primaryStage) throws Exception {
		flower flower = new flower(new Point2D(25, 40), Color.YELLOW, true);
		flower flower2 = new flower(new Point2D(45, 40), Color.ORANGE, true);
		flower flower3 = new flower(new Point2D(65, 40), Color.RED, true);
		flower flower4 = new flower(new Point2D(85, 40), Color.BLUE, true);
		
		
		gardenbed gardenbed = new gardenbed(new Point2D(20, 115), Color.TAN, true);
		flower vegetable = new flower(new Point2D(25, 80), Color.GREENYELLOW, true);
		flower vegetable2 = new flower(new Point2D(45, 80), Color.LAWNGREEN, true);
		flower vegetable3 = new flower(new Point2D(65, 80), Color.GREEN, true);
		flower vegetable4 = new flower(new Point2D(85, 80), Color.DARKOLIVEGREEN, true);
		
		trees tree = new trees(new Point2D(35, 315), Color.GREEN, true);
		
		birds bird = new birds(new Point2D(65, 350), true);

		flowerHolder = new Rectangle();
		flowerHolder.setX(10.0f);
		flowerHolder.setY(10.0f);
		flowerHolder.setWidth(150.0f);
		flowerHolder.setHeight(375.0f);
		flowerHolder.setFill(Color.WHITE);
		flowerHolder.setStrokeWidth(1);
		flowerHolder.setStroke(Color.BLACK);

		Text Flowers = new Text();
		Flowers.setText("Flowers");
		Flowers.setX(15.0f);
		Flowers.setY(25.0f);
		Flowers.setFill(Color.BLACK);

		Text Vegetables = new Text();
		Vegetables.setText("Vegetables");
		Vegetables.setX(15.0f);
		Vegetables.setY(65.0f);
		Vegetables.setFill(Color.BLACK);

		Text FlowerBed = new Text();
		FlowerBed.setText("Flower Bed");
		FlowerBed.setX(15.0f);
		FlowerBed.setY(105.0f);
		FlowerBed.setFill(Color.BLACK);

		Text Tree = new Text();
		Tree.setText("Trees");
		Tree.setX(15.0f);
		Tree.setY(285.0f);
		Tree.setFill(Color.BLACK);
		
		Text Birds = new Text();
		Birds.setText("Birds");
		Birds.setX(95.0f);
		Birds.setY(285.0f);
		Birds.setFill(Color.BLACK);

		root = new AnchorPane();
		scene = new Scene(root, 600, 400);
		scene.setFill(Color.GREEN);
		
		root.getChildren().add(flowerHolder);
		root.getChildren().add(Flowers);
		root.getChildren().add(Vegetables);
		root.getChildren().add(FlowerBed);
		root.getChildren().add(Tree);
		root.getChildren().add(Birds);
		root.getChildren().add(tree.getCircle());
		root.getChildren().addAll(flower.getCircle(), flower2.getCircle(), flower3.getCircle(), flower4.getCircle());
		root.getChildren().addAll(vegetable.getCircle(), vegetable2.getCircle(), vegetable3.getCircle(), vegetable4.getCircle());
		root.getChildren().add(gardenbed.getRectangle());
		
		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				Point2D lastPosition = flower.getPosition();
				Point2D clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
				System.out.println(clickPoint.getX() + " " + clickPoint.getY());
				String eventName = mouseEvent.getEventType().getName();
				
				switch (eventName) {
				case ("MOUSE_DRAGGED"):
					if (lastPosition != null) {
						System.out.println("Dragging");
						double deltaX = clickPoint.getX() - lastPosition.getY();
						double deltaY = clickPoint.getY() - lastPosition.getY();
						flower.move(deltaX, deltaY);
					}
					break;
				}
				lastPosition = clickPoint;
			}

		};

		scene.setOnMouseDragged(mouseHandler);
		
		

		primaryStage.setScene(scene);
		primaryStage.setTitle("Garden Layout");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
