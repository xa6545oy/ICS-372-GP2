module edu.ics372.gp2.train {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;

	exports edu.ics372.gp2.train.display to javafx.graphics;
	exports edu.ics372.gp2.train.start to javafx.graphics;
}