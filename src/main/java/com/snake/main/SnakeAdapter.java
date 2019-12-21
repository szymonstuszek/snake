package com.snake.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SnakeAdapter extends KeyAdapter{
	private Snake snake;
	
	public SnakeAdapter(Snake snake) {
		this.snake = snake;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(!snake.moveAssigned) {
			if((key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
					&& snake.getDirections() != Directions.SOUTH) {
				snake.setDirections(Directions.NORTH);
				
			} else if((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) 
					&& snake.getDirections() != Directions.NORTH) {
				snake.setDirections(Directions.SOUTH);
				
			} else if((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) 
					&& snake.getDirections() != Directions.WEST) {
				snake.setDirections(Directions.EAST);
				
			} else if((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) 
					&& snake.getDirections() != Directions.EAST) {
				snake.setDirections(Directions.WEST);
				
			}
			snake.moveAssigned = true;
		}
		
		if(!snake.isInGame()) {
			if(key == KeyEvent.VK_SPACE) {
				snake.setInGame(true);
				snake.restartGame();
			}
		}
	}

}
