package game;
import java.awt.Color;

public class Cell {
	boolean alive;
	int neighbors;
	int x;
	int y;
	
	Cell(int x, int y) {
		this.x = x;
		this.y = y;
		alive = false;
		neighbors = 0;
	}
	
	public void setColor() {
		if (alive) GameOfLifeDriver.grid.setColor(x, y, Color.BLACK);
		else GameOfLifeDriver.grid.setColor(x, y, Color.WHITE);
	}
	
	public void checkLife() {
		if (neighbors < 2 && alive) alive = false;
		else if ((neighbors == 2 || neighbors == 3) && alive) alive = true;
		else if (neighbors > 3 && alive) alive = false;
		else if (neighbors == 3 && !alive) alive = true;
	}
	
	public void checkNeighbors() {
		neighbors = 0;
		/*  [x-1,y-1] [x-1, y ] [x-1,y+1]
		 *  [ x ,y-1] [ x , y ] [ x ,y+1]
		 *  [x+1,y-1] [x+1, y ] [x+1,y+1]
		 */
		int xminus = x - 1;
		int yminus = y - 1;
		int xplus = x + 1;
		int yplus = y + 1;
		
		if (xminus >= 0) {
			if (GameOfLifeDriver.board[xminus][y].alive) neighbors++;
			if (yminus >= 0 && GameOfLifeDriver.board[xminus][yminus].alive) neighbors++;
			if (yplus < GameOfLifeDriver.grid.getWd() && GameOfLifeDriver.board[xminus][yplus].alive) neighbors++;
		}
		if (xplus < GameOfLifeDriver.grid.getHt()) {
			if (GameOfLifeDriver.board[xplus][y].alive) neighbors++;
			if (yminus >= 0 && GameOfLifeDriver.board[xplus][yminus].alive) neighbors++;
			if (yplus < GameOfLifeDriver.grid.getWd() && GameOfLifeDriver.board[xplus][yplus].alive) neighbors++;
		}
		if (yminus >= 0 && GameOfLifeDriver.board[x][yminus].alive) neighbors++;
		if (yplus < GameOfLifeDriver.grid.getWd() && GameOfLifeDriver.board[x][yplus].alive) neighbors++;
	}
}
