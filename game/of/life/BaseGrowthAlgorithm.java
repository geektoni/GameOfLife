package game.of.life;

public class BaseGrowthAlgorithm implements GrowthAlgorithm {
    
    private Cell [][] gridCell;
    private int [][] numberGrid;
    
    public BaseGrowthAlgorithm(Cell [][] g) {
        gridCell = g;
        numberGrid = new int[gridCell.length][gridCell.length];
    }
    
    @Override
    public void draw(int type) {
        if (type == 1) {
            for (int i = 0; i < gridCell.length; i++) {
                for (int j = 0; j < gridCell.length; j++) {
                   checkNearby(i, j);
                }
            }
        } else {
            for (int i = 0; i < gridCell.length; i++) {
                for (int j = 0; j < gridCell.length; j++) {
                   checkNearbyInfy(i, j);
                }
            }
        }
        for (int i = 0; i < gridCell.length; i++) {
            for (int j = 0; j < gridCell.length; j++) {
                if (gridCell[i][j].getOpacity() != 0.0) {
                    Cell c = checkDeath(i, j);
                    if (c != null) {
                        c.setOpacity(0.0);
                    }
                } else {
                    Cell c = checkLife(i,j);
                    if (c != null) {
                        c.setOpacity(1.0);
                    }
                }
            }
        }
    }
    
    private Cell checkLife(int x, int y) {
        Cell tmp = null;
        if (numberGrid[x][y] == 3) {
            tmp = gridCell[x][y];
        }
        return tmp;
    }
    
    private Cell checkDeath(int x, int y) {
        Cell tmp = null;
        if (numberGrid[x][y] != 2 && numberGrid[x][y] != 3) {
            tmp = gridCell[x][y];
        }
        return tmp;
    }
    
    private void checkNearby(int x, int y) {
        for (int i = 0; i < 3; i++) {
            if (isInside(x-1)) {
                if (isInside((y-1)+i)) {
                    if (gridCell[x-1][(y-1)+i].getOpacity() > 0 ) {
                        numberGrid[x][y]++;
                    }
                } 
            }
            
            if (isInside(y-1+i) && i != 1) {
                if (gridCell[x][y-1+i].getOpacity() > 0) {
                     numberGrid[x][y]++;
                }
            }
            
            if (isInside(x+1)) {
                if (isInside((y-1)+i)) {
                    if (gridCell[x+1][(y-1)+i].getOpacity() > 0 ) {
                         numberGrid[x][y]++;
                    }
                }
            }
        }
        
    }
    
    private boolean isInside(int x) {
        boolean status = true;
        if (x > gridCell.length-1 || x < 0) {
            status = false;
        }
        return status;
    }
    
    private void checkNearbyInfy(int x, int y) {
        for (int i = 0; i < 3; i++) {
            if (gridCell[isInsideInfyX(x, -1)][isInsideInfyY(y, -1+i)].getOpacity() > 0.0) {
                numberGrid[x][y]++;
            }
            
            if (gridCell[x][isInsideInfyY(y,-1+i)].getOpacity() > 0.0 && i != 1) {
                     numberGrid[x][y]++;
            }
            
            if (gridCell[isInsideInfyX(x, 1)][isInsideInfyY(y, -1+i)].getOpacity() > 0.0) {
                numberGrid[x][y]++;
            }
        }
    }
    
    private int isInsideInfyX(int x, int increment) {
        int tmp = x+increment;
        if (tmp < 0) {
            if (x == 0) tmp = gridCell.length-1;
        } else if (tmp > gridCell.length-1) {
            if (x == gridCell.length-1) tmp = 0;
        }
        return tmp;
    }
    
    private int isInsideInfyY(int y, int increment) {
        int tmp = y+increment;
        if (tmp > gridCell.length-1) {
            if (y == gridCell.length-1) tmp = 0;
        } else if (tmp < 0) {
            if (y == 0) tmp = gridCell.length-1;
        }
        return tmp;
    }
    
    private int nextGridElement(int x) {
        int result = x;
        return result;
    }

}