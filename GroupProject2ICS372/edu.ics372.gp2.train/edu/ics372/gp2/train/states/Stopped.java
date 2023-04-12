package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

public class Stopped extends TrainState implements Notifiable {

	private static Stopped instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Stopped() {
		instance = this;
	}

	/**
	 * creating instance then returning it
	 * 
	 * @return the instance
	 */
	public static Stopped getInstance() {
		if (instance == null) {
			instance = new Stopped();
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

	/**
	 * Entering state
	 */
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		TrainContext.getInstance().showTrainStatus("Train Stopped!");
		timer = new Timer(this, 1);

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		TrainContext.getInstance().showTrainStatus("Train Stopped!");

	}

}
