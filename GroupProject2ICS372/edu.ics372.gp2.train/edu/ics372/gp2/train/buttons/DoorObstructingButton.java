package edu.ics372.gp2.train.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DoorObstructingButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * constructor to create doorObstructionButton
	 * 
	 * @param the text on button when it made
	 */
	public DoorObstructingButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	/**
	 * the eventHandler to let trainStateContext knows when button is pressed
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().onDoorsObstructing();

	}

}
