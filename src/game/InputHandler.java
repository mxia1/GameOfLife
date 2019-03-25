package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import GridTools.MyGrid;

public class InputHandler extends JPanel implements KeyListener {

	static ArrayList<Integer> inputs; 
	
	public InputHandler(MyGrid grid) {
		grid.addKeyListener(this);
		inputs = new ArrayList<Integer>();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("in keypressed");
		if (!inputs.contains(e.getKeyCode())) inputs.add(new Integer(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (inputs.contains(e.getKeyCode())) inputs.remove(new Integer(e.getKeyCode()));	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
