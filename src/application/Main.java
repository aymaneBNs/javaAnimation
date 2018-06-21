package application;
	
import java.awt.Color;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.javafx.geom.QuadCurve2D;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveBuilder;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,500,500);
			
	
			
			
			int randomStartx =ThreadLocalRandom.current().nextInt(1, 500 + 1);
			int randomStarty = ThreadLocalRandom.current().nextInt(1, 500 + 1);
			
			int randomEndx =	ThreadLocalRandom.current().nextInt(1, 500 + 1);
			int randomEndy =ThreadLocalRandom.current().nextInt(1, 500 + 1);
			
			int ranCx =ThreadLocalRandom.current().nextInt(1, 500 + 1);
			int ranCy = ThreadLocalRandom.current().nextInt(1, 500 + 1);
			
			
			
			
			
			QuadCurve quad =QuadCurveBuilder.create()
			.startX(randomStartx)
			.endX(randomEndx)
			
			.startY(randomStarty)
			.endY(randomEndy)
			
			.controlX(ranCx)

			.controlX(ranCy)
			.strokeWidth(1)
		
			.stroke(javafx.scene.paint.Color.BLACK)
			.fill(javafx.scene.paint.Color.GREEN)
			.build();
			
			
		
      ArrayList<Point> Positionlist=	GetpointFromShape(quad,root);
			
			
				     Circle circle = new Circle(); 
			         
				      //Setting the properties of the circle 
				      circle.setCenterX(Positionlist.get(0).getX()); 
				      circle.setFill(javafx.scene.paint.Color.RED);
				      circle.setCenterY(Positionlist.get(0).getY()); 
				      circle.setRadius(5); 
				     
			
	
	
              
		     move_through_shape(Positionlist, circle);
			
			root.getChildren().add(quad);
		
			root.getChildren().add(circle);
				primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public ArrayList<Point>  GetpointFromShape(QuadCurve quad,BorderPane root){
		
		ArrayList<Point>  Liste= new ArrayList<>();
		
		
		for(int i=0;i<500;i=i+2) {
			
			for(int j=0;j<500;j=j+2) {
				
				if(quad.contains(i, j)) {
					
				Liste.add(new Point(i, j));
					   //Drawing a Circle 
				 
				}
				
			}
			
			
		}
		return  Liste;
		
	}
	
	
	public void move_through_shape(ArrayList<Point> PositionsList,Circle circle) {
		 TranslateTransition transition= new TranslateTransition();
		  transition.setDuration(Duration.seconds(10));

		  transition.setNode(circle);
		
				for(int i=1;i<PositionsList.size();++i) {
					
					transition.setFromX(circle.getCenterX());
					transition.setFromY(circle.getCenterY());
					  transition.setToX(PositionsList.get(i).getX());
					   transition.setToY(PositionsList.get(i).getY());
					    transition.play();
					
				}
				
			
		
	
		
		
		
	}
	
	

	
	
}
