package mySlickGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

public class SlickGame extends BasicGame implements KeyListener {

	public static SlickGame instance;
	
	private int paddleBoundsLeft, paddleBoundsRight, paddleLength;

	public static final int windowX = 1024;
	public static final int windowY = 768;

	/**
	 * gameState basically is the master switch of the game. It informs
	 * everything about the current state of the game.
	 * 
	 * 
	 */
	public static GameState gameState;

	private Map<String, Integer> controls = new HashMap<String, Integer>();
	public List<Entity> entities = new ArrayList<Entity>();
	public List<Entity> deadEntities = new ArrayList<Entity>();

	// Sequences
	public static String pushedSlide;
	Sequence intro = new Sequence(new String[] { "Level 1", "Start" });

	public SlickGame(String title) {
		super(title);
		instance = this;
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc = new AppGameContainer(new SlickGame(
					"A Slick Game"));
			appgc.setDisplayMode(windowX, windowY, false);
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(SlickGame.class.getName()).log(Level.SEVERE,
					"An error has occurred.", e);
		}
	}

	public void render(GameContainer container, Graphics g)
			throws SlickException {

		// Set colors
		g.setBackground(new Color(255, 255, 255));
		g.setColor(new Color(0, 0, 0));

		for (Entity e : entities) {
			e.render(e.getGraphics());
			g.drawImage(e.getDrawBuffer(), e.x, e.y); 
		}

		switch (gameState) {
		case INTRO:
			g.drawString(pushedSlide, Math.round(windowX / 2),
					Math.round(windowY * .25));

		case GAME:
			paddleRender(g);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// Controls
		controls.put("left", Input.KEY_LEFT);
		controls.put("right", Input.KEY_RIGHT);
		controls.put("shoot", Input.KEY_SPACE);

		// Initial values
		paddleBoundsLeft = 900;
		paddleBoundsRight = 950;
		paddleLength = 50;

		gameState = GameState.INTRO;
		new Thread(intro).start();

		// Rendering options
		container.setSmoothDeltas(false);
	}

	public void update(GameContainer container, int delta)
			throws SlickException {
		switch (gameState) {
		case GAME:
			paddleMove(container.getInput());
			
			for (Entity ent : entities) {
				ent.update(delta);
			}

		case INTRO:

		}

	}

	public void keyPressed(int key, char c) {
		if (key == controls.get("shoot")) {
			entities.add(new Projectile(paddleBoundsLeft
					+ Math.round(paddleLength / 2), 758, 10, 4));
		}
	}

	// Paddle actions
	public void paddleMove(Input input) {
		if (input.isKeyDown(controls.get("left")) && paddleBoundsLeft > 1) {
			paddleBoundsLeft -= 5;
		} else if (input.isKeyDown(controls.get("right"))
				&& paddleBoundsRight < 1023) {
			paddleBoundsLeft += 5;
		}

		paddleBoundsLeft = (paddleBoundsLeft < 1) ? 1 : paddleBoundsLeft; // Clamps
		// paddleBoundsLeft.

		if (paddleBoundsRight > windowX - 1) { // Effectively clamps
			// paddleBoundsRight.
			paddleBoundsRight = windowX - 1;
			paddleBoundsLeft = paddleBoundsRight - paddleLength;
		}
		paddleBoundsRight = paddleBoundsLeft + paddleLength; // Makes sure that
		// paddleBoundsRight
		// is correctly
		// set relative
		// to
		// paddleBoundsLeft.
	}

	public void paddleRender(Graphics g) {
		g.fillRect(paddleBoundsLeft, 762, paddleLength, 5);
	}
		
	public void killEntity(Entity e) {
		deadEntities.add(e);
	}

}
