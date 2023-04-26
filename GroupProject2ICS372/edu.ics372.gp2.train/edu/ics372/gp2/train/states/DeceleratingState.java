package edu.ics372.gp2.train.states;

/**
 * This class represents the state when the train is decelerating
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DeceleratingState extends TrainState {
	private static DeceleratingState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DeceleratingState() {
		instance = this;
	}
	
	/**
	 * Create the instance if needed then return the instance
	 * 
	 * @return instance
	 */
	public static DeceleratingState getInstance() {
		if (instance == null) {
			instance = new DeceleratingState();
		}
		return instance;
	}

	/**
	 * For when the StationReachedButton is pressed. The train receives a signal
	 * that it has arrived at a station and changes states.
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(ArrivedStationState.getInstance());
		TrainContext.getInstance().showTrainStopped();
	}

	/**
	 * When the state is entered it will display that the train is decelerating
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainDecelerating();
	}

	/**
	 * When exiting the state
	 */
	@Override
	public void exit() {
	}
}
