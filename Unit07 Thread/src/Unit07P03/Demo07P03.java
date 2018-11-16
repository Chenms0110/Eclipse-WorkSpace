package Unit07P03;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;


public class Demo07P03 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Button btnPause= new Button("pause");
		Button btnContinue = new Button("Continue");
		
		HBox lpane = new HBox(30);
		lpane.getChildren().addAll(btnPause,btnContinue);
		lpane.setAlignment(Pos.CENTER);
		
		ClockPane clock = new ClockPane();
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lpane);
		
		EventHandler<ActionEvent> eventHandler = e ->{
			clock.setCurrentTime();
		};
		
		Timeline animation = new Timeline(
			new KeyFrame(Duration.millis(1000),eventHandler));
	    animation.setCycleCount(Timeline.INDEFINITE);
	    animation.play(); // Start animation
		btnPause.setOnAction(e ->{
			animation.stop();
		});
		
		btnContinue.setOnAction(e->{
			animation.play();
		});
		
		Scene scene = new Scene(pane,250,250);
		primaryStage.setTitle("ClockAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
