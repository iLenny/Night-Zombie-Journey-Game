package njzgame.behaviors;

import njzgame.interfaces.Behavior;
import njzgame.interfaces.Direction;
import njzgame.settings.Controller;
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
	
	// BEHAVIORS:
	private Behavior attackBehavior;
	private Behavior walkBehavior;
	private Behavior jumpBehavior;
	
	
	
	// CONSTRUCTOR
	public PlayerBehavior(Character player) {
		this.player = player;
		walkBehavior = new DefaultWalkBehavior(player);
		jumpBehavior = new DefaultJumpBehavior();
		attackBehavior = new DefaultAttackBehavior();
		
	}
	
	@Override
	public void performBehavior() {
		// RESPOND TO MOVE-RIGHT-PRESSED
		if(controller.isMoveRightKeyPressed()) {
			if (walkBehavior instanceof Direction) {				
				((Direction)walkBehavior).setDirection(Direction.RIGHT);
			}			
			walkBehavior.performBehavior();
			
			// DEBUGGING:
			System.out.println(
					"FROM PlayerBehavior: (Character) " + player.getName() +
				    " moving RIGHT X-AXIS: "  + player.getTranslateX());
		}
		
		// RESPOND TO MOVE-LEFT-PRESSED
		else if(controller.isMoveLeftKeyPressed()) {
			if (walkBehavior instanceof Direction) {
				((Direction)walkBehavior).setDirection(Direction.LEFT);
			}
			walkBehavior.performBehavior();
			
			// DEBUGGING:
			System.out.println(
					"FROM PlayerBehavior: (Character) " + player.getName() +
				    " moving LEFT X-AXIS: "  + player.getTranslateX());
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
}
