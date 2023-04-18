package edu.ics372.gp2.train.states;

public class FullSpeedState extends TrainState {
	private static FullSpeedState instance;

	/*
	 * Private constructor for singleton pattern
	 */
	private FullSpeedState() {
		instance = this;
	}

	/*
	 * Creating instance
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
	 * when the state is entered it will display that the train is full speed
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainFullSpeed();

	}

	@Override
	public void exit() {

	}

	/*
	 * When the train is reaching station, it decelerates
	 */
	@Override
	public void onStationReaching() {
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}

	/*
	 * When the train is completely reached station, it stops
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(StoppedState.getInstance());
	}

}
