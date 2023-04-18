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

	/**
	 * Process timer tick event
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showDoorTimeBeforeOpened(timerValue);
	}

	/**
	 * Process timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(DoorsOpeningState.getInstance());
	}

	/**
	 * for when the state is entered. 1 second after the train stops, the doors of
	 * the train start opening
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 1);
		TrainContext.getInstance().showTrainStopped();
	}

	/**
	 * for when the state is exit
	 */
	@Override
	public void exit() {
		TrainContext.getInstance().showTrainStopped();
	}

}
