package njzgame.characters;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import njzgame.Character;
import njzgame.TestingGame;
import njzgame.tools.SpriteHandler;

public class Pepe extends Character {
	private static final Image PEPE_SPRITES_IMG = new Image(TestingGame.class.getResourceAsStream("images/pepe.png"));
	
	private static final Rectangle2D [] STAND_SPRITES = {
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
			new Rectangle2D(0, 0, 58, 70),    // 1
			new Rectangle2D(58, 0, 58, 70),   // 2
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
	
	public Pepe(String name, int level) {
		super(name, level);
		this.getCharacterView().setImage(PEPE_SPRITES_IMG);
		SpriteHandler standSprites = new SpriteHandler(30, STAND_SPRITES);
		SpriteHandler walkSprites = new SpriteHandler(10, WALK_SPRITES);
		SpriteHandler jumpSprites = new SpriteHandler(0, JUMP_SPRITES);
		this.setStandingSprites(standSprites);
		this.setWalkSprites(walkSprites);
		this.setJumpSprites(jumpSprites);
	}
	
	@Override
	public void update() {
		super.update();
	}

}
