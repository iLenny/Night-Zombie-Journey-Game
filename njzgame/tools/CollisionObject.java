package njzgame.tools;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import njzgame.interfaces.Direction;
import njzgame.interfaces.Updatable;

public class CollisionObject extends Rectangle implements Updatable, Direction {
	private int direction;
	private Node objectToPush;
	
	public CollisionObject(double width, double height, Node objectToPush,  int direction) {
		super(width, height);
		this.objectToPush = objectToPush;
		this.direction = direction;
	}
	

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public void update() {
		Bounds coBounds = this.sceneToLocal(this.getBoundsInLocal());
		Bounds objectBounds = objectToPush.sceneToLocal(objectToPush.getBoundsInLocal());
		
		if(coBounds.intersects(objectBounds)) {
			switch(direction) {
			case Direction.UP: 
				
				break;
			case Direction.LEFT: 
				break;
			case Direction.RIGHT:
				break;
			case Direction.DOWN:
				break;
			}
		}
		
	}

	public Node getObjectToPush() {
		return objectToPush;
	}

	public void setObjectToPush(Node objectToPush) {
		this.objectToPush = objectToPush;
	}
}
