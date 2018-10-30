package project5;
import project5.Img.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;

public class Pro5 extends Application {
	
	public Random random = new Random(); 
	public int p1 = random.nextInt(52)+1;
	public int p2 = random.nextInt(52)+1;
	public int p3 = random.nextInt(52)+1;
	public int p4 = random.nextInt(52)+1;
    @Override
    public void start(Stage primaryStage) throws Exception {
        //网格布局
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.gridLinesVisibleProperty();
        //网格垂直间距
        grid.setHgap(10);
        //网格水平间距
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 25, 25, 30));
        //新建场景
        Scene scene = new Scene(grid, 540, 260);
        primaryStage.setScene(scene);
        
        Button FindSolution = new Button("Find a Solution");
        FindSolution.setPrefSize(150, 0);    
        //Find a Solution按钮
        TextField Cexperssion = new TextField();
        Cexperssion.setPrefSize(180, 0);
        //显示解法表达式的文本框
        
        Button Refresh = new Button("Refresh");
        Refresh.setPrefSize(100, 0);    
        //Refresh的按钮
        
        HBox h1 = new HBox();

        h1.setPadding(new Insets(0,0,0,10));
        h1.setSpacing(10);
        h1.getChildren().addAll(FindSolution, Cexperssion,Refresh);
        grid.add(h1, 0, 0);
        //Verify的按钮
        
  
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
        HBox h = new HBox();
        h.setPadding(new Insets(0,10,10,10));
        
        h.setSpacing(10);
        h.getChildren().addAll(poke1, poke2, poke3,poke4);
        grid.add(h, 0, 2);
        //添加标签及密码框

      Text scenetitle = new Text("Enter an experssion:");
       scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
     //   Label tip = new Label("Enter an experssion : ");
      //  tip.setPrefSize(150, 0);    
        //Find a Solution按钮
        TextField experssion = new TextField();
        experssion.setPrefSize(160, 0);
        //显示解法表达式的文本框
        
        Button Verify = new Button("Verify");
        Verify.setPrefSize(90, 0);    

        
        HBox h2 = new HBox();

        h2.setPadding(new Insets(0,0,0,10));
        h2.setSpacing(10);
        h2.getChildren().addAll(scenetitle, experssion,Verify);
        grid.add(h2, 0, 3);
        //Verify的按钮
        
        
        
        
        Verify.setOnAction(event->{
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
            String expression = experssion.getText();

            try {
                String result = String.valueOf(scriptEngine.eval(expression));
                System.out.println(result);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
   
        });
        
       	Cexperssion.setEditable(false);

        FindSolution.setOnAction(event ->{

        	Cexperssion.setPromptText(opertor());
        });
        
        Refresh.setOnAction(event -> {
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
        });
        


        primaryStage.setTitle("Project #5:24-Point Card Game");
        primaryStage.show();
    }

    
    
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
				symbol[i]="x";
				break;
			case 3:
				symbol[i]="÷";
				break;
			default:
				break;
			}
		}
		return symbol;
	}

    
    public static void main(String[] args) {
        launch(args);
    }
}
