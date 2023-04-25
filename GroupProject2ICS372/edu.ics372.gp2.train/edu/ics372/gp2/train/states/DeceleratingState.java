package edu.ics372.gp2.train.states;

/**
 * This class represent the state when the train is decelerating
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DeceleratingState extends TrainState {
	private static DeceleratingState instance;

	/**
	 * create the instance and then return the instance
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
	 * Private constructor for the singleton pattern
	 */
	private DeceleratingState() {
		instance = this;
	}

	/**
	 * for when the StationReachedButton is pressed. The train receives a signal
	 * that it has arrived at a station.
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(StoppedState.getInstance());
		TrainContext.getInstance().showTrainStopped();
	}

	/**
	 * when the state is entered it will display that the train is decelerating
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainDecelerating();
	}

	/**
	 * when exiting the state
	 */
	@Override
	public void exit() {
		TrainContext.getInstance().showTrainDecelerating();
	}

}
