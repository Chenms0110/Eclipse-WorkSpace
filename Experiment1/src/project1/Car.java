package project1;
import javafx.animation.KeyFrame;

import javafx.animation.KeyValue;

import javafx.animation.Timeline;

import javafx.application.Application;

import javafx.scene.Group;

import javafx.scene.Node;

import javafx.scene.Scene;

import javafx.scene.effect.BlendMode;

import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import javafx.scene.paint.CycleMethod;

import javafx.scene.paint.LinearGradient;

import javafx.scene.paint.Stop;

import javafx.scene.shape.Circle;

import javafx.scene.shape.Rectangle;

import javafx.scene.shape.StrokeType;

import javafx.stage.Stage;

import javafx.util.Duration;

 

public class Car extends Application {

	ImageView car = new ImageView(new Image("file:src/project1/Img/Car.jpg"));
	int i;         //小车赛道
	double speed;  //小车速度

 
	public Car() {
		i=0;
		speed=1;
	}
	
	public Car(int i,double speed) {
		this.i=i;

		this.speed=speed;
        car.setFitHeight(50);
        car.setFitWidth(50);
	}
	

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if(speed>=0&&speed<=100) {
			this.speed = speed;
		}

	}

	public int getI() {
		return i;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO 自动生成的方法存根
		
	}


}