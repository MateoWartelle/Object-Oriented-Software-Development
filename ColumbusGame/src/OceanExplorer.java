import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToolBar;
import java.awt.Point;
import java.util.Optional;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;

@SuppressWarnings("unused")
public class OceanExplorer extends Application {

	protected static final Stage OceanStage = null;
	int[][] islandMap;
	final int dimension = 10;
	final int islandCount = 10;
	final int scale = 50;
	OceanMap oceanMap;
	Image shipImage;
	ImageView shipImageView;
	Image islandImage;
	ImageView islandImageView;
	Image pirateShipImage;
	ImageView pirateShipImageView;
	PirateShip pirateShip;
	PirateShip secondpirateShip;
	ImageView secondpirateShipImageView;
	Image secondpirateShipImage;
	AnchorPane root;
	Scene scene;
	Ship ship;
	boolean GameOver = false;
	/*
	 * Loads Ship Image
	 */
	public void loadShipImage() {
		try {
			Image shipImage = new Image("ship.png", 50, 50, true, true);
			shipImageView = new ImageView(shipImage);
			shipImageView.setX(oceanMap.getShipLocation().x * scale);
			shipImageView.setY(oceanMap.getShipLocation().y * scale);
			root.getChildren().add(shipImageView);
		} catch (Exception ex) {
			System.out.println("Unable to open file" + shipImage + "'");
			ex.printStackTrace();
		}
	}
	/* 
	 * Loads Island Image
	 */
	private void loadIslandImage(int x, int y) {
		try {
			Image islandImage = new Image("island.jpg", 50, 50, true, true);
			islandImageView = new ImageView(islandImage);
			islandImageView.setX(x * scale);
			islandImageView.setY(y * scale);
			root.getChildren().add(islandImageView);
		} catch (Exception ex) {
			System.out.println("Unable to open file" + islandImage + "'");
			ex.printStackTrace();
		}

	}
	/* 
	 * Loads PirateShip#1 Image
	 */
	private void loadPirateShipImage() {
		try {
			Image pirateShipImage = new Image("pirateShip.png", 50, 50, true, true);
			pirateShipImageView = new ImageView(pirateShipImage);
			pirateShipImageView.setX(pirateShip.getPirateLocation().x * scale);
			pirateShipImageView.setY(pirateShip.getPirateLocation().y * scale);
			root.getChildren().add(pirateShipImageView);

		} catch (Exception ex) {
			System.out.println("Unable to open file" + pirateShipImage + "'");
			ex.printStackTrace();
		}

	}
	/* 
	 * Loads PirateShip#2 Image
	 */
	private void loadSecondPirateShipImage() {
		try {
			Image secondpirateShipImage = new Image("pirateShip.png", 50, 50, true, true);
			secondpirateShipImageView = new ImageView(secondpirateShipImage);
			secondpirateShipImageView.setX(secondpirateShip.getPirateLocation2().x * scale);
			secondpirateShipImageView.setY(secondpirateShip.getPirateLocation2().y * scale);
			root.getChildren().add(secondpirateShipImageView);

		} catch (Exception ex) {
			System.out.println("Unable to open file" + pirateShipImage + "'");
			ex.printStackTrace();
		}

	}
	/* 
	 * Draws the cells of the map
	 */
	public void drawMap() {
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK); // We want the black outline
				rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
				root.getChildren().add(rect); // Add to the node tree in the pane
				if (oceanMap.Grid[x][y] == 1) {
					loadIslandImage(x, y);
				}
			}
		}
	}
	/* 
	 * Navigates the ship with keypresses
	 * checks if game is over and prompts Game Over and to press Reset
	 */
	public void navigation() {
//		System.out.println("Ship's Location : " + ship.getShipLocation().toString());
//		System.out.println("Pirate Ship 1's Location : " + pirateShip.getPirateLocation().toString());
//		System.out.println("Pirate Ship 2's : " + pirateShip.getPirateLocation2().toString());
//		System.out.println("----------------------------------------------");
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent key) {
				switch (key.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case DOWN:
					ship.goSouth();
					break;
				case UP:
					ship.goNorth();
					break;
				default:
					break;
				}
				updatePictures(shipImageView, ship.getShipLocation());
				updatePictures(pirateShipImageView, pirateShip.getPirateLocation());
				updatePictures(secondpirateShipImageView, pirateShip.getPirateLocation2());
//				System.out.println("Ship's Location : " + ship.getShipLocation().toString());
//				System.out.println("Pirate Ship 1's Location : " + pirateShip.getPirateLocation().toString());
//				System.out.println("Pirate Ship 2's : " + pirateShip.getPirateLocation2().toString());
//				System.out.println("----------------------------------------------");

				if (ship.getShipLocation().equals(pirateShip.getPirateLocation())
						|| ship.getShipLocation().equals(pirateShip.getPirateLocation2())) {
					//System.out.println("GameOver");
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Game Over");
					alert.setHeaderText("The pirateships got you. Press Reset to ty again");
					Optional<ButtonType> result = alert.showAndWait();
				}

			}

		});

	}
	/* 
	 * Updates Images to make sure images say with the object
	 */
	public void updatePictures(ImageView imageview, Point coords) {
		imageview.setX(coords.x * scale);
		imageview.setY(coords.y * scale);
	}

	@Override
	public void start(Stage OceanStage) throws Exception {
		oceanMap = new OceanMap(dimension, islandCount);
		islandMap = oceanMap.getMap();
		root = new AnchorPane();
		drawMap();
		ship = new Ship(oceanMap);
		pirateShip = new PirateShip(oceanMap);
		secondpirateShip = new PirateShip(oceanMap);
		ship.addObserver(pirateShip);
		loadPirateShipImage();
		loadSecondPirateShipImage();
		loadShipImage();
		Button reset = new Button();
		AnchorPane.setBottomAnchor(reset, 0.0);
		reset.setText("Reset");
		reset.setMinWidth(500);
		reset.setMaxWidth(500);
		reset.setOnAction(e -> {
			OceanExplorer app = new OceanExplorer();
			try {
				app.start(OceanStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		scene = new Scene(root, 500, 525);
		root.getChildren().add(reset);
		OceanStage.setTitle("Columbus Game");
		OceanStage.setScene(scene);
		OceanStage.setResizable(false);
		OceanStage.sizeToScene();
		OceanStage.show();
		navigation();
	}

	public static void main(String[] args) {
		launch(args);
	}

}