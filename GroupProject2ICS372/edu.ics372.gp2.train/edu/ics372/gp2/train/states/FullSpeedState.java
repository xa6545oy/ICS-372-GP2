package edu.ics372.gp2.train.states;

/**
 * This class represents the state when the train is at full speed
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class FullSpeedState extends TrainState {
	private static FullSpeedState instance;

	/*
	 * Private constructor for singleton pattern
	 */
	private FullSpeedState() {
		instance = this;
	}

	/*
	 * Creating instance if necessary
	 * 
	 * @return the instance
	 */
	public static FullSpeedState getInstance() {
		if (instance == null) {
			instance = new FullSpeedState();
		}
		return instance;
	}

	/**
	 * When the state is entered it will display that the train is full speed
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainFullSpeed();

	}

	/**
	 * For when exiting the state
	 */
	@Override
	public void exit() {
	}

	/*
	 * When the train is reaching station, it decelerates.
	 */
	@Override
	public void onStationReaching() {
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}
}
