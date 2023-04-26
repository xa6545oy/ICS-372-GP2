package edu.ics372.gp2.train.display;

/**
 * Specifies what the display system can do. Specifics are implemented
 * within the TrainContext class so that these methods can be used for all cases.
 * 
 * @author Uyen Ngo, Tai Vu, Ethan Lo, Thomas Morgenstern
 *
 */
public interface TrainDisplay {
	/**
	 * Indicate time remaining in state if time constrained,
	 * otherwise displays details about state.
	 * 
	 * @param text describing time in state
	 */
	public void showTimeLeft(String text);

	/**
	 * Indicate current train state.
	 * 
	 * @param text describing current train state
	 */
	public void showTrainStatus(String text);

}