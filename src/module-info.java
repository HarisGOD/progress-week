module progressweek {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
