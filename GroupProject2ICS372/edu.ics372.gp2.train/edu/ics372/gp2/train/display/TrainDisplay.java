package edu.ics372.gp2.train.display;

public interface TrainDisplay {
	/*
	 * indicate remaining time.
	 */
	public void showTimeLeft(String text);

	/*
	 * indicate train current status
	 */
	public void showTrainStatus(String text);

	/*
	 * indicate door current status
	 */
//	public void showDoorStatus(String text);

	/**
	 * Indicate that the train is stopped
	 */
	public void showTrainStopped();

	/**
	 * Indicate that the train is speeding up
	 */
	public void showTrainAccelerating();

	/**
	 * Indicate that the train is slowing down
	 */
	public void showTrainDecelerating();

	/**
	 * Indicate that train is going full speed
	 */
	public void showTrainFullSpeed();

	/**
	 * Indicate that the door is now open
	 */
	public void showDoorOpened();

	/**
	 * indicate that door is opening
	 */
	public void showDoorOpening();

	/**
	 * indicate that door is closed
	 */
	public void showDoorClosed();

	/**
	 * indicate that door is closing
	 */
	public void showDoorCLosing();

	/**
	 * indicate that door is obstructed
	 */
	public void showDoorObstruction();

}
