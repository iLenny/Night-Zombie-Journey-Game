package njzgame.tools;


import njzgame.interfaces.Behavior;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * 
 * @author Leibniz H. Berihuete
 * MenuButton class, its purpose is to be part of menu such paused menu,
 * or startMenu of the game
 */
public class MenuButton extends StackPane{
	// WHEN THE BUTTON IS HOVERED, IT WILL HAVE THESE VALUES:
	private static final Color HOVERED_BG_COLOR = Color.rgb(0, 0, 0, 0.9);
	private static final Color HOVERED_TEXT_COLOR = Color.rgb(255, 255, 255, 1.0);
	private static final Font HOVERED_TEXT_FONT = Font.font("Georgia", FontWeight.EXTRA_BOLD, 16);
	
	private Label label;
	private Rectangle background;
	private Behavior menuButtonBehavior;
	private Runnable clickedActivity;
	
	// CONSTRUCTOR
	public MenuButton(String nameOfButton, double width, double height) {
		// Initialize:
		label = new Label(nameOfButton);
		background = new Rectangle(width, height);
		
		// Add style
		background.setFill(Color.rgb(0, 0, 0, 0.7));
		background.setArcWidth(30);
		background.setArcHeight(30);
		label.setTextFill(Color.WHITE);
		
		buildFunctionality();
		
		super.getChildren().addAll(background, label);
	}
	
	// BUILDS THE FUNCTIONALITY OF THE BUTTON
	public void buildFunctionality() {
		this.setCursor(Cursor.HAND);
		// GET ORIGINAL VALUES OF THE MENU BUTTON
		Color originalBGColor = (Color)background.getFill();
		Color originalTextColor = (Color)label.getTextFill();
		Font originalTextFont = label.getFont();	
		
		// WHEN THE BUTTON IS CLICKED
		setOnMouseClicked(e-> {
			clickedActivity.run();
		});
		
		// WHEN THE BUTTON IS HOVERED
		setOnMouseEntered(e-> {
			background.setFill(HOVERED_BG_COLOR);
			label.setTextFill(HOVERED_TEXT_COLOR);
			label.setFont(HOVERED_TEXT_FONT);
		});
		
		// WHEN THE BUTTON IS NOT HOVERED
		setOnMouseExited(e-> {
			background.setFill(originalBGColor);
			label.setTextFill(originalTextColor);
			label.setFont(originalTextFont);
		});
	
	}
	
	/* ****************
	 * 	  SETTERS:	
	 * ****************/
	public void setClickedActivity(Runnable clickedActivity) {
		this.clickedActivity = clickedActivity;
	}
	
	public void setBehavior(Behavior menuButtonBehavior) {
		this.menuButtonBehavior = menuButtonBehavior;
	}
	
	
	/* ******************
	 * 	   GETTERS	
	 * ******************/
	public Rectangle getBackgroundRect() {
		return background;
	}
	
	public Label getLabel() {
		return label;
	}
	
	public Behavior getBehavior() {
		return menuButtonBehavior;
	}
	
	
}