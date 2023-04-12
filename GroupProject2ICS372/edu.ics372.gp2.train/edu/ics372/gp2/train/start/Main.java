package edu.ics372.gp2.train.start;

import edu.ics372.gp2.train.display.GUIDisplay;
import edu.ics372.gp2.train.timer.Clock;

import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}
