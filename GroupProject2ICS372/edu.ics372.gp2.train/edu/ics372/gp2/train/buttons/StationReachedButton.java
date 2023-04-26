package edu.ics372.gp2.train.buttons;

import edu.ics372.gp2.train.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This class represents the StationReachedButton
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class StationReachedButton extends GUIButton implements EventHandler<ActionEvent> {
	
	/**
	 * The constructor to make StationReachedButton
	 * 
	 * @param the text on button when it made
	 */
	public StationReachedButton(String string) {
		super(string);
	}

	/**
	 * The eventHandler to let TrainContext knows when button is pressed
	 * 
	 * @param ActionEvent of button being pressed
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().onStationReached();
	}
}
