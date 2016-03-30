package effects2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.MotionBlur;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class motionblur extends Effects2{
    Stage stage;
    Scene scene;
    
    @Override public void start(Stage stage) {
        stage.show();
        scene = new Scene(new Group(), 840, 680);
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        content.add(motionblur());
        stage.setScene(scene);
    }
static Node motionblur() {
        Text t = new Text();
        t.setX(20.0f);
        t.setY(80.0f);
        t.setText("Motion Blur");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 60));
 
        MotionBlur mb = new MotionBlur();
        mb.setRadius(15.0f);
        mb.setAngle(45.0f);
 
        t.setEffect(mb);
 
        t.setTranslateX(300);
        t.setTranslateY(150);
 
        return t;
    }   
public static void main(String[] args) {
        Application.launch(args);
    }
}