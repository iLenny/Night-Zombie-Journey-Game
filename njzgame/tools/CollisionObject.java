package njzgame.tools;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import njzgame.interfaces.Landable;
import njzgame.Character;

public class CollisionObject extends Rectangle {
	
	public CollisionObject(double width, double height) {
		super(width, height);
	}
	
	public void pushUP(Node objToCollide, Node objToPush,  double pushMagnitude) {
		Bounds coBounds = this.localToScene(this.getBoundsInLocal());
		Bounds objBounds = objToCollide.localToScene(objToCollide.getBoundsInLocal());
		
		if(coBounds.intersects(objBounds)) {
			objToPush.setTranslateY(objToPush.getTranslateY() - pushMagnitude);
			
			if(objToPush instanceof Landable) {
				((Landable)objToPush).setExertedGravity(0);
			}
			
			if(objToPush instanceof Character) {
				((Character)objToPush).setAllowToJump(true);
				
				if(((Character)objToPush).getStandingSprites() != null) {
					((Character)objToPush).getStandingSprites().reset();
				}
				
			}
		}	
		
		
	}
	
	public void pushDown(Node objToCollide, Node objToPush,  double pushMagnitude) {
		Bounds coBounds = this.sceneToLocal(this.getBoundsInLocal());
		Bounds objBounds = objToCollide.sceneToLocal(objToCollide.getBoundsInLocal());
		
		if(coBounds.intersects(objBounds)) {
			objToPush.setTranslateY(objToPush.getTranslateY() + pushMagnitude);
		}		
	}
	
	public void pushLEFT(Node objToCollide, Node objToPush,  double pushMagnitude) {
		Bounds coBounds = this.sceneToLocal(this.getBoundsInLocal());
		Bounds objBounds = objToCollide.sceneToLocal(objToCollide.getBoundsInLocal());
		
		if(coBounds.intersects(objBounds)) {
			objToPush.setTranslateX(objToPush.getTranslateX() - pushMagnitude);
		}		
	}
	
	public void pushRIGHT(Node objToCollide, Node objToPush,  double pushMagnitude) {
		Bounds coBounds = this.sceneToLocal(this.getBoundsInLocal());
		Bounds objBounds = objToCollide.sceneToLocal(objToCollide.getBoundsInLocal());
		
		if(coBounds.intersects(objBounds)) {
			objToPush.setTranslateX(objToPush.getTranslateX() + pushMagnitude);
		}
		
		
	}
	



}
