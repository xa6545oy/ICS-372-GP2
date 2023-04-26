package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represents the state when the doors are opening
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsOpeningState extends TrainState implements Notifiable {
	private static DoorsOpeningState instance;
	private Timer timer;
	private static int openTime;
	private static boolean obstructed;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsOpeningState(int time, boolean obstructed) {
		instance = this;
		openTime = time;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DoorsOpeningState getInstance(int time, boolean obstruction) {
		if (instance == null) {
			instance = new DoorsOpeningState(time, obstruction);
		}
		obstructed = obstruction;
		openTime = time;
		return instance;
	}

	/**
	 * Process clock tick event. Show the time before doors are fully opened.
	 * 
	 * @param time remaining in timer
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
		TrainContext.getInstance().changeState(DoorsOpenedState.getInstance(obstructed));
	}

	/**
	 * When the state is entered. It takes 4 seconds for the doors to open fully,
	 * otherwise slightly less due to a DoorObstruction detected.
	 */
	@Override
	public void enter() {
		timer = new Timer(this, openTime);
		TrainContext.getInstance().showDoorsOpening();
		TrainContext.getInstance().showDoorTimeBeforeOpened(timer.getTimeValue());
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
