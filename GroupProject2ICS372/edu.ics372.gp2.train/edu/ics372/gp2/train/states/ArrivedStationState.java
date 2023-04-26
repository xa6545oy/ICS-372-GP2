package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represents the state when the train has arrived at the station
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class ArrivedStationState extends TrainState implements Notifiable {
	private static ArrivedStationState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ArrivedStationState() {
		instance = this;
	}

	/**
	 * Creating instance if needed then returning it
	 * 
	 * @return the instance
	 */
	public static ArrivedStationState getInstance() {
		if (instance == null) {
			instance = new ArrivedStationState();
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
		TrainContext.getInstance().showDoorTimeBeforeOpening(timerValue);
	}

	/**
	 * Process timer runs out event. Enters doors opening state
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(DoorsOpeningState.getInstance(4, false));
	}

	/**
	 * For when the state is entered. 1 second after the train stops, the doors of
	 * the train start opening
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 1);
		TrainContext.getInstance().showTrainStopped();
		TrainContext.getInstance().showDoorTimeBeforeOpening(timer.getTimeValue());
	}

	/**
	 * For when the state is exited. Stops the timer and sets it to null
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;
	}
}
