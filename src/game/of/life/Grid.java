package game.of.life;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

/**
 * Class that manage grid layout
 * @author Giovanni De Toni
 */
public class Grid {

    private GridPane grid;
    private int rowsAndColumns;
    private Cell [][] gridCell;
    
    /**
     * Constructor that generate grid
     * @param n integer that define grid dimension
     */
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
    
    /**
     * Method that is useful to clear the grid.
     */
    public void clearGrid() {
        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                gridCell[i][j].setOpacity(0.0);
            }
        }
    }
    
    /**
     * Method that returns the grid
     * @return Gridpane of the grid
     */
    public GridPane getGrid() {
        return grid;
    }
    
    /**
     * Method that returns the {@link Cell} matrix
     * @return Matrix of {@link Cell}
     */
    public Cell[][] getCellGrid() {
        return gridCell;
    }
    
    /**
     * Method that generates the Cell matrix.
     * @see Cell
     */
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