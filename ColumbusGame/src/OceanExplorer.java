import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@SuppressWarnings("unused")
public class OceanExplorer extends Application {
	boolean[][] islandMap;
	final int dimension = 10;
	final int islandCount = 10;
	final int scale = 50;
	OceanMap oceanMap;
	Image shipImage;
	ImageView shipImageView;
	AnchorPane root;
	Scene scene;
	// Ship ship;

	public void loadShipImage() {
		Image shipImage = new Image("src/ship.png", 50, 50, true, true);
		try {
			ImageView shipImageView = new ImageView(shipImage);
			//shipImageView.setX(OceanMap.getShipLocation().x * scale);
			// shipImageView.setY(OceanMap.getShipLocation().y * scale);
			root.getChildren().add(shipImageView);

		} catch (Exception ex) {
			System.out.println("Unable to open file" + shipImage + "'");
			ex.printStackTrace();
		}
	}

	public void drawMap() {
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK); // We want the black outline
				rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
				root.getChildren().add(rect); // Add to the node tree in the pane
			}
		}
	}

	public void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
				case RIGHT:
					System.out.println("Going Right");
					break;
				case LEFT:
					System.out.println("Going LEFT");
					break;
				case UP:
					System.out.println("Going UP");
					break;
				case DOWN:
					System.out.println("Going Down");
					break;
				default:
					break;
				}
				
			}
		});

	}

	@Override
	public void start(Stage OceanStage) throws Exception {
		oceanMap = new OceanMap(dimension, islandCount);
		islandMap = oceanMap.getMap();
		root = new AnchorPane();
		drawMap();
		// ship = new Ship(oceanMap);
		// loadShipImage();
		Scene scene = new Scene(root, 500, 500);
		OceanStage.setTitle("Columbus Game");
		OceanStage.setScene(scene);
		OceanStage.show();
		//startSailing();
	}

	public static void main(String[] args) {
		launch(args);
	}

}