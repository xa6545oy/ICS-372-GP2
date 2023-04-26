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

/**
 * GUI to implement the TrainDisplay interface
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 *
 */
public class GUIDisplay extends Application implements TrainDisplay {
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
		primaryStage.setMinWidth(750);
		primaryStage.setMaxWidth(800);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * Indicate time remaining in state if time constrained,
	 * otherwise displays details about state.
	 * 
	 * @param text describing time in state
	 */
	@Override
	public void showTimeLeft(String text) {
		stateInfo.setText(text);
	}

	/**
	 * Indicate current train state.
	 * 
	 * @param text describing current train state
	 */
	@Override
	public void showTrainStatus(String text) {
		trainStatus.setText(text);
	}
}