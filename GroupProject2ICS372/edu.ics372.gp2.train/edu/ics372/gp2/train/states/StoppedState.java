package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represent the state when the train is stopped
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class StoppedState extends TrainState implements Notifiable {

	private static StoppedState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private StoppedState() {
		instance = this;
	}

	/**
	 * creating instance then returning it
	 * 
	 * @return the instance
	 */
	public static StoppedState getInstance() {
		if (instance == null) {
			instance = new StoppedState();
		}
		return instance;
	} // end getInstance()

	/**
	 * Process timer tick event
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
		TrainContext.getInstance().changeState(DoorsOpeningState.getInstance(4));
	}

	/**
	 * for when the state is entered. 1 second after the train stops, the doors of
	 * the train start opening
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 1);
		TrainContext.getInstance().showTrainStopped();
		TrainContext.getInstance().showDoorTimeBeforeOpening(timer.getTimeValue());
	}

	/**
	 * for when the state is exit. Shows train is completely stopped and reset timer
	 */
	@Override
	public void exit() {
		TrainContext.getInstance().showTrainStopped();
		timer.stop();
		timer = null;
	}

}
