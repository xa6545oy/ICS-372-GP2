package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.timer.Notifiable;

public class FullSpeedState extends TrainState {
	private static FullSpeedState instance;
	
	/*
	 * Private constructor for singleton pattern
	 */
	private FullSpeedState() {
		
	}
	
	/*
	 * Creating instance
	 * 
	 * @return the instance
	 */
	public static FullSpeedState getInstance() {
		if(instance == null) {
			instance = new FullSpeedState();
		}
		return instance;
	}
	
	@Override
	public void enter() {
		TrainContext.getInstance().showTrainFullSpeed();
		
	}

	@Override
	public void exit() {
		
	}
	
	/*
	 * When the train is reaching station, it decelerates
	 */
	@Override
	public void onStationReaching() {
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}

}
