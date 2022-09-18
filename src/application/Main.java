package application;
	
import java.util.ArrayList;
import java.util.List;

import application.units.week;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class Main extends Application {
	//weeklist
	//main scene + button
	static List<week> weeks = application.db.getListWeek.getPostList() ;
	
	static TextFlow mainFlow = new TextFlow();
	static Scene mainScene = new Scene(mainFlow,800,300);
	
	static TextFlow updateFlow = new TextFlow();
	static Scene updateScene = new Scene(updateFlow,800,300);
	
	static TextField textField = new TextField();
	public static Button getReturnButton(Stage stage) {
		 Button btn = new Button();
	      btn.setText("✕");
	      btn.setOnAction(new EventHandler() {
	       
	          @Override
	          public void handle(Event event) {
	          stage.setTitle("todo change title");
	          stage.setScene(mainScene);
	          stage.show();
	          }
	      });
		return btn;
	}
	public static Button getUpdateButton(Stage stage,int k) {
		 Button btn = new Button();
	      btn.setText("upd content");
	      btn.setOnAction(new EventHandler() {
	       
	          @Override
	          public void handle(Event event) {
	          textField.setText(weeks.get(k).getContext() );
	          stage.setTitle(""+k);
	          stage.setScene(updateScene);
	          stage.show();
	          }
	      });
		return btn;
	}
	
		 Button submitButton = new Button();
		 Button addWeek = new Button();
	
		 		
	
	
	int i = 0;
	@Override
	public void start(Stage stage) {
	submitButton.setText("submit changes");
	submitButton.setOnAction(new EventHandler() {
	       
	          @Override
	          public void handle(Event event) {
	          
	          weeks.get(Integer.parseInt(stage.getTitle())).changeContext(textField.getText());
	          application.db.updateSingleWeek.update(Integer.parseInt(stage.getTitle())+1,textField.getText());
	          stage.setTitle("todo rename");
	          stage.setScene(mainScene);
	          stage.show();
	          }
	      });
	addWeek.setText("+");
	addWeek.setOnAction(new EventHandler() {

		@Override
		public void handle(Event arg0) {
			System.out.println(weeks.size());
			weeks.add(new week(weeks.size(),"-1 "+weeks.size()));
			application.db.addWeek.add(weeks.size());
			Button open = new Button();
			open.setText(""+(weeks.size()));
			open.setOnAction(new EventHandler() {@Override public void handle(Event event) {
				stage.setScene(weeks.get(Integer.parseInt(open.getText()) -1).getScene(stage,Integer.parseInt(open.getText()) -1));
				stage.show();}});
			mainFlow.getChildren().add(open);
			stage.setTitle("todo change this");
			stage.setScene(mainScene);
			System.out.println(weeks.size());
		}
		
	});
	
	textField.setMinHeight(100);
	textField.setMinWidth(400);
	
	
	updateFlow.getChildren().add(textField );
	updateFlow.getChildren().add(submitButton);
	updateFlow.getChildren().add(getReturnButton(stage));
	int k =0;
	while (k<weeks.size()) {
		Button open = new Button();
		open.setText(""+(k+1));
		open.setOnAction(new EventHandler() {@Override public void handle(Event event) {
			stage.setScene(weeks.get(Integer.parseInt(open.getText()) -1).getScene(stage,Integer.parseInt(open.getText()) -1));
			stage.show();}});
		mainFlow.getChildren().add(open);
		k++;
	} // loop end |||||
	mainFlow.getChildren().add(addWeek);
	stage.setScene(mainScene);
	stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}
