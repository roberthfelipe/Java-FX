package effects2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.stage.Stage;

public class reflection extends Effects2{
    Stage stage;
    Scene scene;
    
    @Override public void start(Stage stage) {
        stage.show();
 
        scene = new Scene(new Group(), 840, 680);
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        content.add(reflection());
        stage.setScene(scene);
    }
    static Node reflection() {
        Text t = new Text();
        t.setX(10.0f);
        t.setY(50.0f);
        t.setCache(true);
        t.setText("Reflection in JavaFX...");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 30));
 
        Reflection r = new Reflection();
        r.setFraction(0.9);
 
        t.setEffect(r);
 
        t.setTranslateY(400);
        return t;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}