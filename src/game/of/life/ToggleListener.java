package game.of.life;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

/**
 * Togglebutton extern listener 
 * @author Giovanni De Toni
 */
public class ToggleListener implements EventHandler {
    
    private ToggleButton source;
    
    @Override
    public void handle(Event t) {
        source = (ToggleButton) t.getSource();
        switch(source.getId()) {
            case "1":
            break;
            case "2":
            break;
        }
    }

}