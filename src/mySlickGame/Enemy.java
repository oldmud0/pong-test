package mySlickGame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Graphics;

public class Enemy implements Entity {
	private BufferedImage objImage;



	@Override
	public void render(Graphics g) {
		try {
			objImage = ImageIO.read(new File("res/character.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}}
