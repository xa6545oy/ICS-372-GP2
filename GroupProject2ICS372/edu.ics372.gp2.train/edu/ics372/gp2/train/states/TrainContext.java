package edu.ics372.gp2.train.states;

import edu.ics372.gp2.train.display.TrainDisplay;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class TrainContext {
	private TrainDisplay trainDisplay;
	private TrainState currentState;
	private static TrainContext instance;

	/*
	 * Make a singleton
	 */
	public TrainContext() {
		instance = this;
		currentState = AcceleratingState.getInstance();
	}

	/**
	 * Returns the instance
	 * 
	 * @return the object
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}

	/**
	 * Gets the display reference in case it changes
	 * 
	 * @param trainDisplay The current display object
	 */
	public void setDisplay(TrainDisplay trainDisplay) {
		this.trainDisplay = trainDisplay;
	}

	/**
	 * Called from the states to change the current state. It calls a method exit()
	 * to exit the current state. Then it sets the current state to the nextState
	 * and calls a method enter() to enter into the next state.
	 * 
	 * @param nextState The next state
	 */
	public void changeState(TrainState nextState) {
		currentState.exit();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Invokes right method of display, helps protect the states from changes to the
	 * way the system uses the state changes
	 * 
	 * @param time Time left for cooking
	 */
	public void showTimeLeft(int time) {
		String stringTime = Integer.toString(time);
		trainDisplay.showTimeLeft(stringTime);
	}

	public void showTrainStatus(String text) {
		trainDisplay.showTrainStatus(text);
	}

	/*
	 * Station Reaching button is pressed. Invokes the onStationReaching() method in
	 * the current state to transition to another state
	 */
	public void stationReaching() {
		currentState.onStationReaching();

	}

	/*
	 * Changes the display to show that the train is decelerating
	 */
	public void showTrainDecelerating() {
		trainDisplay.showTrainStatus("Train Decelerating");
		trainDisplay.showTimeLeft("Waiting for stop signal");
	}

	/*
	 * Station Reached button is pressed. Invokes the onStationReached() method in
	 * the current state to transition to another state
	 */
	public void onStationReached() {
		currentState.onStationReached();
	}

	/**
	 * When an door obstructing is clicked on
	 */
	public void onDoorObstructing() {
		currentState.onDoorObstruction();
	}

	/*
	 * Changes the display to show that the train is stopped
	 */
	public void showTrainStopped() {
		trainDisplay.showTrainStatus("Train Stopped");
	}

	/*
	 * To enter the accelerating state at the start of the program
	 */
	public void initialState() {
		currentState.enter();
	}

	/*
	 * Changes display to show that the train is accelerating
	 */
	public void showTrainAccelerating() {
		trainDisplay.showTrainStatus("Train Accelerating");
	}

	/*
	 * Changes display to show that the train is at max speed
	 */
	public void showTrainFullSpeed() {
		trainDisplay.showTrainStatus("Train Max Speed");
		trainDisplay.showTimeLeft("Waiting for signal to decelerate");
	}

	/*
	 * Changes display to show that the door is opening
	 */
	public void showDoorsOpening() {
		trainDisplay.showTrainStatus("Doors Opening");
	}

	/*
	 * Changes display to show that the door is closing
	 */
	public void showDoorsClosing() {
		trainDisplay.showTrainStatus("Doors Closing");
	}

	/*
	 * Changes display to show that the door is Opened
	 */
	public void showDoorsOpened() {
		trainDisplay.showTrainStatus("Doors Opened");
	}

	/*
	 * Changes display to show that the door is Closed
	 */
	public void showDoorsClosed() {
		trainDisplay.showTrainStatus("Doors Closed");
	}

	/*
	 * Shows the time before the train reaches max speed
	 */
	public void showTimeBeforeMaxSpeed(int timerValue) {
		String timeBeforeMaxSpeed = timerValue + " seconds left until train reaches full speed";
		trainDisplay.showTimeLeft(timeBeforeMaxSpeed);
	}

	/*
	 * Shows the time before the doors are completely opened
	 */
	public void showDoorTimeBeforeOpened(int timerValue) {
		String timeBeforeOpened = timerValue + " seconds left until doors are opened";
		trainDisplay.showTimeLeft(timeBeforeOpened);
	}

	/*
	 * Shows the time while doors are opening
	 */
	public void showDoorTimeBeforeClosing(int timerValue) {
		String timeBeforeClosing = timerValue + " seconds left until doors are closing";
		trainDisplay.showTimeLeft(timeBeforeClosing);
	}

	/*
	 * Shows the time before the doors are completely opened
	 */
	public void showDoorTimeBeforeClosed(int timerValue) {
		String timeBeforeClosed = timerValue + " seconds left until doors are closed";
		trainDisplay.showTimeLeft(timeBeforeClosed);
	}

	/*
	 * Shows the time while doors are closing
	 */
	public void showDoorTimeBeforeOpening(int timerValue) {
		String timeBeforeOpening = timerValue + " seconds left until doors are opening";
		trainDisplay.showTimeLeft(timeBeforeOpening);
	}

	/*
	 * Shows the time before the train accelerating
	 */
	public void showTimeBeforeAccelerating(int timerValue) {
		String timeBeforeAccelerating = timerValue + " seconds left until train accelerating";
		trainDisplay.showTimeLeft(timeBeforeAccelerating);
	}
}