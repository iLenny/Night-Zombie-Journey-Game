package njzgame;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import njzgame.behaviors.PlayerBehavior;
import njzgame.behaviors.SideScrollingBehavior;
import njzgame.characters.Pepe;
import njzgame.interfaces.Updatable;
import njzgame.settings.Controller;
import njzgame.settings.Settings;
import njzgame.tools.CollisionObject;
import njzgame.tools.Debug;

public class TestingGame extends Game {
	private static final Image STAGE_TEST_IMG = new Image(TestingGame.class.getResourceAsStream("images/backgroundtt.jpg"));
	private Character lenny;
	private CollisionObject [] chs = new CollisionObject[10];
	private Map map;
	
	@Override
	public void update() {
		lenny.update();
		map.update();
		for(int i = 0; i < chs.length; i++) {
			chs[i].pushUP(lenny.getFeet(), lenny, lenny.getExertedGravity());
		}
		
		Debug.printMessage(lenny.getClass(), "Lenny Gravity", lenny.getExertedGravity() + "");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		lenny = new Pepe("lenny", 1);
		PlayerBehavior playerBehavior = new PlayerBehavior(lenny);
		playerBehavior.setLeftScale(1);
		playerBehavior.setRightScale(-1);
		lenny.setCharacterBehavior(playerBehavior);
		lenny.setTranslateY(Settings.WINDOW_HEIGHT*0.38);
		lenny.setTranslateX(100);
		//lenny.setStyle("-fx-border-style: solid");
		lenny.showBodyParts(false);
		
		Controller.getInstance().connectControlsWith(lenny);
		ImageView stageView = new ImageView(STAGE_TEST_IMG);
		
		map = new Map(lenny, new ImageView(), new ImageView(STAGE_TEST_IMG));
		SideScrollingBehavior ssBehavior = new SideScrollingBehavior(map);
		map.setMapBehavior(ssBehavior);
		
		
		Pane root = new Pane(map);
		root.setStyle("-fx-background-color: WHITE");
		
		for(int i = 0; i < chs.length; i++) {
			chs[i] = new CollisionObject(100,10);
			int red = new Random().nextInt(100);
			int green = new Random().nextInt(100);
			int blue = new Random().nextInt(100);
			
			chs[i].setFill(Color.rgb(red, green, blue));
			map.addObject(chs[i], 110 + i * 250, 300);
		}
		Scene scene = new Scene(root, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
		super.startGameloop();
		super.setRoot(root);
		super.showFPSIndicator(true);
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
