package main.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import main.GameWrapper;

public class Menu extends JPanel {

	private static final long serialVersionUID = 2167422985223813277L;

	private static int selectedItem = 0;
	
	private static final String TITLE = "Connect 4";
	private static final String AUTHOR = "John Helmert III 2016";
	private static final String START_GAME = "Start Game!";
	private static final String ABOUT = "About";
	private static final String QUIT = "Quit";

	public Menu() {
		super();
		setPreferredSize(new Dimension(700,600));
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
//		g2d.drawLine(350, 0, 350, 600);
		
	    FontMetrics metrics;

	    g2d.setFont(new Font("ComicSans", Font.PLAIN, 60));
	    metrics = g.getFontMetrics(g2d.getFont());
	    g2d.drawString(TITLE, 350 - metrics.stringWidth(TITLE)/2, 200);
	    g2d.setFont(new Font("ComicSans", Font.PLAIN, 24));
	    metrics = g.getFontMetrics(g2d.getFont());
	    g2d.drawString(AUTHOR, 350 - metrics.stringWidth(AUTHOR)/2, 200 + metrics.getAscent());
	    
	    g2d.setFont(new Font("ComicSans", Font.PLAIN, 20));
	    if (selectedItem == 0) {
	    	g2d.setColor(Color.RED);
	    	g2d.drawString(START_GAME, 350 - metrics.stringWidth(START_GAME)/2, 400);
	    	g2d.setColor(Color.BLACK);
	    	g2d.drawString(QUIT, 350 - metrics.stringWidth(QUIT)/2, 450);
	    } else if (selectedItem == 1) {
	    	g2d.drawString(START_GAME, 350 - metrics.stringWidth(START_GAME)/2, 400);
	    	g2d.setColor(Color.RED);
	    	g2d.drawString(QUIT, 350 - metrics.stringWidth(QUIT)/2, 450);
	    }
	}
	
	public void keyPressed(int key) {
		System.out.println("Key Pressed");
		
		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			if(selectedItem == 1) {
				selectedItem = 0;
			} else {
				selectedItem++;
			}
		} else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			if(selectedItem == 0) {
				selectedItem = 1;
			} else {
				selectedItem--;
			}
		} else if (key == KeyEvent.VK_ENTER) {
			if(selectedItem == 0) {
				GameWrapper.setState(1);
			} else if (selectedItem == 1) {
				System.exit(0);
			}
		}
		
		repaint();
	}
}
