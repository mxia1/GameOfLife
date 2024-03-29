package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Cursor{
	int x;
	int y;
	int deltax;
	int deltay;
	
	Cursor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setCursor() {
		// need to set color back to black or white when cursor moves
		GameOfLifeDriver.board[deltax][deltay].setColor();
		GameOfLifeDriver.grid.setColor(x, y, Color.RED);
	}
	
	public void moveCursor() {
		deltax = x;
		deltay = y;
		
		// arrow key movement commands
		if(InputHandler.inputs.contains(new Integer(KeyEvent.VK_UP)))
			x--;
		if(InputHandler.inputs.contains(new Integer(KeyEvent.VK_DOWN)))
			x++;
		if(InputHandler.inputs.contains(new Integer(KeyEvent.VK_LEFT)))
			y--;
		if(InputHandler.inputs.contains(new Integer(KeyEvent.VK_RIGHT)))
			y++;
		
		//make sure cursor doesn't go out of bound
		//System.out.println("the width is: " + GameOfLifeDriver.grid.getWd() + " and x is at: " + x);
		if (x > GameOfLifeDriver.grid.getHt() - 1) x = GameOfLifeDriver.grid.getHt() - 1;
		if (x < 0) x = 0;
		if (y > GameOfLifeDriver.grid.getWd() - 1) y = GameOfLifeDriver.grid.getWd() - 1;
		if (y < 0) y = 0;
		
		// pause button
		if(InputHandler.inputs.contains(new Integer(KeyEvent.VK_P))) {
			if (GameOfLifeDriver.isPaused) GameOfLifeDriver.isPaused = false;
			else GameOfLifeDriver.isPaused = true;
			// without code below pressing p doesn't work sometimes 
			InputHandler.inputs.remove(new Integer(KeyEvent.VK_P));
		}
		
		// space button
		if(InputHandler.inputs.contains(new Integer(KeyEvent.VK_SPACE))) {
			if (GameOfLifeDriver.isPaused) {
				if (GameOfLifeDriver.board[x][y].alive) GameOfLifeDriver.board[x][y].alive = false;
				else GameOfLifeDriver.board[x][y].alive = true;
				GameOfLifeDriver.board[x][y].setColor();
			}
		}
	}
}
