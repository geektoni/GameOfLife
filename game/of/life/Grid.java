package game.of.life;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class Grid {

    private GridPane grid;
    private int rowsAndColumns;
    private Cell [][] gridCell;
    
    public Grid(int n) {
        rowsAndColumns = n;
        grid = new GridPane();
        gridCell = new Cell[n][n];
        generateGrid();
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(30));
    }
    
    public void clearGrid() {
        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                gridCell[i][j].setOpacity(0.0);
            }
        }
    }
    
    public GridPane getGrid() {
        return grid;
    }
    
    public Cell[][] getCellGrid() {
        return gridCell;
    }
        
    private void generateGrid() {
        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                Cell tmp = new Cell();
                tmp.setStroke(Paint.valueOf("BLACK"));
                tmp.setOpacity(0.0);
                tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, new CellListener());
                gridCell[i][j] = tmp;
                grid.add(tmp, j, i); 
            }
        }
    }

}