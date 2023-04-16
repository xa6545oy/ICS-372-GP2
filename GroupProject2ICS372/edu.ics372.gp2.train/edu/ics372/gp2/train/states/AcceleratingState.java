package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

public class AcceleratingState extends TrainState implements Notifiable {
	private static AcceleratingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private AcceleratingState() {

	}

	/**
	 * creating instance then returning it
	 * 
	 * @return the instance
	 */
	public static AcceleratingState getInstance() {
		if (instance == null) {
			instance = new AcceleratingState();
		}
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTrainStatus("accelerating to full speed in " + timer);
	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
	}

	/**
	 * when the state is entered it make a timer
	 */
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		timer = new Timer(this, 6);
	}

	/**
	 * when exiting the state stop timer and make it null
	 */
	@Override
	public void exit() {
		//timer.stop();
		//timer = null;
	}

	/*
	 * When the train is reaching station, it decelerates
	 */
	@Override
	public void onStationReaching() {
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}

	/**
	 * When the train is reach the station, it stops
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(Stopped.getInstance());
	}

}