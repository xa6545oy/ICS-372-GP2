package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;

public class DeceleratingState extends TrainState implements Notifiable {
	private static DeceleratingState instance;

	/**
	 * create the instance and then return the instance
	 */
	public static DeceleratingState getInstance() {
		if (instance == null) {
			instance = new DeceleratingState();
		}
		return instance;
	}

	/**
	 * Private constructor for the singleton pattern
	 */
	private DeceleratingState() {
		instance = this;
	}

	/**
	 * for when the StationReachedButton is pressed
	 */
	@Override
	public void onStationReached() {
		TrainContext.getInstance().changeState(StoppedState.getInstance());
	}

	/**
	 * when the state is entered it will display that the train is decelerating
	 */
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainDecelerating();
	}

	/**
	 * when exiting the state
	 */
	@Override
	public void exit() {
		
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
