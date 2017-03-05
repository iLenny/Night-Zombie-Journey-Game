package njzgame;

import java.text.DecimalFormat;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import njzgame.interfaces.Updatable;

/*
 * CODED BY: Leibniz H. Berihuete
 * PURPOSE: Most games have a gameloop, therefore: this class contains a gameloop,
 *          and gameloop-controls. Any main-class that will be used to represent
 *          a game should extend to this class.
 */
public abstract class Game extends Application implements Updatable {
	private static final DecimalFormat FPS_FORMAT = new DecimalFormat("#0.00");
	private AnimationTimer gameloop;
	private Label fpsIndicator;
	private double fps;
	private int delayCount = 0;
	private Parent root;
	private boolean paused = false;
	
	// CONSTRUCTOR
	public Game() {
		createFPSIndicator();
		createGameloop();
	}	
	
	/*
	 * createFPSIndicator()
	 * It initializes the fpsIndicator, along with it's styles
	 */ 
	private void createFPSIndicator() {
		fpsIndicator = new Label();
		fpsIndicator.setVisible(false);
		fpsIndicator.setFont(Font.font(30));
		fpsIndicator.setTextFill(Color.WHITE);
		fpsIndicator.setEffect(new DropShadow(3, 0, 0, Color.BLACK));		
	}
	
	public Parent getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
		root.getChildren().add(fpsIndicator);
	}

	/*
	 *  createGameloop()
	 *  initializes the gameloop along with it's functionality
	 */
	private void createGameloop() {
		gameloop = new AnimationTimer() {
			// In order to keep track of the previous system time.
			long previousNanoTime = 0;
			
			@Override
			public void handle(long currentNanoTime) {
				// Updates the Updatable objects
				update();
				
				// Get frames per second
				fps = 1_000_000_000.0 / (currentNanoTime - previousNanoTime);
				
				// Update fps Indicator
				updateFPSIndicator(3);
				
				// Keep track of the previous system time
				previousNanoTime = currentNanoTime;
			}
		};
	}
	
	private void updateFPSIndicator(int delay) {
		if (delayCount == delay) {
			delayCount = 0;
			fpsIndicator.setText("FPS: " + getFormatedFPS());
		}
		else {
			delayCount++;
		}
	}
	
	//====== GAMELOOP CONTRONS ======//
	public boolean isPaused() {
		return paused;
	}
	
	/* *********************
	 *   Gameloop Controls:
	 * *********************/
	public void startGameloop() {
		gameloop.start();
		paused = false;
	}
	
	public void stopGameloop() {
		gameloop.stop();
		paused = true;
	}
	
	//======== GETTERS ========//
	public String getFormatedFPS() {
		return FPS_FORMAT.format(fps);
	}
	
	public String getFPS() {
		return Double.toString(fps);
	}
	
	//======== OTHER ========= //
	public void showFPSIndicator(boolean show) {
		fpsIndicator.setVisible(show);
		
		// DEBUGGING:
		if (root == null) {
			System.out.println("FROM Game: (Parent) root: has not been set for the fpsIndicator" +
							   "\n\tSOLUTION: use the setRoot() method, to set the root"); 
		}
		
	}
}
