package project5;
import project5.Img.*;
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

public class Pro5 extends Application {

	//————————————————————实现随机取牌的四个变量————————————————————
	public Random random = new Random(); 
	public int p1 = random.nextInt(52)+1;
	public int p2 = random.nextInt(52)+1;
	public int p3 = random.nextInt(52)+1;
	public int p4 = random.nextInt(52)+1;
	//——————————————————————————————————————————————————————————————
	
    @Override
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
       
        primaryStage.setResizable(false);
        //Find a Solution按钮
        Button FindSolution = new Button("Find a Solution");
        FindSolution.setPrefSize(150, 0);  
        
        //显示解法表达式的文本框，对应Find a Solution按钮
        TextField Cexperssion = new TextField();
        Cexperssion.setPrefSize(180, 0);
       	Cexperssion.setEditable(false);     //禁止修改
        
        //Refresh的按钮
        Button Refresh = new Button("Refresh");
        Refresh.setPrefSize(100, 0);    

        //hbox1，用来排列findasolution、Refresh与解法表达式的文本框
        HBox h1 = new HBox();
        h1.setPadding(new Insets(0,0,0,10));
        h1.setSpacing(10);
        h1.getChildren().addAll(FindSolution, Cexperssion,Refresh);
        grid.add(h1, 0, 0);
      
        
        //Verify的按钮
        
        //——————————————————四张扑克牌图像显示控件的相关设置————————————————————————————
        ImageView poke1 = new ImageView(new Image("file:src/project5/Img/"+p1+".png"));
        ImageView poke2 = new ImageView(new Image("file:src/project5/Img/"+p2+".png"));
        ImageView poke3 = new ImageView(new Image("file:src/project5/Img/"+p3+".png"));
        ImageView poke4 = new ImageView(new Image("file:src/project5/Img/"+p4+".png"));
        poke1.setFitHeight(150);
        poke1.setFitWidth(105);
        poke2.setFitHeight(150);
        poke2.setFitWidth(105);
        poke3.setFitHeight(150);
        poke3.setFitWidth(105);
        poke4.setFitHeight(150);
        poke4.setFitWidth(105);
        //排列扑克牌在一行
        HBox h = new HBox();
        h.setPadding(new Insets(0,10,10,10));        
        h.setSpacing(10);
        h.getChildren().addAll(poke1, poke2, poke3,poke4);
        grid.add(h, 0, 2);
        //——————————————————————————————————————————————————————————————————————————————————
        
        
      

        //提示输入文本
        Text scenetitle = new Text("Enter an experssion:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        //用户输入文本框
        TextField experssion = new TextField();
        experssion.setPrefSize(160, 0);
        
        //Verify按钮，与experssion对应
        Button Verify = new Button("Verify");
        Verify.setPrefSize(90, 0);    

        //提示输入、用户输入和Verify按钮的排列
        HBox h2 = new HBox();
        h2.setPadding(new Insets(0,0,0,10));
        h2.setSpacing(10);
        h2.getChildren().addAll(scenetitle, experssion,Verify);
        grid.add(h2, 0, 3);

        
        //用户输入并点击确定按钮后的提示弹窗
        Alert information = new Alert(Alert.AlertType.INFORMATION,"Welocme to JavaFX");
        information.setTitle("information"); //设置标题，不设置默认标题为本地语言的information
        information.setHeaderText("Information"); //设置头标题，默认标题为本地语言的information
        
        //点击Verify的事件操作
        Verify.setOnAction(event->{
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
            String expression1 = experssion.getText().replaceAll("\\[(.*?)\\]", "($1)"); //将用户输入中的中括号全部替换为小括号
            
            //———————————取四张扑克牌点数在用户输入字符串中出现的位置，若有一个为-1，则数字不全
            int point1 = expression1.indexOf(""+Change(p1),0);
            int point2 = expression1.indexOf(""+Change(p2),0);
            int point3 = expression1.indexOf(""+Change(p3),0);
            int point4 = expression1.indexOf(""+Change(p4),0);
            //————————————————————————————————————————————————————————————————————————————————
            
            if(opertor()=="No answer") {   //如果本题解为No answer，用户输入后直接判断
            	information.setHeaderText("Correct Answer");
            	information.setContentText("你有、东西！");
                information.showAndWait(); //显示弹窗，同时后续代码等挂起
            }
            else if((point1==-1||point2==-1||point3==-1||point4==-1)&&!expression1.equals(""))   //查数字个数
            {
            	information.setHeaderText("Wrong Expression");
            	information.setContentText("没有包含所有的数字，请检查");
                information.showAndWait(); //显示弹窗，同时后续代码等挂起
            }
            else {  //正常进行表达式值的判断
                try {
                    String result = String.valueOf(scriptEngine.eval(expression1)); //计算表达式
          //          experssion.setText(result);
                    if(result.equals("null")){
                    	information.setHeaderText("Wrong Answer");
                    	information.setContentText("请输入表达式后再点击该按钮");
                    }
                     else if(result.equals("24.0")||result.equals("24")) {
                    	information.setHeaderText("Correct Answer");
                    	information.setContentText("你有、东西！");
                    }
                     else {
                     	information.setHeaderText("Wrong Answer");
                     	information.setContentText("Wrong!");
                     }
                    System.out.println(result);
                   
                    information.showAndWait(); //显示弹窗，同时后续代码等挂起

                } catch (ScriptException e) {  //若表达式无法计算
                	information.setHeaderText("Wrong Expression");
                	information.setContentText("你输入的表达式与人类认知不符");
                    information.showAndWait(); //显示弹窗，同时后续代码等挂起
                }
            }

   
        });

        //求解按钮事件，直接显示答案
        FindSolution.setOnAction(event ->{
        	Cexperssion.setText(opertor());
        });
        
        //刷新按钮事件，刷新扑克牌并清空两个文本框。
        Refresh.setOnAction(event -> {
        	
        	//循环随机四张扑克牌，不能出现同一张牌
        	do {
        	p1 = random.nextInt(52)+1;
        	p2 = random.nextInt(52)+1;
        	p3 = random.nextInt(52)+1;
        	p4 = random.nextInt(52)+1;
        	}while(p1==p2||p1==p3||p1==p4||p2==p3||p2==p4||p3==p4);      	
        	poke1.setImage(new Image("file:src/project5/Img/"+p1+".png"));
        	poke2.setImage(new Image("file:src/project5/Img/"+p2+".png"));
        	poke3.setImage(new Image("file:src/project5/Img/"+p3+".png"));
        	poke4.setImage(new Image("file:src/project5/Img/"+p4+".png"));
        	//——————————————————————————————————————————————————————————————————
        	
        	//清空文本框
        	Cexperssion.setText("");
        	experssion.setText("");
        });

        primaryStage.setTitle("Project #5:24-Point Card Game");
        primaryStage.show();
    }



