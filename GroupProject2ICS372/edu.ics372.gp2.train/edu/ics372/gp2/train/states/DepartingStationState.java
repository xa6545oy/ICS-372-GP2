package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represents the state when the train is about to depart the station
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DepartingStationState extends TrainState implements Notifiable {
	private static DepartingStationState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DepartingStationState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DepartingStationState getInstance() {
		if (instance == null) {
			instance = new DepartingStationState();
		}
		return instance;
	}

	/**
	 * Process timer tick event
	 * 
	 * @param time remaining in timer
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorsClosed();
		TrainContext.getInstance().showTimeBeforeAccelerating(timerValue);
	}

	/**
	 * Process timer runs out event. The train starts accelerating
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(AcceleratingState.getInstance());
	}

	/**
	 * When the state is entered it makes a timer. After the doors are fully closed,
	 * the train starts moving (accelerating) after 3 seconds
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 3);
		TrainContext.getInstance().showDoorsClosed();
		TrainContext.getInstance().showTimeBeforeAccelerating(timer.getTimeValue());
	}

	/**
	 * When exiting the state
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;
	}
}
