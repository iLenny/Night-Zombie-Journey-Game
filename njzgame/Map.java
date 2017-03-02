package njzgame;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import njzgame.interfaces.Behavior;
import njzgame.interfaces.Updatable;

/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: To represent the environment that the player would be interacting with.
 *  Input mapBehavior, backgroundView, stageView;
 */
public class Map extends Pane implements Updatable{
	
	private Behavior mapBehavior;
	private Character player;
	private ImageView backgroundView;
	private ImageView stageView;
	private ArrayList<Node> objectList;
	
	
	/**
	 *  CONSTRUCTOR (Character)
	 *  @param player: it needs to know what player 
	 *  is the map going to interact with.
	 */
	public Map(Character player) {
		this.backgroundView = new ImageView();
		this.stageView = new ImageView();
		this.player = player;
		objectList = new ArrayList<>();
		
		this.getChildren().addAll(backgroundView, stageView, player);
	}
	
	
	
	/**
	 *  CONSTRUCTOR (Character, ImageView, ImageView)
	 *  @param player: it needs to know what player is the map going to interact with.
	 *  @param backgroundView: holds the backgroundView of the map
	 *  @param stageView: holds the stageView of the map
	 */
	public Map(Character player, ImageView backgroundView, ImageView stageView) {
		this.backgroundView = backgroundView;
		this.stageView = stageView;
		this.player = player;
		objectList = new ArrayList<>();
		
		this.getChildren().addAll(backgroundView, stageView, player);
	}



	@Override
	public void update() {
		if(mapBehavior != null) {
			mapBehavior.performBehavior();
		}		
	}
	
	/*  addObject() Method
	 *  This adds an object to the map.
	 *  When adding an object this way, Behavior classes such as SideScrollingBehavior
	 *  can then interact with these objects more accurately. otherwise it might not give
	 *  the proper effect.
	 *  
	 *  @param object: the object that you want to add to the map
	 *  @param xLocation: the x location where you want the object to be at
	 *  @param yLocation: the y location where you want the object to be at
	 */
	public void addObject(Node object, double xLocation, double yLocation) {
		object.relocate(xLocation, yLocation);
		objectList.add(object);
		this.getChildren().add(2, object);	
	}
	
	/*
	 *  removeObject() Method
	 *  This removes the object from both the objectList
	 *  and map container
	 *  
	 *  @param object: the object you want to remove.
	 */
	public void removeObject(Node object) {
		objectList.remove(object);
		this.getChildren().remove(object);
	}
	
	
	// ========== GETTERS ============= //
	
	public Character getPlayer() {
		return player;
	}
	
	public ImageView getBackgroundView() {
		return backgroundView;
	}

	public ImageView getStageView() {
		return stageView;
	}
	
	public Behavior getMapBehavior() {
		return mapBehavior;
	}
	
	public double getStageViewWidth() {
		return stageView.getImage().getWidth();
	}
	
	public double getStageViewHeight() {
		return stageView.getImage().getHeight();
	}
	
	public double getBackgroundViewWidth() {
		return backgroundView.getImage().getWidth();
	}
	
	public double getBackgroundViewHeight() {
		return backgroundView.getImage().getHeight();
	}
	
	public ArrayList<Node> getObjectList() {
		return objectList;
	}
	

	// =========== SETTERS ============== //
	public void setPlayer(Character player) {
		this.player = player;
	}
	
	public void setMapBehavior(Behavior mapBehavior) {
		this.mapBehavior = mapBehavior;
	}

	public void setBackgroundView(ImageView backgroundView) {
		this.backgroundView = backgroundView;
	}

	public void setStageView(ImageView stageView) {
		this.stageView = stageView;
	}
}
