package njzgame;


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import njzgame.interfaces.Behavior;
import njzgame.interfaces.Updatable;
import njzgame.tools.SpriteHandler;

/*
 *  CODED BY: Leibniz H. Berihuete
 *  PURPOSE: To represent a character of the game
 *  INPUT: name, level, hp, attackPower, speed
 */
public class Character extends Pane implements Updatable {
	// IDENTITY:
	private String name;
	private int level;
	
	// STATS	
	private int hp;
	private int attackPower;
	private int speed;
	
	//ImageView
	private ImageView characterView;
	
	// Behavior
	private Behavior characterBehavior;
	
	private SpriteHandler attackSprites;
	private SpriteHandler walkSprites;
	private SpriteHandler jumpSprites;
	private SpriteHandler standingSprites;
	

	//===== CONSTRUCTOR =====//
	public Character(String name, int level) {
		this.name = name;
		this.level = level;
		
		hp = 100;
		attackPower = 10;
		speed = 5;
		characterView = new ImageView();
		this.getChildren().addAll(characterView);
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

	public void setCharacterView(ImageView characterView) {
		this.characterView = characterView;
	}

	public void setAttackSprites(SpriteHandler attackSprites) {
		this.attackSprites = attackSprites;
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
	}

	
}
