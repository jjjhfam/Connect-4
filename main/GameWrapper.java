package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import main.menu.Menu;

public class GameWrapper {

	private static JFrame frame;
	private static Board board;
	private static Menu menu;
	private static State activeState = State.Menu;
	
	public enum State {
		Menu,
		Game
	}
	
	public GameWrapper() {
		frame = new JFrame("Connect 4 by John Helmert V0.1");
		frame.addKeyListener(new KeyPatcher());
		frame.addMouseListener(new MousePatcher());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 600);
		
		menu = new Menu();
		board = new Board();
		
		frame.add(menu);
		frame.pack();
	}
	
	public static void setState(int state) {
		if(state == 1) {
			activeState = State.Game;
			
			menu.setVisible(false);
			
			frame.add(board);
		} else if (state == 0) {
			activeState = State.Menu;
			
			board.setVisible(false);
			
			frame.add(menu);
			
			board.reset();
		}
	}
	
	private class KeyPatcher extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(activeState == State.Menu) {
				menu.keyPressed(e.getKeyCode());
			} else if(activeState == State.Game) {
				board.keyPressed(e.getKeyCode());
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {}
	}
	
	private class MousePatcher implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(activeState == State.Menu) {
				
			} else if (activeState == State.Game) {
				board.mouseClicked(e);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
}
