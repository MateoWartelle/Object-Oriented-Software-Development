import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToolBar;

import java.awt.Point;
import java.util.Random;

@SuppressWarnings("unused")
public class OceanExplorer extends Application {
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

	AnchorPane root;
	Scene scene;
	Ship ship;

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

	private void loadIslandImage(int x, int y) {
		try {
			Image islandImage = new Image("pirateIsland.PNG", 50, 50, true, true);
			islandImageView = new ImageView(islandImage);
			islandImageView.setX(x * scale);
			islandImageView.setY(y * scale);
			root.getChildren().add(islandImageView);
		} catch (Exception ex) {
			System.out.println("Unable to open file" + islandImage + "'");
			ex.printStackTrace();
		}

	}

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

	public void reset_grid_button() {
		
	}

	public void navigation() {
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

			}
		});

	}

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
		ship.addObserver(pirateShip);

		loadPirateShipImage();
		loadShipImage();
		Button reset = new Button();
		ToolBar toolBar = new ToolBar(new Button("Reset"));
		
		

		reset.setText("Reset");
		reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				reset_grid_button();
			}
		});

		scene = new Scene(root, 500, 500);
		root.getChildren().add(toolBar);
		OceanStage.setTitle("Columbus Game");
		OceanStage.setScene(scene);
		OceanStage.show();
		navigation();

	}

	public static void main(String[] args) {
		launch(args);
	}

}