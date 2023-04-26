package edu.ics372.gp2.train.buttons;

import edu.ics372.gp2.train.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This class represents the StationReachingButton
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class StationReachingButton extends GUIButton implements EventHandler<ActionEvent> {
	
	/**
	 * The constructor to make StationReachingButton
	 * 
	 * @param the text on button when it made
	 */
	public StationReachingButton(String string) {
		super(string);
	}

	/*
	 * The eventHandler to let TrainContext knows when button is pressed
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().stationReaching();
	}
}
