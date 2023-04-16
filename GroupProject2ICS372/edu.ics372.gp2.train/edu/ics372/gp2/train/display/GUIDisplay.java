package edu.ics372.gp2.train.display;

import edu.ics372.gp2.train.buttons.DoorObstructingButton;
import edu.ics372.gp2.train.buttons.GUIButton;
import edu.ics372.gp2.train.buttons.StationReachedButton;
import edu.ics372.gp2.train.buttons.StationReachingButton;
import edu.ics372.gp2.train.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIDisplay extends Application implements TrainDisplay {
	// Instance Variables
	private GUIButton doorObstructing;
	private GUIButton stationReached;
	private GUIButton stationReaching;
	private Text trainStatus = new Text("Train Accelerating");
	private Text doorStatus = new Text("Door Closed");

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		doorObstructing = new DoorObstructingButton("Door Obstructing");
		stationReached = new StationReachedButton("Station Reached");
		stationReaching = new StationReachingButton("Station Reaching");
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(trainStatus, 0, 0);
		pane.add(doorStatus, 1, 0);
		pane.add(stationReaching, 2, 0);
		pane.add(stationReached, 3, 0);
		pane.add(doorObstructing, 4, 0);
//		showDoorClosed();
//		showLightOff();
//		showTimeLeft(0);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train Program");
		TrainContext.getInstance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * show remaining time
	 */
	@Override
	public void showTimeLeft(int time) {
		trainStatus.setText("" + time);
	}

	/**
	 * Show current train Status
	 */
	@Override
	public void showStatus(String text) {
		System.out.println(text);
		//trainStatus.setText(text);
	}

	/**
	 * Show current door Status
	 */
	@Override
	public void showDoorStatus(String text) {
		doorStatus.setText(text);
	}
	
	/*
	 * Show train decelerating status
	 */
	@Override
	public void showTrainDecelerating() {
		trainStatus.setText("Train Decelerating");
	}

}
