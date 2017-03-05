package njzgame.behaviors;

import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import njzgame.Map;
import njzgame.Character;
import njzgame.interfaces.Behavior;
import njzgame.settings.Controller;
import njzgame.settings.Settings;
/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: To be used as side scrolling effect/behavior on the Map class
 */
public class SideScrollingBehavior implements Behavior {
	private static final double LEFT_OFFSET = Settings.WINDOW_WIDTH * 0.3;   // 30% of the screen
	private static final double RIGHT_OFFSET = Settings.WINDOW_HEIGHT * 0.8; // 80% of the screen
	
	private Map map;
	private ImageView backgroundView;
	private ImageView stageView;
	private Character player;


	private double stageWidth;
	private double stageHeight;
	private ArrayList<Node> objectList;
	
	// CONSTRUCTOR
	public SideScrollingBehavior(Map map) {
		this.map = map;
		backgroundView = map.getBackgroundView();
		stageView = map.getStageView();
		player = map.getPlayer();
		stageWidth = map.getStageViewWidth();
		stageHeight = map.getStageViewHeight();
		this.objectList = map.getObjectList();
		
	}
	
	//====== GETTERS ========//
	public Map getMap() {
		return map;
	}

	
	//====== SETTERS =========//
	public void setMap(Map map) {
		this.map = map;
	}
	
	@Override
	public void performBehavior() {
		player.setExertedGravity(player.getExertedGravity()+ Settings.GRAVITY_RATE);
		player.setTranslateY(player.getTranslateY() + player.getExertedGravity());		
		
		// We need the bounds to know their exact location
		Bounds playerBounds = player.localToScene(player.getBoundsInLocal());
		Bounds stageViewBounds = stageView.localToScene(stageView.getBoundsInLocal());
		
		
		// Get their X-location
		double playerX = playerBounds.getMinX();
		double playerY = playerBounds.getMinY();
		double stageViewX = stageViewBounds.getMinX();
		double stageViewY = stageViewBounds.getMinY();
		double endXArea = -(stageWidth - Settings.WINDOW_WIDTH); 
		double endYArea = -(stageHeight - Settings.WINDOW_HEIGHT);
		
		// We only want the side-scrolling effect, when the player is moving side ways
		// We need to know when user is pressing right or left key, therefore we need 
		// the controller class to find out what key was pressed.
		Controller controller = Controller.getInstance();
		
		// When pressing right-key AND 
		// player's x location is greater than RIGHT_OFFSET AND
		// the player its not at the end of the stageView THEN
		// Move everything to the left
		if(controller.isMoveRightKeyPressed() && playerX > RIGHT_OFFSET && stageViewX > endXArea) {
			moveEverythingToTheLeft();
		}
		
		// When pressing left-key AND 
		// player's x location is less than LEFT_OFFSET AND
		// the player its not at the beginning of the stageView THEN
		// Move everything to the right.
		else if(controller.isMoveLeftKeyPressed() && playerX < LEFT_OFFSET && stageViewX < 0) {
			moveEverythingToTheRight();
		}
		
		if(playerY > 400) {
			moveEverythingUp();
		}
		
		
		
	}
	
	
	// MOVES EVERTHING TO THE LEFT
	private void moveEverythingToTheLeft() {
		player.setTranslateX(player.getTranslateX() - player.getSpeed());
		stageView.setTranslateX(stageView.getTranslateX() - player.getSpeed());
		backgroundView.setTranslateX(backgroundView.getTranslateX() - player.getSpeed()/3);
		
		for(int i = 0; i < objectList.size(); i++) {
			Node object = objectList.get(i);
			object.setTranslateX(object.getTranslateX() - player.getSpeed());
		}
	}
	
	// MOVES EVERYTHING TO THE RIGHT
	private void moveEverythingToTheRight() {
		player.setTranslateX(player.getTranslateX() + player.getSpeed());
		stageView.setTranslateX(stageView.getTranslateX() + player.getSpeed());
		backgroundView.setTranslateX(backgroundView.getTranslateX() + player.getSpeed()/3);
		
		for(int i = 0; i < objectList.size(); i++) {
			Node object = objectList.get(i);
			object.setTranslateX(object.getTranslateX() + player.getSpeed());
		}
	}
	
	// MOVES EVERYTHING TO THE DOWN
	private void moveEverythingDown() {
		player.setTranslateY(player.getTranslateY() + player.getJumpPower());
		stageView.setTranslateY(stageView.getTranslateY() + player.getJumpPower());
		backgroundView.setTranslateY(backgroundView.getTranslateY() + player.getJumpPower()/3);
		
		for(int i = 0; i < objectList.size(); i++) {
			Node object = objectList.get(i);
			object.setTranslateY(object.getTranslateY() + player.getJumpPower());
		}
	}
	
	// MOVES EVERYTHING TO THE DOWN
	private void moveEverythingUp() {
		player.setTranslateY(player.getTranslateY() - player.getExertedGravity());
		stageView.setTranslateY(stageView.getTranslateY() - player.getExertedGravity());
		backgroundView.setTranslateY(backgroundView.getTranslateY() - player.getExertedGravity()/3);
		
		for(int i = 0; i < objectList.size(); i++) {
			Node object = objectList.get(i);
			object.setTranslateY(object.getTranslateY() - player.getExertedGravity());
		}
	}
	
	
}
