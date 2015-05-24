package game.of.life;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class ButtonListener implements EventHandler {

    private Cell [][] gridCell;
    private Grid grid;
    private Timeline timeLine;
    private BaseGrowthAlgorithm act;
    private ButtonListener btnStart;
    private Button btnStep;
    private Button tmp;
    private Layout type;
    
    public ButtonListener(Cell [][] c, Layout l) {
        gridCell = c;
        type = l;
    }
    public ButtonListener(Cell [][] c, Grid g, Layout l) {
        grid = g;
        gridCell = c;
        type = l;
    }
    public ButtonListener(Cell [][] c, Button b, Layout l) {
        gridCell = c;
        btnStep = b;
        type = l;
    }
    public ButtonListener(Cell [][] g, ButtonListener btn, Layout l) {
        btnStart = btn;
        gridCell = g;
        type = l;
    }
    
    @Override
    public void handle(Event t) {
        tmp = (Button) t.getSource();
        act = new BaseGrowthAlgorithm(gridCell);
        switch(tmp.getId()) {
            case "step":
                act.draw(type.getType());
            break;
            case "start":
               double duration = 0.10;
               timeLine = new Timeline();
               timeLine.setCycleCount(Animation.INDEFINITE);
               KeyFrame moveBalls = new KeyFrame(Duration.seconds(duration), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) { 
                        btnStep.fire();
                    }
               } );
               timeLine.getKeyFrames().add(moveBalls);
               timeLine.play();
               tmp.setDisable(true);
            break;
            case "stop":
                btnStart.getTimeline().stop();
                btnStart.getSourceButton().setDisable(false);
            break;
            case "clear":
                grid.clearGrid();
            break;
        }
    }
    
    public Timeline getTimeline() {
        return timeLine;
    }
    
    public Button getSourceButton() {
        return tmp;
    }

}