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
	private ArrayList<Node> objectList;
	
	// CONSTRUCTOR
	public SideScrollingBehavior(Map map) {
		this.map = map;
		backgroundView = map.getBackgroundView();
		stageView = map.getStageView();
		player = map.getPlayer();
		stageWidth = map.getStageViewWidth();
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
		
		// We need the bounds to know their exact location
		Bounds playerBounds = player.localToScene(player.getBoundsInLocal());
		Bounds stageViewBounds = stageView.localToScene(stageView.getBoundsInLocal());
		
		
		// Get their X-location
		double playerX = playerBounds.getMinX();
		double stageViewX = stageViewBounds.getMinX();
		double endArea = -(stageWidth - Settings.WINDOW_WIDTH); 
		
		// We only want the side-scrolling effect, when the player is moving side ways
		// We need to know when user is pressing right or left key, therefore we need 
		// the controller class to find out what key was pressed.
		Controller controller = Controller.getInstance();
		
		// When pressing right-key AND 
		// player's x location is greater than RIGHT_OFFSET AND
		// the player its not at the end of the stageView THEN
		// Move everything to the left
		if(controller.isMoveRightKeyPressed() && playerX > RIGHT_OFFSET && stageViewX > endArea) {
			moveEverythingToTheLeft();
		}
		
		// When pressing left-key AND 
		// player's x location is less than LEFT_OFFSET AND
		// the player its not at the beginning of the stageView THEN
		// Move everything to the right.
		else if(controller.isMoveLeftKeyPressed() && playerX < LEFT_OFFSET && stageViewX < 0) {
			moveEverythingToTheRight();
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
	
	
}
