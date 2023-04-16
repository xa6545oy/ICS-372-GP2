package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

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

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		TrainContext.getInstance().showDoorStatus("Door opening in " + timer);
	}

	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainStopped();
	}

	@Override
	public void exit() {
		

	}

}
