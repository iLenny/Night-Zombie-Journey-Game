package njzgame;


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import njzgame.interfaces.Behavior;
import njzgame.interfaces.Landable;
import njzgame.interfaces.Updatable;
import njzgame.tools.SpriteHandler;

/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: To represent a character of the game
 *  INPUT: name, level, hp, attackPower, speed
 */
public class Character extends Pane implements Updatable, Landable {
	// IDENTITY:
	private String name;
	private int level;
	
	// STATS	
	private int hp;
	private int attackPower;
	private int speed;
	private int jumpPower;
	
	//ImageView
	private ImageView characterView;
	
	// bodyParts -- these will be used for collision purposes
	protected Rectangle head; 
	protected Rectangle body;
	protected Rectangle feet;
	
	//Scale
	protected int rightScale = 1;
	protected int leftScale = -1;
	
	// Behavior
	private Behavior characterBehavior;
	
	// Sprites
	private SpriteHandler attackSprites;
	private SpriteHandler walkSprites;
	private SpriteHandler jumpSprites;
	private SpriteHandler standingSprites;
	
	// Gravity
	private double exertedGravity = 0; // ExertedGravity on Player;
	
	// flag
	private boolean allowToJump = false;
	private boolean allowToAttack = true;
	private boolean falling = true;

	//===== CONSTRUCTOR =====//
	public Character(String name, int level) {
		this.name = name;
		this.level = level;
		
		hp = 100;
		attackPower = 10;
		speed = 5;
		jumpPower = 15;
		characterView = new ImageView();
		
		head = new Rectangle(10, 10);
		body = new Rectangle(10, 10);
		feet = new Rectangle(10, 10);
		
		head.setFill(Color.AQUA);
		body.setFill(Color.BLUEVIOLET);
		feet.setFill(Color.CRIMSON);
		
		
		this.getChildren().addAll(characterView, head, body, feet);
	}
	
	

	@Override
	public void update() {
		if(characterBehavior != null) {
			characterBehavior.performBehavior();
		}
		else {
			System.out.println("From Character: " + name + " doesn't have a character Behavior");
		}
		
	}	
	
	// ========= GETTERS =========//

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getHp() {
		return hp;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public int getSpeed() {
		return speed;
	}
	
	public Behavior getCharacterBehavior() {
		return characterBehavior;
	}
	
	public ImageView getCharacterView() {
		return characterView;
	}
	
	public SpriteHandler getAttackSprites() {
		return attackSprites;
	}

	public SpriteHandler getWalkSprites() {
		return walkSprites;
	}

	public SpriteHandler getJumpSprites() {
		return jumpSprites;
	}

	public SpriteHandler getStandingSprites() {
		return standingSprites;
	}
	

	public int getJumpPower() {
		return jumpPower;
	}

	
	@Override
	public double getExertedGravity() {
		return exertedGravity;
	}
	


	
	// ========= SETTERS =========//
	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setCharacterBehavior(Behavior characterBehavior) {
		this.characterBehavior = characterBehavior;
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



	public void setCharacterView(ImageView characterView) {
		this.characterView = characterView;
	}

	public void setAttackSprites(SpriteHandler attackSprites) {
		this.attackSprites = attackSprites;
	}

	public Rectangle getHead() {
		return head;
	}



	public Rectangle getBody() {
		return body;
	}



	public Rectangle getFeet() {
		return feet;
	}



	public void setHead(Rectangle head) {
		this.head = head;
	}



	public void setBody(Rectangle body) {
		this.body = body;
	}



	public void setFeet(Rectangle feet) {
		this.feet = feet;
	}



	public boolean isFalling() {
		return falling;
	}



	public void setFalling(boolean falling) {
		this.falling = falling;
	}



	public void setWalkSprites(SpriteHandler walkSprites) {
		this.walkSprites = walkSprites;
	}

	public void setJumpSprites(SpriteHandler jumpSprites) {
		this.jumpSprites = jumpSprites;
	}

	public void setStandingSprites(SpriteHandler standingSprites) {
		characterView.setViewport(standingSprites.getSpriteBlock());
		this.standingSprites = standingSprites;
		
		// Since gettings standingSprites for first time..
		head.setTranslateX(characterView.getViewport().getMaxX()/2);
		body.setTranslateX(characterView.getViewport().getMaxX()/2);
		body.setTranslateY(characterView.getViewport().getMaxY()/2);
		feet.setTranslateX(characterView.getViewport().getMaxX()/2);
		feet.setTranslateY(characterView.getViewport().getMaxY());
	}
	
	public void setJumpPower(int jumpPower) {
		this.jumpPower = jumpPower;
	}
	
	@Override
	public void setExertedGravity(double exertedGravity) {
		this.exertedGravity = exertedGravity;
	}
	
	public boolean isAllowToJump() {
		return allowToJump;
	}



	public void setAllowToJump(boolean allowToJump) {
		this.allowToJump = allowToJump;
	}



	public void showBodyParts(boolean flag) {
		head.setVisible(flag);
		body.setVisible(flag);
		feet.setVisible(flag);
	}



	public boolean isAllowToAttack() {
		return allowToAttack;
	}



	public void setAllowToAttack(boolean allowToAttack) {
		this.allowToAttack = allowToAttack;
	}







	
}
