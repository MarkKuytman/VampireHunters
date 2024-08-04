package scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.buttons.GameButton;
import com.github.hanyaeger.api.scenes.StaticScene;

import launcher.VampireHunters;


public class TitleScene extends StaticScene{
	
	private VampireHunters vampireHunters;


	public TitleScene(VampireHunters vampireHunters) {
		// TODO Auto-generated constructor stub
		this.vampireHunters = vampireHunters;
	}
	
	@Override
	public void setupScene(){
//	    setBackgroundAudio("");
	    setBackgroundImage("backgrounds/background3.gif");
	    
	}


	@Override
	public void setupEntities() {
		// TODO Auto-generated method stub
		  GameButton gameMenuButton = new GameButton(new Coordinate2D(getWidth() / 2, getHeight() / 2)," Play Vampire Hunters ",vampireHunters, 1);
		  gameMenuButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		  addEntity(gameMenuButton);
	}

}
