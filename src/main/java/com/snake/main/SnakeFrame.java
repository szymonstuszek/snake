package com.snake.main;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
	private static final long serialVersionUID = -6420192512594235953L;
	private Snake snake;

	public SnakeFrame() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Snake");
	setResizable(false);
	setVisible(true);
	
	snake = new Snake();
	
	add(snake);
	pack();
	}
}
