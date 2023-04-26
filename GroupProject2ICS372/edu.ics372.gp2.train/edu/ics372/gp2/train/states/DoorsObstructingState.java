package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represent the state of door obstruction
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsObstructingState extends TrainState implements Notifiable {
	private static DoorsObstructingState instance;
	private Timer timer;
	private static double openTime;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsObstructingState(int elapsedTime) {
		instance = this;
		openTime = (5 - elapsedTime) * 0.8;

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return instance
	 */
	public static DoorsObstructingState getInstance(int elapsedTime) {
		if (instance == null) {
			instance = new DoorsObstructingState(elapsedTime);
		}
		openTime = (5 - elapsedTime) * 0.8;
		return instance;
	}
	
	/**
	 * Process clock tick event
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		TrainContext.getInstance().showDoorTimeBeforeOpened(timerValue);
	}

	/**
	 * Process when timer runs out
	 */
	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub
		TrainContext.getInstance().changeState(DoorsOpenedState.getInstance());
		// After fully reopening, the doors will reclose after 8 seconds. The doors may
		// again encounter obstruction and the process could repeat.
		// WORK ON THIS
	}

	/**
	 * when the state is entered. The reopening time is dependent on how far the
	 * door had closed
	 */
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		timer = new Timer(this, (int)openTime);
		TrainContext.getInstance().showDoorsOpening();
		TrainContext.getInstance().showDoorTimeBeforeOpened(timer.getTimeValue());
	}

	/**
	 * when the state is entered. Reset timer.
	 */
	@Override
	public void exit() {
		// TODO Auto-generated method stub
		timer.stop();
		timer = null;
	}

}
