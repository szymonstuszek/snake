package main;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class SnakeGraphics {
	private Image head;
	private Image dot;
	private Image apple;
	
	public SnakeGraphics() {
		initGraphics();
	}
	
	public void initGraphics() {
		URL url = SnakeGraphics.class.getResource("/res/head.png");
		ImageIcon headIcon = new ImageIcon(url);
		
		url = SnakeGraphics.class.getResource("/res/dot.png");
		ImageIcon dotIcon = new ImageIcon(url);
		
		url = SnakeGraphics.class.getResource("/res/apple.png");
		ImageIcon appleIcon = new ImageIcon(url);
		
		head = headIcon.getImage();
		dot = dotIcon.getImage();
		apple = appleIcon.getImage();
		
	}

	public Image getHead() {
		return head;
	}

	public void setHead(Image head) {
		this.head = head;
	}

	public Image getDot() {
		return dot;
	}

	public void setDot(Image dot) {
		this.dot = dot;
	}

	public Image getApple() {
		return apple;
	}

	public void setApple(Image apple) {
		this.apple = apple;
	}
	
	
}
