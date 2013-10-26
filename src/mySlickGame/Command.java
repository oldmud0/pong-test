package mySlickGame;

/**
 * An interface used for binding keys to actions.
 * 
 */
public class Command {
	private String name;
	private int key;
	
	public Command(String name, int key) {
		this.name = name;
		this.key = key;
	}
	
	public String getName() {
		return name;
	}
	
	public void assignKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}
