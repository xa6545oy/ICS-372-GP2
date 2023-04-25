package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;
import edu.ics372.gp2.train.timer.Timer;

public class DoorsObstructingState extends TrainState implements Notifiable {
	private static DoorsObstructingState instance;
	private Timer timer;
	
	private DoorsObstructingState() {
		instance = this;
	}
	
	/**
	 * For the singleton pattern
	 * 
	 * @return the instance
	 */
	public static DoorsObstructingState getInstance() {
		if (instance == null) {
			instance = new DoorsObstructingState();
		}
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		TrainContext.getInstance().showDoorTimeBeforeOpened(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub
		TrainContext.getInstance().changeState(DoorsOpenedState.getInstance());
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		timer = new Timer(this, 4);
		TrainContext.getInstance().showDoorsOpening();
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		timer.stop();
		timer = null;
	}

}
