package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

public class AcceleratingState extends TrainState implements Notifiable {
	private static AcceleratingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private AcceleratingState() {
		instance = this;
	}

	/**
	 * creating instance then returning it
	 * 
	 * @return the instance
	 */
	public static AcceleratingState getInstance() {
		if (instance == null) {
			instance = new AcceleratingState();
		}
		return instance;
	}

	/**
	 * Process timer tick event
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeBeforeMaxSpeed(timerValue);
	}

	/**
	 * Process timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(FullSpeedState.getInstance());
	}

	/**
	 * When the state is entered it make a timer. After starting from a station, the
	 * train accelerates for 6 seconds
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 6);
		TrainContext.getInstance().showTrainAccelerating();
	}

	/**
	 * when exiting the state stop timer and make it null
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;
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