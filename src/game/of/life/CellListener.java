package game.of.life;

import javafx.event.Event;
import javafx.event.EventHandler;

public class CellListener implements EventHandler {

    @Override
    public void handle(Event t) {
        Cell tmp = (Cell) t.getSource();
        if (tmp.getOpacity() == 0.0 ) {
            tmp.setOpacity(1);
        } else {
            tmp.setOpacity(0);
        }
    }

}