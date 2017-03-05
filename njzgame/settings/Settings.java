package njzgame.settings;

import javafx.scene.input.KeyCode;

public class Settings {
	// WINDOW SIZE:
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;;
	
	// DEFAULT CONTROL KEYS
	public static final KeyCode DEFAULT_MOVE_RIGHT_KEY = KeyCode.RIGHT;
	public static final KeyCode DEFAULT_MOVE_LEFT_KEY = KeyCode.LEFT;
	public static final KeyCode DEFAULT_JUMP_KEY = KeyCode.SPACE;
	public static final KeyCode DEFAULT_ATTACK_KEY = KeyCode.CONTROL;
	
	// GAME SETTINGS
	public static final double GRAVITY_RATE = 0.3;
	public static double gravity = 0;
}
