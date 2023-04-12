package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

public class Accelerating extends TrainState implements Notifiable {
	private static Accelerating instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Accelerating() {

	}

	/**
	 * creating instance then returning it
	 * 
	 * @return the instance
	 */
	public static Accelerating getInstance() {
		if (instance == null) {
			instance = new Accelerating();
		}
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		TrainContext.getInstance().showTrainStatus("accelerating to full speed in " + timer);
	}

	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		timer.stop();
		timer = null;
	}

	/**
	 * When the train is reaching station, it decelerates
	 */
	@Override
	public void onStationReaching() {
		TrainContext.getInstance().changeState(Decelerating.getInstance());
	}

	/**
	 * When the train is reach the station, it stops
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(Stopped.getInstance());
	}

}
