package application.units;

import application.Main;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class week {
	
	public week() {
		super();
	}
	public week(int id, String context) {
		super();
		this.id = id;
		this.context = context;
	}
	private int id;
	private String context;
	public int getId() {
		return id;
	}
	public String getContext() {
		return context;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Scene getScene(Stage stage, int k) {
		TextFlow a = new TextFlow();
		a.getChildren().add(new Text(this.getContext()));
		a.getChildren().add(application.Main.getReturnButton(stage));
		a.getChildren().add(Main.getUpdateButton(stage, k));
		return new Scene(a,800,300);
	}
	public void changeContext(String a) {
		this.context = a;
	}
	//update scene button
}
