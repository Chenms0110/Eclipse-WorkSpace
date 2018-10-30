package project1;

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
import javafx.scene.image.*;

import java.util.Optional;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.beans.property.SimpleBooleanProperty;
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
        Scene scene = new Scene(grid, 540, 260);
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("Project #5:24-Point Card Game");
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
}
	
   // public static void main(String[] args) {
     //   launch(args);
   // }
}
