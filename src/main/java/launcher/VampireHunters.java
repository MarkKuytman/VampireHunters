package launcher;

import com.github.hanyaeger.api.YaegerGame;

import scenes.LevelScene;
import scenes.MenuScene;
import scenes.TitleScene;

public class VampireHunters extends YaegerGame {

	public VampireHunters() {
		}
	
	@Override
	public void setupGame() {
		
	}

	@Override
	public void setupScenes(){
	    addScene(0, new TitleScene(this));
	    addScene(1, new LevelScene(this));
	}


	public static void main(String[]args) {
	    launch(args);
	}

}
