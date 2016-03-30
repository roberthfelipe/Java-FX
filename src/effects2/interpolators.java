package effects2;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.util.Duration;
 
public class interpolators extends Effects2{
 
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
        
final Rectangle rectBasicTimeline = new Rectangle(100, 50, 100, 50);
rectBasicTimeline.setFill(Color.BROWN);

final Timeline timeline = new Timeline();
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.setAutoReverse(true);
final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 300,
 Interpolator.EASE_BOTH);
final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
timeline.getKeyFrames().add(kf);
timeline.play();
      
        return rectBasicTimeline;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
