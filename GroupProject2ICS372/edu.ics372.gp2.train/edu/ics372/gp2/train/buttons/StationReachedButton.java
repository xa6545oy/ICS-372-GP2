package edu.ics372.gp2.train.buttons;

import edu.ics372.gp2.train.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StationReachedButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * the constructor to make StationReachedButton
	 * 
	 * @param the text on button when it made
	 */
	public StationReachedButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	/**
	 * the eventHandler to let trainStateContext knows when button is pressed
	 */
	@Override
	public void handle(ActionEvent arg0) {
		TrainContext.getInstance().onStationReached();
	}
}
