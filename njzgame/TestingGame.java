package njzgame;

import java.text.DecimalFormat;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import njzgame.behaviors.PlayerBehavior;
import njzgame.behaviors.SideScrollingBehavior;
import njzgame.characters.Pepe;
import njzgame.interfaces.Updatable;
import njzgame.settings.Controller;
import njzgame.settings.Settings;
import njzgame.tools.CollisionObject;
import njzgame.tools.Debug;
import njzgame.tools.MenuButton;


// JUST TESTING...NOT MEANT TO BE MAIN
// THE CODE IS MESSY, IT IS USED JUST TO TEST NEW FEATURES AS SOON AS POSSIBLE
public class TestingGame extends Game {
	private static final DecimalFormat FORMAT  = new DecimalFormat("#0.00");
	private static final Image BG_TEST_IMG = new Image(TestingGame.class.getResourceAsStream("images/backgroundtt.jpg"));
	private static final Image MAP_TEST_IMG = new Image(TestingGame.class.getResourceAsStream("images/mapSample.png"));
	private Character lenny;
	private CollisionObject [] chs = new CollisionObject[10];
	private CollisionObject [] cD = new CollisionObject[10];
	private CollisionObject [] stairs = new CollisionObject[3];
	private CollisionObject [] sD = new CollisionObject[3];
	private CollisionObject floor, leftwall, rightwall, boxR, boxL, boxU;
	private Label label;
	private boolean yPressed = false;
	private Label gravityIndicator;
	
	private Map map;
	
	private MenuButton button;
	
	@Override
	public void update() {
		lenny.update();
		map.update();
		for(int i = 0; i < chs.length; i++) {
			chs[i].pushUP(lenny.getFeet(), lenny, lenny.getExertedGravity());
			cD[i].pushDown(lenny.head, lenny, lenny.getJumpPower());
		}
		
		for(int i = 0; i < stairs.length; i++) {
			stairs[i].pushUP(lenny.getFeet(), lenny, lenny.getExertedGravity());
			sD[i].pushDown(lenny.head, lenny, lenny.getJumpPower());
		}
		
		Debug.printMessage(lenny.getClass(), "Lenny Gravity", lenny.getExertedGravity() + "");
		
		floor.pushUP(lenny.getFeet(), lenny, lenny.getExertedGravity());
		leftwall.pushRIGHT(lenny.body, lenny, lenny.getSpeed());
		rightwall.pushLEFT(lenny.body, lenny, lenny.getSpeed());
		
		boxU.pushUP(lenny.getFeet(), lenny, lenny.getExertedGravity());
		boxR.pushRIGHT(lenny.body, lenny, lenny.getSpeed());
		boxL.pushLEFT(lenny.body, lenny, lenny.getSpeed());
		double gravity = lenny.getExertedGravity(); 
		gravityIndicator.setText("Gravity force exerted on player: " + FORMAT.format(gravity));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		
		lenny = new Pepe("lenny", 1);
		PlayerBehavior playerBehavior = new PlayerBehavior(lenny);
		lenny.setCharacterBehavior(playerBehavior);
		lenny.setTranslateY(Settings.WINDOW_HEIGHT*0.38);
		lenny.setTranslateX(100);
		lenny.showBodyParts(false);
		
		gravityIndicator = new Label("Gravity force exerted on player: " + lenny.getExertedGravity());
		Controller.getInstance().connectControlsWith(lenny);
			
		map = new Map(lenny, new ImageView(BG_TEST_IMG), new ImageView(MAP_TEST_IMG));
		SideScrollingBehavior ssBehavior = new SideScrollingBehavior(map);
		map.setMapBehavior(ssBehavior);
		
		
		Pane root = new Pane(map);
		root.setStyle("-fx-background-color: WHITE");
		
		for(int i = 0; i < chs.length; i++) {
			chs[i] = new CollisionObject(100,2);
			cD[i] = new CollisionObject(100,2);
			int red = new Random().nextInt(100);
			int green = new Random().nextInt(100);
			int blue = new Random().nextInt(100);
			
			chs[i].setFill(Color.rgb(red, green, blue));
			cD[i].setFill(Color.rgb(red, green, blue));
			map.addObject(chs[i], 450 + i * 250, 300);
			map.addObject(cD[i], 450 + i * 250, 308);
			map.addObject(new Rectangle(100,10), 450 + i * 250, 300);
		}
		
		for(int i = 0; i < stairs.length; i++) {
			stairs[i] = new CollisionObject(100,2);
			sD[i] = new CollisionObject(100,2);
			int red = new Random().nextInt(100);
			int green = new Random().nextInt(100);
			int blue = new Random().nextInt(100);
			
			stairs[i].setFill(Color.rgb(red, green, blue));
			sD[i].setFill(Color.rgb(red, green, blue));
			
			map.addObject(stairs[i], 350 - 100 * i , 50 * i + 350);
			map.addObject(sD[i], 350 - 100 * i , 50 * i + 358);
			map.addObject(new Rectangle(100,10), 350 - 100 * i , 50 * i + 350);
		}
		floor = new CollisionObject(map.getStageViewWidth(), 50);
		floor.setVisible(false);
		leftwall = new CollisionObject(20, 1000);
		rightwall = new CollisionObject(20, 1000);
		Rectangle box = new Rectangle(100, 100);
		boxR = new CollisionObject(2, 100);
		boxL = new CollisionObject(2, 100);
		boxU = new CollisionObject(100, 2);
		
		map.addObject(floor, 0, 550);
		map.addObject(leftwall, -15, 0);
		map.addObject(rightwall, map.getStageViewWidth(), 0);
		map.addObject(boxR, 448, 450);
		map.addObject(boxL, 352, 450);
		map.addObject(boxU, 350, 450);
		Scene scene = new Scene(root, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
		super.startGameloop();
		super.setRoot(root);
		super.showFPSIndicator(true);
		
		label = new Label("Press Y to enable/disable player's parts view");
		label.setFont(Font.font(20));
		label.relocate(150, 25);
		
		gravityIndicator.relocate(10, 150);
		gravityIndicator.setFont(Font.font(15));
		root.getChildren().addAll(label, gravityIndicator);
		
		
		root.setOnKeyPressed(e-> {
			if(e.getCode().equals(KeyCode.Y)) {
				if(yPressed) {
					yPressed = false;
					lenny.setStyle("-fx-border-style: none");
					lenny.showBodyParts(false);
				}
				else {
					yPressed = true;
					lenny.setStyle("-fx-border-style: solid");
					lenny.showBodyParts(true);
				}
				
			}
		});
	}
	
	
	private void update(Updatable...objects) {
		for(int i = 0; i < objects.length; i++) {
			objects[i].update(); 
		}
	}
	
	
	public static void main(String [] args) {
		launch(args);
	}

}
