package edu.ics372.gp2.train.states;

/**
 * Super class for all states
 * 
 */
public abstract class TrainState {

	/**
	 * method for when is entering a state
	 */
	public abstract void enter();

	/**
	 * method for when is exiting a state
	 */
	public abstract void exit();

	/**
	 * method for when StationReaching Button is pressed
	 */
	public void onStationReaching() {
		// TODO Auto-generated method stub

	}

	/**
	 * method for when StationReached Button is pressed
	 */
	public void onStationReached() {
		// TODO Auto-generated method stub

	}
}
