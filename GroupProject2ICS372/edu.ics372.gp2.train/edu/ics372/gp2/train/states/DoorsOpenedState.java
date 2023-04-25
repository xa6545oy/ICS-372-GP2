package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represent the state when the door is opened
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsOpenedState extends TrainState implements Notifiable {
	private static DoorsOpenedState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsOpenedState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DoorsOpenedState getInstance() {
		if (instance == null) {
			instance = new DoorsOpenedState();
		}
		return instance;
	}

	/**
	 * Process clock tick event. Show the time doors remain in the fully-open
	 * position.
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorTimeBeforeClosing(timerValue);
	}

	/**
	 * Process timer runs out event. The doors start closing.
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(DoorsClosingState.getInstance());
	}

	/**
	 * when the state is entered. The doors remain in the fully-open position for 30
	 * seconds
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 10); // CHANGE THIS BACK TO 30
		TrainContext.getInstance().showDoorsOpened();
	}

	/**
	 * when the state is entered. Stops and resets timer.
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;
	}
}
