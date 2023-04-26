package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represents the state when the doors are opened
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsOpenedState extends TrainState implements Notifiable {
	private static DoorsOpenedState instance;
	private Timer timer;
	private static int timeOpen;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsOpenedState() {
		instance = this;
		timeOpen = 10;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DoorsOpenedState getInstance(boolean obstruction) {
		if (instance == null) {
			instance = new DoorsOpenedState();
		}
		timeOpen = obstruction ? 5 : 10;
		return instance;
	}

	/**
	 * Process clock tick event. Show the time doors remain in the fully-open
	 * position.
	 * 
	 * @param time remaining in timer
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
	 * When the state is entered the doors remain in the fully-open position for 30
	 * seconds, unless an obstruction was detected then they will be open for 8 seconds.
	 */
	@Override
	public void enter() {
		timer = new Timer(this, timeOpen);
		TrainContext.getInstance().showDoorsOpened();
		TrainContext.getInstance().showDoorTimeBeforeClosing(timer.getTimeValue());
	}

	/**
	 * When the state is exited. Stops and sets timer to null.
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;
	}
}
