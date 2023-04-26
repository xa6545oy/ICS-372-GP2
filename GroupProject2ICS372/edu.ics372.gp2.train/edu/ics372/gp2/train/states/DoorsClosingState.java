package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represents the state when the doors are closing
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsClosingState extends TrainState implements Notifiable {
	private static DoorsClosingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsClosingState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return instance
	 */
	public static DoorsClosingState getInstance() {
		if (instance == null) {
			instance = new DoorsClosingState();
		}
		return instance;
	}

	/**
	 * Process clock tick event. Shows the door closing time.
	 * 
	 * @param time remaining in timer
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorTimeBeforeClosed(timerValue);
	}

	/**
	 * Process timer runs out event. Entering doors closed state.
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(DepartingStationState.getInstance());
	}
	
	/**
	 * Process obstruction of the doors
	 */
	@Override
	public void onDoorObstruction() {
		double openTime = (5 - timer.getTimeValue()) * 0.8;
		TrainContext.getInstance().changeState(DoorsOpeningState.getInstance((int)openTime, true));
	}

	/**
	 * When the state is entered. It takes 5s for the doors to close
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 5);
		TrainContext.getInstance().showDoorsClosing();
		TrainContext.getInstance().showDoorTimeBeforeClosed(timer.getTimeValue());
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
