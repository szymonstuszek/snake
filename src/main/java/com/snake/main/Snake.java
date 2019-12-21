package com.snake.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener {
	private static final long serialVersionUID = -9220583424238816840L;
	private int panelWidth = Commons.PANEL_WIDTH;
	private int panelHeight = Commons.PANEL_HEIGHT;
	private Dimension dim = new Dimension(panelWidth, panelHeight);
	
	private SnakeGraphics snakeGraphics;
	private SnakeAdapter snakeAdapter;
	private SnakeMovement snakeMovement;
	private Random r = new Random();
	private Timer timer;
	private Directions directions;
	private Obstacles obstacles;
	
	private int xPosition[] = new int[Commons.ALL_DOTS];
	private int yPosition[] = new int[Commons.ALL_DOTS];
	private int appleX = Commons.APPLE_X, appleY = Commons.APPLE_Y;
	
	private int snakeLength;
	private boolean inGame;
	
	// variable to prevent from hitting several buttons at once
	// and to skip moves
	public boolean moveAssigned = false;
	
	
	
	public Snake() {
		initBoard();
		initGame();
	}
	
	public void initBoard() {
		setBackground(Color.BLACK);
		setPreferredSize(dim);
		setFocusable(true);
		
		obstacles = new Obstacles();
		snakeGraphics = new SnakeGraphics();
		snakeAdapter = new SnakeAdapter(this);
		snakeMovement = new SnakeMovement(this);
	}
	
	public void initGame() {
		inGame = true;
		timer = new Timer(Commons.DELAY, this);
		initSnake();
		addKeyListener(snakeAdapter);
		timer.start();
	}
	
	public void restartGame() {
		if(inGame) {
			initSnake();
			generateApple();
			timer.start();
		}
	}
	
	public void initSnake() {
		this.setDirections(Directions.EAST);
		snakeLength = Commons.NUMBER_OF_SNAKE_BODY_PARTS;
		for(int i = 0; i < snakeLength; i++) {
			xPosition[i] = 50 - i * 10;
			yPosition[i] = 50;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) {
			g.drawImage(snakeGraphics.getApple(), appleX, appleY, null);
			obstacles.paintObstacles(g);
			
			for(int i = 0; i < snakeLength; i++) {
				if(i == 0) {
					g.drawImage(snakeGraphics.getHead(), xPosition[i], yPosition[i], null);
				} else {
					g.drawImage(snakeGraphics.getDot(), xPosition[i], yPosition[i], null);
				}
			}
			
		} else {
			gameOver(g);
		}
		
	}
	
	public void gameOver(Graphics g) {
		String message1 = "Game over", message2 = "Press SPACE to continue";
		Font font = new Font("Helvetica", Font.BOLD, 18);
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString(message1, Commons.PANEL_WIDTH / 2 - 50, Commons.PANEL_HEIGHT / 2);
		g.drawString(message2, Commons.PANEL_WIDTH / 2 - 100, Commons.PANEL_HEIGHT / 2 + 30);
		
		timer.stop();
	}

	public void generateApple() {
		appleX = r.nextInt(30) * Commons.DOT_SIZE;
		appleY = r.nextInt(30) * Commons.DOT_SIZE;
		
		//if apple gets generated on the obstacle, create it again
		if(appleX >= 100 && appleX <= 150 && appleY >= 150 && appleY <= 200) {
			generateApple();
		}
	}
	
	public void checkApple() {
		if(appleX == xPosition[0] && appleY == yPosition[0]) {
			generateApple();
			snakeLength++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(inGame) {
				moveAssigned = false;
				if(!moveAssigned) {
				snakeMovement.move();
				snakeMovement.checkCollision();
				}
				checkApple();
			}
			repaint();
	}

	public int[] getxPosition() {
		return xPosition;
	}

	public void setxPosition(int[] xPosition) {
		this.xPosition = xPosition;
	}

	public int[] getyPosition() {
		return yPosition;
	}

	public void setyPosition(int[] yPosition) {
		this.yPosition = yPosition;
	}

	public int getSnakeLength() {
		return snakeLength;
	}

	public void setSnakeLength(int snakeLength) {
		this.snakeLength = snakeLength;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public Obstacles getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacles obstacles) {
		this.obstacles = obstacles;
	}

	public Directions getDirections() {
		return directions;
	}

	public void setDirections(Directions directions) {
		this.directions = directions;
	}

}
