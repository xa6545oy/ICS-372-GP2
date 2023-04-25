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
	private long totalClosingTime;
	private int reopenTime;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsObstructingState(long totalClosingTime) {
		instance = this;
		this.totalClosingTime = totalClosingTime;

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return instance
	 */
	public static DoorsObstructingState getInstance(long totalClosingTime) {
		if (instance == null) {
			instance = new DoorsObstructingState(totalClosingTime);
		}
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
	}

	/**
	 * when the state is entered.
	 */
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		reopenTime = (int) (totalClosingTime * 4 / 5);
		timer = new Timer(this, reopenTime);
		TrainContext.getInstance().showDoorsOpening();
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
