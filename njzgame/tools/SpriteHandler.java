package njzgame.tools;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;

public class SpriteHandler {
	int count = 0;
	int delay;
	int delayCount = 0;
	private Rectangle2D [] spriteBlocks;
	private Location [] locations;
	
	/*
	 *  CONSTRUCTOR(Rectangle2D)
	 *  @param spriteImage contains all the sprite
	 */	
	public SpriteHandler(int delay, Rectangle2D [] spriteBlocks) {
		this.spriteBlocks = spriteBlocks;
		this.delay = delay;
	}
	
	public Rectangle2D getSpriteBlock () {
		if(delayCount >= delay) {
			if(count < spriteBlocks.length-1) {
				count++;
			}
			else {
				count = 0;
			}
			delayCount = 0;
		}
		else {
			delayCount++;
		}
		
		
		return spriteBlocks[count];
	}
	
	public Rectangle2D getSpriteBlock (Location [] locations, Node object) {
		if(delayCount >= delay) {
			if(count < spriteBlocks.length-1) {
				count++;
			}
			else {
				count = 0;
			}
			delayCount = 0;
		}
		else {
			delayCount++;
		}
		
		object.setTranslateX(locations[count].getX());
		object.setTranslateY(locations[count].getY());
		return spriteBlocks[count];
	}
	
	public void reset() {
		count = 0;
		delayCount = 0;
	}
	
	
}
