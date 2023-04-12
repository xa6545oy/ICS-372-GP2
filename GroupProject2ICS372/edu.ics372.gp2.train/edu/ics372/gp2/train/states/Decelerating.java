package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;

public class Decelerating extends TrainState implements Notifiable {
	private static Decelerating instance;

	/**
	 * create the instance and then return the instance
	 */
	public static Decelerating getInstance() {
		if (instance == null) {
			instance = new Decelerating();
		}
		return instance;
	}

	/**
	 * Private constructor for the singleton pattern
	 */
	private Decelerating() {
		instance = this;
	}

	/**
	 * for when the StationReachedButton is pressed
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(Stopped.getInstance());
	}

	/**
	 * when the state is entered
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainStatus("Train Deccelerating");
	}

	/**
	 * when exiting the state
	 */
	@Override
	public void exit() {
		TrainContext.getInstance().showTrainStatus("Train Deccelerating");
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub

	}

}
