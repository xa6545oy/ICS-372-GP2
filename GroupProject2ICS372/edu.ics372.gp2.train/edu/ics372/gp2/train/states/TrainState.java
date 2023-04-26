package edu.ics372.gp2.train.states;

/**
 * Super class for all states
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 */
public abstract class TrainState {

	/**
	 * Method for when entering a state
	 */
	public abstract void enter();

	/**
	 * Method for when exiting a state
	 */
	public abstract void exit();

	/**
	 * Method for when StationReaching Button is pressed
	 */
	public void onStationReaching() {}

	/**
	 * Method for when StationReached Button is pressed
	 */
	public void onStationReached() {}
	
	/**
	 * Method for when the train accelerates for 6 seconds, then it reaches full speed state
	 */
	public void reachFullSpeed() {}

	/**
	 * Method for when an obstruction is detected
	 */
	public void onDoorObstruction() {}
	
	/**
	 * Process clock tick Generates the timer runs out event
	 * 
	 * @param time remaining in timer
	 */
	public void onTimerTick(int timerValue) {}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {}
}
