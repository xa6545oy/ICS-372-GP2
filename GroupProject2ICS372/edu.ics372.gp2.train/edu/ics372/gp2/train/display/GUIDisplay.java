package edu.ics372.gp2.train.display;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIDisplay extends Application implements TrainDisplay {
	// Instance Variables
	
	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
//		doorCloser = new DoorCloseButton("close door");
//		doorOpener = new DoorOpenButton("open door");
//		cookButton = new CookButton("cook");
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
//		pane.add(doorStatus, 0, 0);
//		pane.add(lightStatus, 1, 0);
//		pane.add(timerValue, 2, 0);
//		pane.add(cookingStatus, 3, 0);		commented all of this out just to keep a reference
//		pane.add(doorCloser, 4, 0);
//		pane.add(doorOpener, 5, 0);
//		pane.add(cookButton, 6, 0);
//		showDoorClosed();
//		showLightOff();
//		showTimeLeft(0);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train Program");
//		MicrowaveContext.getInstance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

}
