package njzgame.behaviors;

import njzgame.interfaces.Behavior;
import njzgame.interfaces.Direction;
import njzgame.Character;

/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: to represent the walking behavior of character
 */
public class DefaultWalkBehavior implements Behavior, Direction {
	private Character character;
	private int direction;
	
	// ============== CONSTRUCTORS ============== //
	// Constructor(Character)
	public DefaultWalkBehavior(Character character) {
		this.character = character;
	}

	@Override
	public void performBehavior() {
		if(direction == RIGHT) {
			character.setTranslateX(character.getTranslateX() + character.getSpeed());
		}
		else if (direction == LEFT) {
			character.setTranslateX(character.getTranslateX() - character.getSpeed());
		}
	}
	
	@Override
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	@Override
	public int getDirection() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
