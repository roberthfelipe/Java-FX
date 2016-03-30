package effects2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.VPos;
import javafx.scene.effect.Light.Distant;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class lightingeffect extends Effects2{
    
    Stage stage;
    Scene scene;

    @Override public void start(Stage stage) {
        stage.show();
 
        scene = new Scene(new Group());
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();

        content.add(lighting());
        stage.setScene(scene);    }
    static Node lighting() {
        Distant light = new Distant();
        light.setAzimuth(-135.0f);
 
        Lighting l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(5.0f);
 
        Text t = new Text();
        t.setText("JavaFX"+"\n"+"Lighting!");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 70));
        t.setX(10.0f);
        t.setY(10.0f);
        t.setTextOrigin(VPos.TOP);
 
        t.setEffect(l);
 
        t.setTranslateX(0);
        t.setTranslateY(320);
 
        return t;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
