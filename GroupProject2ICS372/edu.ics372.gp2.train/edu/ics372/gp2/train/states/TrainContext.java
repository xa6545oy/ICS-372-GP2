package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.display.TrainDisplay;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class TrainContext {
	private TrainDisplay trainDisplay;
	private TrainState trainState;
	private static TrainContext instance;

	/*
	 * Make a singleton
	 */
	public TrainContext() {
		instance = null;
		trainState = Accelerating.getInstance();
	}

	/**
	 * Returns the instance
	 * 
	 * @return the object
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}

	/**
	 * Gets the display reference in case it changes
	 * 
	 * @param trainDisplay The current display object
	 */
	public void setDisplay(TrainDisplay trainDisplay) {
		this.trainDisplay = trainDisplay;
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState The next state
	 */
	public void changeState(TrainState nextState) {
		trainState.exit();
		trainState = nextState;
		trainState.enter();
	}

	/**
	 * Invokes right method of display, helps protect the states from changes to the
	 * way the system uses the state changes
	 * 
	 * @param time Time left for cooking
	 */
	public void showTimeLeft(int time) {
		trainDisplay.showTimeLeft(time);
	}

	public void showTrainStatus(String text) {
		trainDisplay.showStatus(text);
	}

	public void showDoorStatus(String text) {
		trainDisplay.showDoorStatus(text);
	}

}
