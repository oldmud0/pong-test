package mySlickGame;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class Projectile {
	
	private int speed;
	private int size;
	
	private int posX,posY;
	
	/** Creates new projectile. X and Y are the coordinates for the top left corner of the projectile.
	 * 
	 * @param X
	 * @param Y
	 * @param speed
	 * @param size
	 */
	public Projectile(int X, int Y, int spd, int siz) {
		posX = X;
		posY = Y;
		speed = spd;
		size = siz;
	}
	
	public void render(Graphics g) {
		
		g.fillRect(posX,posY,size,size);
		
		
	}
	
	public boolean update() {
		if (posX > SlickGame.windowX || posY > SlickGame.windowY) {
			return true;
		} else
			posY -= speed;
			return false;
	}
	
	
	public static void projectileRenderAll(Graphics g, ArrayList<Projectile> projectileList) {
		Projectile proj;
		for (int i = 0; i < projectileList.size(); i++) {
			proj = projectileList.get(i);
			proj.render(g);
		}
		proj = null;
	}
	
	public static void projectileUpdateAll(ArrayList<Projectile> projectileList) {
		Projectile proj;
		for (int i = 0; i < projectileList.size(); i++) {
			proj = projectileList.get(i);
			proj.update();
		}
		proj = null;
	}
}
