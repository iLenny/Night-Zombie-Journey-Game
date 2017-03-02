package njzgame.settings;

import javafx.scene.input.KeyCode;
import njzgame.Character;
/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: to give the ability to change controls key, and to connect the controls with a character.
 */
public class Controller {
	private static Controller singleton;
	
	private KeyCode moveRightKey;
	private KeyCode moveLeftKey;
	private KeyCode jumpKey;
	private KeyCode attackKey;
	
	private boolean moveRightKeyPressed = false;
	private boolean moveLeftKeyPressed = false;
	private boolean jumpKeyPressed = false;
	private boolean attackKeyPressed = false;
	
	// PRIVATE CONSTRUCTOR
	private Controller() {
		moveRightKey = Settings.DEFAULT_MOVE_RIGHT_KEY;
		moveLeftKey = Settings.DEFAULT_MOVE_LEFT_KEY;
		jumpKey = Settings.DEFAULT_JUMP_KEY;
		attackKey = Settings.DEFAULT_ATTACK_KEY;
	}
	
	// SINGLETON ACCESS
	public static Controller getInstance() {
		if(singleton == null) {
			singleton = new Controller();
		}
		return singleton;
	}
	
	// CONNECT CONTROLS WITH CHARACTER
	public void connectControlsWith(Character character) {
		character.setFocusTraversable(true);
		character.setOnKeyPressed(e->{
			// MOVE RIGHT KEY -- PRESSED
			if(e.getCode().equals(moveRightKey)) {
				moveRightKeyPressed = true;
			}
			
			// MOVE LEFT KEY -- PRESSED
			else if (e.getCode().equals(moveLeftKey)) {
				moveLeftKeyPressed = true;
			}
			
			// ATTACK KEY -- PRESSED
			if(e.getCode().equals(attackKey)) {
				attackKeyPressed = true;
			}
			
			// JUMP KEY -- PRESSED
			if(e.getCode().equals(jumpKey)) {
				jumpKeyPressed = true;
			}
		});
		
		character.setOnKeyReleased(e->{
			// MOVE RIGHT KEY -- RELEASE
			if(e.getCode().equals(moveRightKey)) {
				moveRightKeyPressed = false;
			}
			
			// MOVE LEFT KEY -- RELEASE
			else if (e.getCode().equals(moveLeftKey)) {
				moveLeftKeyPressed = false;
			}
			
			// ATTACK KEY -- RELEASE
			if(e.getCode().equals(attackKey)) {
				attackKeyPressed = false;
			}
			
			// JUMP KEY -- RELEASE
			if(e.getCode().equals(jumpKey)) {
				jumpKeyPressed = false;
			}
		});
		
		
		
	}

	// =========== GETTERS ===============//
	public KeyCode getMoveRightKey() {
		return moveRightKey;
	}

	public KeyCode getMoveLeftKey() {
		return moveLeftKey;
	}

	public KeyCode getJumpKey() {
		return jumpKey;
	}

	public KeyCode getAttackKey() {
		return attackKey;
	}

	public boolean isMoveRightKeyPressed() {
		return moveRightKeyPressed;
	}

	public boolean isMoveLeftKeyPressed() {
		return moveLeftKeyPressed;
	}

	public boolean isJumpKeyPressed() {
		return jumpKeyPressed;
	}

	public boolean isAttackKeyPressed() {
		return attackKeyPressed;
	}


	// ============= SETTERS ================ //

	public void setMoveRightKey(KeyCode moveRightKey) {
		this.moveRightKey = moveRightKey;
	}

	public void setMoveLeftKey(KeyCode moveLeftKey) {
		this.moveLeftKey = moveLeftKey;
	}

	public void setJumpKey(KeyCode jumpKey) {
		this.jumpKey = jumpKey;
	}

	public void setAttackKey(KeyCode attackKey) {
		this.attackKey = attackKey;
	}

}
