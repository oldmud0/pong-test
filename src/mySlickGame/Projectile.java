package mySlickGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Projectile extends Entity {
	
	private int speed;
	
	/** Creates new projectile. X and Y are the coordinates for the top left corner of the projectile.
	 * 
	 * @param X
	 * @param Y
	 * @param speed
	 * @param size
	 */
	public Projectile(int x, int y, int speed, int size) {
		super(x, y, size, size);
		this.speed = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, w, h);
	}
	
	@Override
	public void update(int delta) {
		if (y > 0) {
			y -= speed;
		} else {
			SlickGame.instance.entities.remove(this);
		}
	}
}
