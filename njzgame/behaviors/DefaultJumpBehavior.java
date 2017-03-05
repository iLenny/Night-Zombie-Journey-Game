package njzgame.behaviors;

import njzgame.interfaces.Behavior;
import njzgame.settings.Settings;
import njzgame.Character;

public class DefaultJumpBehavior implements Behavior {
	private Character character;
	private int currentJump;
	
	public DefaultJumpBehavior(Character character) {
		this.character = character;
		currentJump = character.getJumpPower();
	}
	
	@Override
	public void performBehavior() {
		character.setTranslateY(character.getTranslateY()-currentJump);
		currentJump -= Settings.GRAVITY_RATE;
		
	}
	
	public void jumpReset() {
		currentJump = character.getJumpPower();
	}

}
