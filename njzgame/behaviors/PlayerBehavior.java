package njzgame.behaviors;

import njzgame.interfaces.Behavior;
import njzgame.interfaces.Direction;
import njzgame.settings.Controller;
import njzgame.tools.Debug;
import njzgame.Character;

/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: To represent the behavior of a Character intended to be a player, and to respond
 *  		 to the Controller's events
 *  INPUT: attackBehavior, walkBehavior, jumpBehavior, character
 */
public class PlayerBehavior implements Behavior{
	private Controller controller = Controller.getInstance();
	private Character player;
	private int rightScale = 1;
	private int leftScale = -1;
	
	// BEHAVIORS:
	private Behavior attackBehavior;
	private Behavior walkBehavior;
	private Behavior jumpBehavior;
	
	//FLAGS
	private boolean walking = false;
	
	
	
	
	
	// CONSTRUCTOR
	public PlayerBehavior(Character player) {
		this.player = player;
		walkBehavior = new DefaultWalkBehavior(player);
		jumpBehavior = new DefaultJumpBehavior();
		attackBehavior = new DefaultAttackBehavior();
		
	}
	
	@Override
	public void performBehavior() {
		// Stand-Sprite
		if(!walking) {
			player.getCharacterView().setViewport(player.getStandingSprites().getSpriteBlock());
		}
		
		
		
		// RESPOND TO MOVE-RIGHT-PRESSED
		if(controller.isMoveRightKeyPressed()) {
			walking = true;
			if (walkBehavior instanceof Direction) {				
				((Direction)walkBehavior).setDirection(Direction.RIGHT);
			}			
			walkBehavior.performBehavior();
			doWalkSprites();
			player.getCharacterView().setScaleX(rightScale);
			
		}
		
		// RESPOND TO MOVE-LEFT-PRESSED
		else if(controller.isMoveLeftKeyPressed()) {
			walking = true;
			if (walkBehavior instanceof Direction) {
				((Direction)walkBehavior).setDirection(Direction.LEFT);
			}
			walkBehavior.performBehavior();
			doWalkSprites();
			player.getCharacterView().setScaleX(leftScale);
			
		}
		else {
			walking = false;
			player.getStandingSprites().reset();
		}
		
		// RESPOND TO JUMP-KEY-PRESSED
		if(controller.isJumpKeyPressed()) {
			jumpBehavior.performBehavior();
		}
		
		// RESPOND TO ATTACK-KEY-PRESSED
		if(controller.isAttackKeyPressed()) {
			attackBehavior.performBehavior();
		}
	}
	
	private void doWalkSprites() {
		if(player.getWalkSprites() != null) {
			player.getCharacterView().setViewport(player.getWalkSprites().getSpriteBlock());
		}
		else {
			// FOR DEBUG
			Debug.printErrorMessage(this.getClass(), "Character", player.getName() + " does not have sprites for walking");
		}
	}

	public int getRightScale() {
		return rightScale;
	}

	public int getLeftScale() {
		return leftScale;
	}

	public void setRightScale(int rightScale) {
		this.rightScale = rightScale;
	}

	public void setLeftScale(int leftScale) {
		this.leftScale = leftScale;
	}
}
