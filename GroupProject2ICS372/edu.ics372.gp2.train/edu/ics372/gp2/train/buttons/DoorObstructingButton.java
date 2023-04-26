package edu.ics372.gp2.train.buttons;

import edu.ics372.gp2.train.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This class represents the DoorObstructingButton
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorObstructingButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * Constructor to create DoorObstructingButton
	 * 
	 * @param the text on button when it made
	 */
	public DoorObstructingButton(String string) {
		super(string);
	}

	/**
	 * The eventHandler to let TrainContext knows when button is pressed
	 * 
	 * @param ActionEvent of button being pressed
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().onDoorObstructing();
	}
}
