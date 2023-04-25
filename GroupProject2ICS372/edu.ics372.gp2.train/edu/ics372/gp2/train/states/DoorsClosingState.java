package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

public class DoorsClosingState extends TrainState implements Notifiable {
	private static DoorsClosingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsClosingState() {
		instance = this;
	}

	public static DoorsClosingState getInstance() {
		if (instance == null) {
			instance = new DoorsClosingState();
		}
		return instance;
	}

	/**
	 * Process clock tick event
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorTimeBeforeClosed(timerValue);

	}

	/**
	 * Process timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(DoorsClosedState.getInstance());

	}
	
	public void onDoorObstruction() {
		TrainContext.getInstance().changeState(DoorsObstructingState.getInstance());
	}

	/**
	 * when the state is entered. It takes 5s for the doors to close
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 5);
		TrainContext.getInstance().showDoorsClosing();
	}

	/**
	 * when the state is entered. Reset timer.
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;
	}

}
