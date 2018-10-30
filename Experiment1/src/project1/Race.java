package project1;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Optional;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.beans.property.BooleanProperty;


public class Race extends Application {
	public void start(Stage primaryStage) throws Exception {
	      
    	//网格布局
        GridPane grid = new GridPane();
       // grid.setAlignment(Pos.TOP_LEFT);
        grid.setAlignment(Pos.CENTER);
        grid.gridLinesVisibleProperty();
        //网格垂直间距
        grid.setHgap(10);
        //网格水平间距
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 25, 25, 30));
        //新建场景
        Scene scene = new Scene(grid, 540, 330);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project #1:Car");
        primaryStage.show();
        Text Car1 = new Text("Car1:");
        Car1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text Car2 = new Text("Car2:");
        Car2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text Car3 = new Text("Car3:");
        Car3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text Car4 = new Text("Car4:");
        Car4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        TextField speed1 = new TextField();
        speed1.setPrefSize(80, 0);
        TextField speed2 = new TextField();
        speed2.setPrefSize(80, 0);
        TextField speed3 = new TextField();
        speed3.setPrefSize(80, 0);
        TextField speed4 = new TextField();
        speed4.setPrefSize(80, 0);
        HBox h1 = new HBox();
        h1.setPadding(new Insets(0,0,0,0));
        h1.setSpacing(10);
        h1.getChildren().addAll(Car1,speed1,Car2,speed2,Car3,speed3,Car4,speed4);
        grid.add(h1, 0, 0);
        
        Car c1 = new Car(1,10);
        Car c2 = new Car(2,10);
        Car c3 = new Car(3,10);
        Car c4 = new Car(4,10);
        ImageView saidao1 = new ImageView(new Image("file:src/project1/Img/赛道.png"));
        ImageView saidao2 = new ImageView(new Image("file:src/project1/Img/赛道.png"));
        ImageView saidao3 = new ImageView(new Image("file:src/project1/Img/赛道.png"));
        ImageView saidao4 = new ImageView(new Image("file:src/project1/Img/赛道.png"));
        
        grid.add(saidao1, 0, 1);
        grid.add(saidao2, 0, 2);
        grid.add(saidao3, 0, 3);
        grid.add(saidao4, 0, 4);
        grid.add(c1.car, 0, 1);
        grid.add(c2.car, 0, 2);
        grid.add(c3.car, 0, 3);
        grid.add(c4.car, 0, 4);
        
		Timeline timeline1 = new Timeline();
		Timeline timeline2 = new Timeline();
		Timeline timeline3 = new Timeline();
		Timeline timeline4 = new Timeline();
		
        speed1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            	speed1.setOnKeyPressed(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent keyEvent) {
						if(keyEvent.getCode() == KeyCode.ENTER) {
						c1.setSpeed(Double.parseDouble(speed1.getText()));
		                System.out.println(speed1.getText());
		               
		                if(c1.speed==0) {
			        		timeline1.pause();
		                }
		                else {
			        		timeline1.pause();
			        		timeline1.setRate(c1.getSpeed());
			        		timeline1.play();	
		                }
						}

					}
            		
            	});

            }
        });

        speed2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	speed2.setOnKeyPressed(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent keyEvent) {
						if(keyEvent.getCode() == KeyCode.ENTER) {
						c2.setSpeed(Double.parseDouble(speed2.getText()));
		                System.out.println(speed2.getText());
		                if(c2.speed==0) {
			        		timeline2.pause();
		                }
		                else {
			        		timeline2.pause();
			        		timeline2.setRate(c2.getSpeed());
			        		timeline2.play();	
		                }	
						}
					}
            		
            	});
            }
        });
        speed3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	speed3.setOnKeyPressed(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent keyEvent) {
						if(keyEvent.getCode() == KeyCode.ENTER) {
						c3.setSpeed(Double.parseDouble(speed3.getText()));
		                System.out.println(speed3.getText());
		                if(c3.speed==0) {
			        		timeline3.pause();
		                }
		                else {
			        		timeline3.pause();
			        		timeline3.setRate(c3.getSpeed());
			        		timeline3.play();	
		                }
						}
					}
            		
            	});
            }
        });
        speed4.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	speed4.setOnKeyPressed(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent keyEvent) {
						if(keyEvent.getCode() == KeyCode.ENTER) {
						c4.setSpeed(Double.parseDouble(speed4.getText()));
		                System.out.println(speed4.getText());
		                if(c4.speed==0) {
			        		timeline4.pause();
		                }
		                else {
			        		timeline4.pause();
			        		timeline4.setRate(c4.getSpeed());
			        		timeline4.play();	
		                }
						}
					}
            		
            	});
            }
            	
        });
		
        
	    timeline1.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // set start position at 0
		            new KeyValue(c1.car.translateXProperty(),0),
		            new KeyValue(c1.car.translateYProperty(),0)
		        ),
        new KeyFrame(new Duration(40000), // set end position at 40s
        		new KeyValue(c1.car.translateXProperty(),440),
	            new KeyValue(c1.car.translateYProperty(),0)
        )
    );    
		
	    timeline2.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // set start position at 0
		            new KeyValue(c2.car.translateXProperty(),0),
		            new KeyValue(c2.car.translateYProperty(),1)
		        ),
        new KeyFrame(new Duration(40000), // set end position at 40s
        		new KeyValue(c2.car.translateXProperty(),440),
	            new KeyValue(c2.car.translateYProperty(),1)
        )
    );    
	    timeline3.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // set start position at 0
		            new KeyValue(c3.car.translateXProperty(),0),
		            new KeyValue(c3.car.translateYProperty(),2)
		        ),
        new KeyFrame(new Duration(40000), // set end position at 40s
        		new KeyValue(c3.car.translateXProperty(),440),
	            new KeyValue(c3.car.translateYProperty(),2)
        )
    );    
	    timeline4.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // set start position at 0
		            new KeyValue(c4.car.translateXProperty(),0),
		            new KeyValue(c4.car.translateYProperty(),3)
		        ),
        new KeyFrame(new Duration(40000), // set end position at 40s
        		new KeyValue(c4.car.translateXProperty(),440),
	            new KeyValue(c4.car.translateYProperty(),3)
        )
    );    


		// play 40s of animation

		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.play();		
		timeline2.setCycleCount(Timeline.INDEFINITE);
		timeline2.play();       
		timeline3.setCycleCount(Timeline.INDEFINITE);
		timeline3.play();      
		timeline4.setCycleCount(Timeline.INDEFINITE);
		timeline4.play();
		
		
		speed1.setText("1");
		speed2.setText("1");
		speed3.setText("1");
		speed4.setText("1");
		
        primaryStage.show();
}
	
   public static void main(String[] args) {
      launch(args);
    }
}
