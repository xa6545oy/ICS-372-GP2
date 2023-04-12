module edu.ics372.gp2.train {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;

	opens edu.ics372.gp2.train.start to javafx.graphics, javafx.fxml;

	exports edu.ics372.gp2.train.display to javafx.graphics;
	exports edu.ics372.gp2.train.start to javafx.graphics;
}