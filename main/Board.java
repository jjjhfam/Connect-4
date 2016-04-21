package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	private static final long serialVersionUID = -4164399171087825925L;
	
	private static final int TILE_SIZE = 100;
	private static final int BOARD_X = 7;
	private static final int BOARD_Y = 6;
	
	private static int[][] boardArea = new int[7][6];
	
	private static final int RED = 1;
	private static final int BLUE = 2;
	
	private static int columnZeroLowest = 5;
	private static int columnOneLowest = 5;
	private static int columnTwoLowest = 5;
	private static int columnThreeLowest = 5;
	private static int columnFourLowest = 5;
	private static int columnFiveLowest = 5;
	private static int columnSixLowest = 5;
	private static int currentColor;
	
	private static int consecutives = 0;
	
	/*
	 * Do NOT forget to optimize the algorithm to add the checkers at the bottom and fix the column*Lowest vars
	*/
	
	public Board() {
		super();
		setPreferredSize(new Dimension(BOARD_X * TILE_SIZE, BOARD_Y * TILE_SIZE));
		setBackground(Color.YELLOW);
		currentColor = 1;
	}
	
	public void start() {
		
	}
	
	public void reset() {
		boardArea = new int[7][6];
		columnZeroLowest = 5;
		columnOneLowest = 5;
		columnTwoLowest = 5;
		columnThreeLowest = 5;
		columnFourLowest = 5;
		columnFiveLowest = 5;
		columnSixLowest = 5;
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for(int x = 0; x < 7; x++) {
			for(int y = 0; y < 6; y++) {
				if(boardArea[x][y] == RED) {
					g2d.setPaint(Color.RED);
					g2d.fillOval((x * TILE_SIZE) + 10, (y * TILE_SIZE) + 10, TILE_SIZE - 20, TILE_SIZE - 20);
				} else if(boardArea[x][y] == BLUE) {
					g2d.setPaint(Color.BLUE);
					g2d.fillOval((x * TILE_SIZE) + 10, (y * TILE_SIZE) + 10, TILE_SIZE - 20, TILE_SIZE - 20);
				} else {
					g2d.setPaint(Color.WHITE);
					g2d.fillOval((x * TILE_SIZE) + 10, (y * TILE_SIZE) + 10, TILE_SIZE - 20, TILE_SIZE - 20);
				}
			}
		}
	}
	
	private void placePiece(int color, int column) {
/*		for(int n = 1; n <= 6; n++) {
			if(boardArea[n][column] == 0) {
				System.out.println(n + " " + column);
				boardArea[n][column] = color;
				repaint();
				break;
			}
		}
*/		
		switch(column) {
			case 0:
				boardArea[column][columnZeroLowest] = color;
				columnZeroLowest--;
				break;
			case 1:
				boardArea[column][columnOneLowest] = color;
				columnOneLowest--;
				break;
			case 2:
				boardArea[column][columnTwoLowest] = color;
				columnTwoLowest--;
				break;
			case 3:
				boardArea[column][columnThreeLowest] = color;
				columnThreeLowest--;
				break;
			case 4:
				boardArea[column][columnFourLowest] = color;
				columnFourLowest--;
				break;
			case 5:
				boardArea[column][columnFiveLowest] = color;
				columnFiveLowest--;
				break;
			case 6:
				boardArea[column][columnSixLowest] = color;
				columnSixLowest--;
				break;
			default:
				System.out.println("Something isn't right...");
				break;
		}
		
		repaint();
		
		if(checkWin()) {
			
		}
	}
	
	private boolean checkWin() {
		return false;
	}
	
	public void mouseClicked(MouseEvent e) {
		int column = e.getX()/TILE_SIZE;
		int row = e.getY()/TILE_SIZE;

		System.out.println(column + " " + row);
		
		placePiece(currentColor, column);
		
		if(currentColor == 1) {
			currentColor = 2;
		} else if (currentColor == 2) {
			currentColor = 1;
		}
	}
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_ESCAPE) {
			reset();
			repaint();
		}
	}
}
