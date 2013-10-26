package mySlickGame;

import java.awt.image.BufferedImage;

import org.newdawn.slick.Graphics;

public interface Entity {
	BufferedImage objImage = null;
	
	void render(Graphics g);
	void update();
}
