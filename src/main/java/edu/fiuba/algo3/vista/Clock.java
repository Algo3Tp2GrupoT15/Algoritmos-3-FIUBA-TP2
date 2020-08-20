package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Clock extends Pane {

    private Timeline animation;
    private int temp = 15;
    private String s = "";

    private Label label = new Label("15");

    private Button boton;

    public Clock(Button boton){

        this.boton=boton;

        label.setFont(javafx.scene.text.Font.font(100));
       // label.setTranslateX(250);
        //label.setTranslateY(400);
        label.setAlignment(Pos.CENTER_RIGHT);


        getChildren().add(label);

        animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> timeLabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


    }

    public  void timeLabel(){

        if(temp > 0) {

            temp--;
        }

        s = temp + "";
        label.setText(s);

        if(temp == 0){
            boton.fire();
            temp--;
        }

    }

    public void terminar(){
        temp = -1;
    }
}
