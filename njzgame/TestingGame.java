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

public class TestingGame extends Game {
	private static final Image STAGE_TEST_IMG = new Image(TestingGame.class.getResourceAsStream("images/test-Stage.png"));
	private Character lenny;
	private Rectangle [] chs = new Rectangle[10];
	private Map map;
	
	@Override
	public void update() {
		lenny.update();
		map.update();
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
		lenny.setStyle("-fx-border-style: solid");
		
		Controller.getInstance().connectControlsWith(lenny);
		map = new Map(lenny, new ImageView(), new ImageView(STAGE_TEST_IMG));
		SideScrollingBehavior ssBehavior = new SideScrollingBehavior(map);
		map.setMapBehavior(ssBehavior);
		
		
		Pane root = new Pane(map);
		
		for(int i = 0; i < chs.length; i++) {
			chs[i] = new Rectangle(100,100);
			int red = new Random().nextInt(255);
			int green = new Random().nextInt(255);
			int blue = new Random().nextInt(255);
			
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
