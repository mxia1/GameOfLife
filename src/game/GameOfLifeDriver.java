package game;
import java.util.concurrent.TimeUnit;

import GridTools.MyGrid;

public class GameOfLifeDriver{
	static MyGrid grid;
	static Cell[][] board;
	static boolean isPaused;
	static Cursor player;
	//public static InputHandler inputs;
	
	/*public void init() {
		this.setFocusable(true);
		inputs = new InputHandler(grid);
	}*/
	
	public static void main(String[] args) throws InterruptedException{
		grid = new MyGrid(50);
		board = new Cell[grid.getHt()][grid.getWd()];
		isPaused = false;
		int i = 0;

		//inputs = new InputHandler(grid);

		// Initialize each cell
		for (i = 0; i < grid.getHt(); i++) {
			for (int j = 0; j < grid.getWd(); j++) {
				board[i][j] = new Cell(i, j);
				board[i][j].setColor();
			}
		}
		
		// Initialize player cursor around the center of the board
		player = new Cursor(grid.getHt() / 2, grid.getWd() / 2);
		
		while(true){
			player.moveCursor();

			if (!isPaused) {
				// first check how many neighbors a cell will have
				for (i = 0; i < grid.getHt(); i++) {
					for (int j = 0; j < grid.getWd(); j++) {
						board[i][j].checkNeighbors();
					}
				}
				// then check to see if a cell should be alive 
				for ( i = 0; i < grid.getHt(); i++) {
					for (int j = 0; j < grid.getWd(); j++) {
						board[i][j].checkLife();
					}
				}
				// finally update the cell's color accordingly
				for ( i = 0; i < grid.getHt(); i++) {
					for (int j = 0; j < grid.getWd(); j++) {
						//System.out.println(i + " " + j);
						board[i][j].setColor();
					}
				}
			}
			player.setCursor();
			grid.repaint();
			TimeUnit.MILLISECONDS.sleep(20);
		}		
	}
}
