package Unit07P03;

import java.io.File;
import java.net.MalformedURLException;

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


import javafx.scene.media.AudioClip;

public class ClockWithAudio1 extends Application{

	private AudioClip[] hourAudio = new AudioClip[12];
	private AudioClip[] minAudio = new AudioClip[60];
	
	
	private AudioClip amAudio;
	private AudioClip pmAudio ;
	File directory = new File("audio");
	String path;
	
	
	
	private void initAudio() {
		try {
			path = directory.toURI().toURL().toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path);
		
		amAudio = new AudioClip(path + "/am.wav");
		pmAudio = new AudioClip(path + "/pm.wav");
		
		for(int i=0;i<12;i++) {
			hourAudio[i] = new AudioClip(path + "/hour" + i + ".wav");
		}
		
		for(int i =0;i<minAudio.length;i++) {
			minAudio[i] = new AudioClip(path + "/minute" + i + ".wav");
		}
	}
	
	private void announceTime(int hour,int minute) {
		hourAudio[hour].play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minAudio[minute].play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(hour>=12) {
			pmAudio.play();
		}
		else {
			amAudio.play();
		}
	}
	
	 @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {

	    // Create two buttons to start/stop the clock

	    Button btnPause = new Button("Pause");

	    Button btnContinue = new Button("Continue");



	    // Create a hbox to hold the buttons with center alignment

	    HBox lpane = new HBox(20);

	    lpane.getChildren().addAll(btnPause, btnContinue);

	    lpane.setAlignment(Pos.CENTER);



	    // Create a clock

	    ClockPane clock = new ClockPane();

	    

	    // Create a panel to hold the clock pane and control buttons

	    BorderPane pane = new BorderPane();

	    pane.setCenter(clock);

	    pane.setBottom(lpane);

	    

		initAudio();


	    

	    // Create a handler for animation

	    EventHandler<ActionEvent> eventHandler = e -> {

	      clock.setCurrentTime(); // Set a new clock time

	      

	      // 每分钟/20秒钟播报一次时间
	      if(clock.getSecond() % 20 ==0) {
	    	  announceTime(clock.getHour(),clock.getMinute());
	      }

	    };

	    

	    // Create an animation for a running clock

	    Timeline animation = new Timeline(

	      new KeyFrame(Duration.millis(1000), eventHandler));

	    animation.setCycleCount(Timeline.INDEFINITE);

	    animation.play(); // Start animation

	    



	    // Set Action Handler for Buttons

	    btnPause.setOnAction(e -> {

	      animation.pause();

	    });

	    btnContinue.setOnAction(e -> {

	      animation.play();

	    });

	    

	    // Create a scene and place it in the stage

	    Scene scene = new Scene(pane, 300, 400);

	    primaryStage.setTitle("ClockAnimation"); // Set the stage title

	    primaryStage.setScene(scene); // Place the scene in the stage

	    primaryStage.show(); // Display the stage

	  }
	
	class AudioThread extends Thread{
		private int hour,minute;
		public AudioThread(int hour,int minute) {
			this.hour = hour;
			this.minute = minute;
		}
		@Override
		public void run() {
			announceTime(hour,minute);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
