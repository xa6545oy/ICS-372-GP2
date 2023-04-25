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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIDisplay extends Application implements TrainDisplay {
	// Instance Variables
	private GUIButton doorObstructing;
	private GUIButton stationReached;
	private GUIButton stationReaching;
	private Text trainStatus = new Text("Train Accelerating");
	private Text stateInfo = new Text("");

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		doorObstructing = new DoorObstructingButton("Door Obstructing");
		stationReached = new StationReachedButton("Station Reached");
		stationReaching = new StationReachingButton("Station Reaching");
		trainStatus.setWrappingWidth(250);
		trainStatus.setTextAlignment(TextAlignment.CENTER);
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(trainStatus, 0, 0);
		pane.add(stateInfo, 1, 0);
		pane.add(stationReaching, 2, 0);
		pane.add(stationReached, 3, 0);
		pane.add(doorObstructing, 4, 0);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train Program");
		TrainContext.getInstance().setDisplay(this);
		TrainContext.getInstance().initialState();
		primaryStage.setMinWidth(900);
		primaryStage.setMaxWidth(1000);
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
	public void showTimeLeft(String text) {
		stateInfo.setText(text);
	}

	/**
	 * Show current train Status
	 */
	@Override
	public void showTrainStatus(String text) {
		trainStatus.setText(text);
	}

	/**
	 * Show current door Status
	 */
//	@Override
//	public void showDoorStatus(String text) {
//		stateInfo.setText(text);
//	}

	/**
	 * show train stopped
	 */
	@Override
	public void showTrainStopped() {
		trainStatus.setText("train stopped");
	}

	/**
	 * show train accelerating
	 */
	@Override
	public void showTrainAccelerating() {
		trainStatus.setText("train accelerating");

	}

	/**
	 * show train decelerating
	 */
	@Override
	public void showTrainDecelerating() {
		trainStatus.setText("train decelerating");

	}

	/**
	 * show train is going full speed
	 */
	@Override
	public void showTrainFullSpeed() {
		trainStatus.setText("full speed");
		//stateInfo.setText("waiting for signal to decelerate");
	}

	/**
	 * show door is opened
	 */
	@Override
	public void showDoorOpened() {
		stateInfo.setText("door opened");

	}

	/**
	 * show door is opening
	 */
	@Override
	public void showDoorOpening() {
		trainStatus.setText("door opening");

	}

	/**
	 * show door is closed
	 */
	@Override
	public void showDoorClosed() {
		stateInfo.setText("door closed");

	}

	/**
	 * show door closing
	 */
	@Override
	public void showDoorCLosing() {
		trainStatus.setText("door closing");
	}

	/**
	 * show when door is obstructed
	 */
	@Override
	public void showDoorObstruction() {
		stateInfo.setText("door obstructed");

	}

}