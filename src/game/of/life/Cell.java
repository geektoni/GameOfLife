package game.of.life;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    
    final private static int DIMENSION = 12; 
    final private static Paint COLOR = Paint.valueOf("BLACK");
    
    public Cell() {
        super(DIMENSION, DIMENSION, COLOR);
    }
}