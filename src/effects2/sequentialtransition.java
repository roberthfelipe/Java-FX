package effects2;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.util.Duration;

public class sequentialtransition extends Effects2{
    
    Stage stage;
    Scene scene;

    @Override public void start(Stage stage) {
        stage.show();
 
        scene = new Scene(new Group());
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
 
        content.add(chainEffects());
        stage.setScene(scene);
    }
    static Node chainEffects() {
        
Rectangle rectSeq = new Rectangle(25,25,50,50);
rectSeq.setArcHeight(15);
rectSeq.setArcWidth(15);
rectSeq.setFill(Color.CRIMSON);
rectSeq.setTranslateX(50);
rectSeq.setTranslateY(50);


         FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(1000), rectSeq);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
 
        TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(2000), rectSeq);
        translateTransition.setFromX(50);
        translateTransition.setToX(375);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
 
        RotateTransition rotateTransition = 
            new RotateTransition(Duration.millis(2000), rectSeq);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
 
        ScaleTransition scaleTransition = 
            new ScaleTransition(Duration.millis(2000), rectSeq);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);

        SequentialTransition sequentialTransition = new SequentialTransition();
sequentialTransition.getChildren().addAll(
        fadeTransition,
        translateTransition,
        rotateTransition,
        scaleTransition);
sequentialTransition.setCycleCount(Timeline.INDEFINITE);
sequentialTransition.setAutoReverse(true);

sequentialTransition.play();
        return rectSeq;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}