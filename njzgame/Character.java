package njzgame;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import njzgame.interfaces.Behavior;
import njzgame.interfaces.Updatable;

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
	
	// Behavior
	private Behavior characterBehavior;
	

	//===== CONSTRUCTOR =====//
	public Character(String name, int level) {
		this.name = name;
		this.level = level;
		
		hp = 100;
		attackPower = 10;
		speed = 5;
		this.getChildren().add(new Rectangle(50,50));
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

	
}
