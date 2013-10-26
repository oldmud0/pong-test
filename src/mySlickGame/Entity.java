package mySlickGame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public abstract class Entity {
	protected Image drawBuffer;
	
	public int x, y, w, h;
	
	public Entity(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		try {
			drawBuffer = new Image(w, h);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	abstract void render(Graphics g);
	abstract void update(int delta);
	
	public Graphics getGraphics() {
		try {
			return drawBuffer.getGraphics();
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Image getDrawBuffer() {
		return drawBuffer;
	}
}
