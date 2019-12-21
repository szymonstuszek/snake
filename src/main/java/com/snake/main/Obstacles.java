package com.snake.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Obstacles {
	private int x, y, w, h;
	private Rectangle rect;
	
	public Obstacles() {
		x = 100;
		y = 150;
		w = 50; 
		h = 50;
		rect = new Rectangle(x,y,w,h);
	}
	
	public void paintObstacles(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, w, h);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	
	
}
