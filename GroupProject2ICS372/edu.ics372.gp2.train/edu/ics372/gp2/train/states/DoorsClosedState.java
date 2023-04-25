package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

/**
 * This class represent the state when the door is closed
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public class DoorsClosedState extends TrainState implements Notifiable {
	private static DoorsClosedState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DoorsClosedState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DoorsClosedState getInstance() {
		if (instance == null) {
			instance = new DoorsClosedState();
		}
		return instance;
	}

	/**
	 * Process timer tick event
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorsClosed();
		TrainContext.getInstance().showTimeBeforeAccelerating(timerValue);
	}

	/**
	 * Process timer runs out event. The train starts accelerating
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(AcceleratingState.getInstance());

	}

	/**
	 * when the state is entered it make a timer. After the doors are fully closed,
	 * the train starts moving (accelerating) after 3 seconds
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 3);
		TrainContext.getInstance().showDoorsClosed();

	}

	/**
	 * when exiting the state
	 */
	@Override
	public void exit() {
		timer.stop();
		timer = null;

	}
}
