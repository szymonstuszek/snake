package main;

public class SnakeMovement {
	private Snake snake;
	
	public SnakeMovement(Snake snake) {
		this.snake = snake;
		
	}
	
	public void move() {
		//get the direction in which the snake is moving
		if(snake.getDirections() == Directions.EAST) {
			//move all of his body parts
			for(int i = snake.getSnakeLength(); i >= 0; i--) {
				//the head goes to a new location
				if(i == 0) {
					snake.getxPosition()[0] += Commons.DOT_SIZE;
					// if snake approaches the border he shows up at the other side
					if(snake.getxPosition()[0] == Commons.PANEL_WIDTH) {
						snake.getxPosition()[0] = 0;
					}
				//other body parts get the position assigned to the previous part	
				} else {
					snake.getxPosition()[i] = snake.getxPosition()[i - 1];
					snake.getyPosition()[i] = snake.getyPosition()[i - 1];
				}
			}
			
		} else if(snake.getDirections() == Directions.NORTH) {
			for(int i = snake.getSnakeLength(); i >= 0; i--) {
				if(i == 0) {
					snake.getyPosition()[0] -= Commons.DOT_SIZE;
					if(snake.getyPosition()[0] < 0) {
						snake.getyPosition()[0] = Commons.PANEL_HEIGHT - Commons.DOT_SIZE;
					}
				} else {
					snake.getxPosition()[i] = snake.getxPosition()[i - 1];
					snake.getyPosition()[i] = snake.getyPosition()[i - 1];
				}
			}
			
		} else if(snake.getDirections() == Directions.WEST) {
			for(int i = snake.getSnakeLength(); i >= 0; i--) {
				if(i == 0) {
					snake.getxPosition()[0] -= Commons.DOT_SIZE;
					if(snake.getxPosition()[0] < 0) {
						snake.getxPosition()[0] = Commons.PANEL_WIDTH - Commons.DOT_SIZE;
					}
				} else {
					snake.getxPosition()[i] = snake.getxPosition()[i - 1];
					snake.getyPosition()[i] = snake.getyPosition()[i - 1];
				}
			}
			
		} else if(snake.getDirections() == Directions.SOUTH) {
			for(int i = snake.getSnakeLength(); i >= 0; i--) {
				if(i == 0) {
					snake.getyPosition()[0] += Commons.DOT_SIZE;
					if(snake.getyPosition()[0] == Commons.PANEL_HEIGHT) {
						snake.getyPosition()[0] = 0;
					}
				} else {
					snake.getxPosition()[i] = snake.getxPosition()[i - 1];
					snake.getyPosition()[i] = snake.getyPosition()[i - 1];
				}
			}
			
		}
	}
	
	public boolean doesBiteHimself() {
		for(int i = snake.getSnakeLength(); i > 0; i--) {
			if(snake.getyPosition()[0] == snake.getyPosition()[i]  
				&& snake.getxPosition()[0] == snake.getxPosition()[i]) {
				return true;
			}
			
		}
		return false;
	}
	
	public void checkCollision() {
		
		if(snake.getObstacles().getRect().contains(snake.getxPosition()[0], snake.getyPosition()[0])
				|| ( snake.getSnakeLength() > 4 && doesBiteHimself())) {
			snake.setInGame(false);
		}
	}
	
}