	//取出牌的值
	public static int Change(int p) {
		if(14<=p&&p<=26) {
			return p-13;
		}
		else if(27<=p&&p<=39) {
			return p-26;
		}
		else if(40<=p&&p<=52) {
			return p-39;
		}
		return p;
	}
    
    //————————————————————以下为求24点表达式算法————————————————————————————————————————————
	public String opertor(){
		int[][] poker    = {{Change(p1),Change(p2),Change(p3),Change(p4)},
							{Change(p1),Change(p2),Change(p4),Change(p3)},
							{Change(p1),Change(p3),Change(p2),Change(p4)},
							{Change(p1),Change(p3),Change(p4),Change(p2)},
							{Change(p1),Change(p4),Change(p2),Change(p3)},
							{Change(p1),Change(p4),Change(p3),Change(p2)},
							{Change(p2),Change(p1),Change(p3),Change(p4)},
							{Change(p2),Change(p1),Change(p4),Change(p3)},
							{Change(p2),Change(p3),Change(p1),Change(p4)},
							{Change(p2),Change(p3),Change(p4),Change(p1)},
							{Change(p2),Change(p4),Change(p1),Change(p3)},
							{Change(p2),Change(p4),Change(p3),Change(p1)},
							{Change(p3),Change(p1),Change(p2),Change(p4)},
							{Change(p3),Change(p1),Change(p4),Change(p2)},
							{Change(p3),Change(p2),Change(p1),Change(p4)},
							{Change(p3),Change(p2),Change(p4),Change(p1)},
							{Change(p3),Change(p4),Change(p1),Change(p2)},
							{Change(p3),Change(p4),Change(p2),Change(p1)},
							{Change(p4),Change(p1),Change(p2),Change(p3)},
							{Change(p4),Change(p1),Change(p3),Change(p2)},
							{Change(p4),Change(p2),Change(p1),Change(p3)},
							{Change(p4),Change(p2),Change(p3),Change(p1)},
							{Change(p4),Change(p3),Change(p1),Change(p2)},
							{Change(p4),Change(p3),Change(p2),Change(p1)}};

		double sum=0;
		for(int m=0;m<12;m++) {
			for(int i=0;i<4;i++){
				double sum1=code(poker[m][0],poker[m][1],i);
				for(int j=0;j<4;j++){
					double sum2=code(sum1,poker[m][2],j);
					for(int k=0;k<4;k++){
						sum=code(sum2,poker[m][3],k);
						int[] symbolNum={i,j,k};
						String[] symbol=new String[4];
						symbol=symbol(symbolNum);
						if(sum==24){
							return ("["+"("+poker[m][0]+" "+symbol[0]+" "+poker[m][1]+")"+" "+symbol[1]+" "+poker[m][2]+"]"+" "+symbol[2]+" "+poker[m][3]);
							//num++;
							//System.out.println("["+"("+poker[0]+" "+symbol[0]+" "+poker[1]+")"+" "+symbol[1]+" "+poker[2]+"]"+" "+symbol[2]+" "+poker[3]);
						}
					}
				}
			}
		}

		return "No answer";
	}
	
	
    public static double code(double num1,double num2,int num){
		double sum=0.0;
		if(num==0){
			sum=num1+num2;
		}else if(num==1){
			sum=num1-num2;
		}else if(num==2){
			sum=num1*num2;
		}else{
			sum=num1/num2;
		}
		return sum;
	}


    public static String[] symbol(int[] symbolNum){
		String[] symbol=new String[4];
		for(int i=0;i<3;i++){
			int sym=symbolNum[i];
			switch (sym) {
			case 0:
				symbol[i]="+";
				break;
			case 1:
				symbol[i]="-";
				break;
			case 2:
				symbol[i]="*";
				break;
			case 3:
				symbol[i]="/";
				break;
			default:
				break;
			}
		}
		return symbol;
	}
    //____________________________________________________________________________________
    
    public static void main(String[] args) {
        launch(args);
    }
    
    

}
