package edu.ics372.gp2.train.buttons;

import edu.ics372.gp2.train.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StationReachingButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * the constructor to make StationReachingButton
	 * 
	 * @param the text on button when it made
	 */
	public StationReachingButton(String string) {
		super(string);
	}

	/*
	 * the eventHandler to let trainStateContext knows when button is pressed
	 * 
	 * @param ActionEvent is the StationReaching Button is clicked
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().stationReaching();
	}
}
