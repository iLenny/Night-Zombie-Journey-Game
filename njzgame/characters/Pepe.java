package njzgame.characters;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import njzgame.Character;
import njzgame.TestingGame;
import njzgame.tools.Location;
import njzgame.tools.SpriteHandler;

// JUST TESTING
public class Pepe extends Character {
	private static final Image PEPE_SPRITES_IMG = new Image(TestingGame.class.getResourceAsStream("images/pepe.png"));
	
	private static final Rectangle2D [] STAND_SPRITES = {
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(116, 0, 58, 70), // 3
			new Rectangle2D(174, 0, 58, 70), // 4
			new Rectangle2D(238, 0, 58, 70), // 5
			new Rectangle2D(174, 0, 58, 70), // 4
			new Rectangle2D(238, 0, 58, 70), // 5
			new Rectangle2D(174, 0, 58, 70), // 4
	};
	
	private static final Rectangle2D [] WALK_SPRITES = {
			new Rectangle2D(0, 105, 58, 70),    // 1
			new Rectangle2D(65, 105, 58, 70),
			new Rectangle2D(128, 105, 58, 70),
			new Rectangle2D(191, 105, 58, 70),   
			
	};
	
	private static final Rectangle2D [] JUMP_SPRITES = {
			new Rectangle2D(6, 178, 58, 70),    // 1	
	};
	
	private Location leftHeadLocation;
	private Location leftBodyLocation;
	private Location leftFeetLocation;
	private Location rightHeadLocation;
	private Location rightBodyLocation;
	private Location rightFeetLocation;
	
	private static final Rectangle2D [] ATTACK_SPRITES = {
			new Rectangle2D(-13,254,103,70),
			new Rectangle2D(99,245,59,79),
			new Rectangle2D(154,248,90,81),
			new Rectangle2D(250,248,90,81),
			new Rectangle2D(343,248,90,81),
			new Rectangle2D(433,248,90,81),
			
	};
	
	
	
	public Pepe(String name, int level) {
		super(name, level);
		this.getCharacterView().setImage(PEPE_SPRITES_IMG);
		SpriteHandler standSprites = new SpriteHandler(30, STAND_SPRITES);
		SpriteHandler walkSprites = new SpriteHandler(10, WALK_SPRITES);
		SpriteHandler jumpSprites = new SpriteHandler(0, JUMP_SPRITES);
		SpriteHandler attackSprites = new SpriteHandler(5, ATTACK_SPRITES);
		this.setStandingSprites(standSprites);
		this.setWalkSprites(walkSprites);
		this.setJumpSprites(jumpSprites);
		this.setAttackSprites(attackSprites);
		
		rightScale = -1;
		leftScale = 1;
		
		head.setWidth(20);
		head.setHeight(15);
		body.setHeight(30);
		feet.setHeight(5);
		feet.setWidth(15);
		
//		feet.setTranslateY(feet.getTranslateY()-5);
//		head.setTranslateY(head.getTranslateY()+7);
//		head.setTranslateX(head.getTranslateX()-5);
		
		leftHeadLocation = new Location(head.getTranslateX()-5, head.getTranslateY()+7);
		leftBodyLocation = new Location(body.getTranslateX(), body.getTranslateY());
		leftFeetLocation = new Location(feet.getTranslateX(),feet.getTranslateY()-5);
		
		rightHeadLocation = new Location(head.getTranslateX()-15, head.getTranslateY()+7);
		rightBodyLocation = new Location(body.getTranslateX()-10, body.getTranslateY());
		rightFeetLocation = new Location(feet.getTranslateX()-10,feet.getTranslateY()-5);
		
		
		this.setJumpPower(this.getJumpPower() + 1);
	}
	
	@Override
	public void update() {
		super.update();
		
	}
	
	@Override public void setLeftScale(int leftScale) {
		super.setLeftScale(leftScale);
//		head.setTranslateX(leftHeadLocation.getX());
//		head.setTranslateY(leftHeadLocation.getY());
//		body.setTranslateX(leftBodyLocation.getX());
//		body.setTranslateY(leftBodyLocation.getY());
//		feet.setTranslateX(leftFeetLocation.getX());
//		feet.setTranslateY(leftFeetLocation.getY());
		
		
		setBodyPartsLocations(leftHeadLocation, leftBodyLocation, leftFeetLocation);
	}
	
	@Override public void setRightScale(int rightScale) {
		super.setRightScale(rightScale);	
	}
	
	@Override public int getLeftScale() {
		setBodyPartsLocations(leftHeadLocation, leftBodyLocation, leftFeetLocation);
		return super.getLeftScale();
	}
	
	@Override public int getRightScale() {
		setBodyPartsLocations(rightHeadLocation, rightBodyLocation, rightFeetLocation);
		return super.getRightScale();
	}
	
	private void setBodyPartsLocations(Location headLocation, Location bodyLocation, Location feetLocation) {
//		head.relocate(headLocation.getX(), headLocation.getY());
//		body.relocate(bodyLocation.getX(), bodyLocation.getY());
//		feet.relocate(feetLocation.getX(), feetLocation.getY());
		
		head.setTranslateX(headLocation.getX());
		head.setTranslateY(headLocation.getY());
		body.setTranslateX(bodyLocation.getX());
		body.setTranslateY(bodyLocation.getY());
		feet.setTranslateX(feetLocation.getX());
		feet.setTranslateY(feetLocation.getY());
		
//		head.setLayoutX(headLocation.getX());
//		head.setLayoutY(headLocation.getY());
//		body.setLayoutX(bodyLocation.getX());
//		body.setLayoutY(bodyLocation.getY());
//		feet.setLayoutX(feetLocation.getX());
//		feet.setLayoutY(feetLocation.getY());

//		head.setX(headLocation.getX());
//		head.setY(headLocation.getY());
//		body.setX(bodyLocation.getX());
//		body.setY(bodyLocation.getY());
//		feet.setX(feetLocation.getX());
//		feet.setY(feetLocation.getY());
		
	}
}
