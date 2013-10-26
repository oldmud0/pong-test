package mySlickGame;

public class Sequence implements Runnable {
	
	private String slides[];
	private int slideNo = 0;
	
	public void run() {
		try {
			for (int i = 0; i < slides.length; i++) {
				getSlide();
				Thread.sleep(1000);
				nextSlide();
			}
			SlickGame.gameState = GameState.GAME;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Sequence(String[] slideList) {
		slides = slideList;
	}
	
	/** Returns the current slide. **/
	public void getSlide() {
		SlickGame.pushedSlide = slides[slideNo];
	}
	
	/** Increments slide and returns it. **/
	public void nextSlide() {
		slideNo++;
	}
	
	
}
