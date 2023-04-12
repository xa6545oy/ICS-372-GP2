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

}
