package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represent the state when the door is opening
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsOpeningState extends TrainState implements Notifiable {
	private static DoorsOpeningState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsOpeningState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DoorsOpeningState getInstance() {
		if (instance == null) {
			instance = new DoorsOpeningState();
		}
		return instance;
	}

	/**
	 * Process clock tick event. Show the time before doors are fully opened.
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorTimeBeforeOpened(timerValue);
	}

	/**
	 * Process timer runs out event. Enters doors opened state.
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(DoorsOpenedState.getInstance());
	}

	/**
	 * for when the state is entered. It takes 4 seconds for the doors to open fully
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 4);
		TrainContext.getInstance().showDoorsOpening();
		TrainContext.getInstance().showDoorTimeBeforeOpened(timer.getTimeValue());
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
