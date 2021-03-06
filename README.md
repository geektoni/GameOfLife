# GameOfLife
A Java implementation of the famous Conway's Game of Life. As Wikipedia report: 
>The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

>The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves or, for advanced players, by creating patterns with particular properties.

## Usage
First of all, after starting the application, you have to specify the grid dimension and the fullscreen/window mode. Then a new window will appear. Below the description of every button:
* **Finite grid**: the displayed grid is finite, if a glider is moving and touch a border it will stop and (eventually) die;
* **Toroid grid**: the displayed grid is a toroid, so, if a glider is moving it will surpass the grid border and it will reapper on the other side of the grid (top-dow, right-left);
* **Start**: start the grow animation.The grid will evolve and update itself with a new generation of cell (using Conway's Algorithm) every 0.1 second;
* **Stop**: stop the animation and display the last generation produced;
* **Step**: update the grid with a new generation of cell each time this button is pressed;
* **Clear**: clear the grid from all cells;

If you want to test it, there is a compiled version inside **dist**. It was compiled under Linux. 
