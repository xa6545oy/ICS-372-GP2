package edu.ics372.gp2.train.display;

public interface TrainDisplay {
	/*
	 * indicate remaining time.
	 */
	public void showTimeLeft(int time);

	/*
	 * indicate train current status
	 */
	public void showTrainStatus(String text);

	/*
	 * indicate door current status
	 */
	public void showDoorStatus(String text);
}
