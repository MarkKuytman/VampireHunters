package scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.buttons.GameButton;
import com.github.hanyaeger.api.scenes.StaticScene;

import launcher.VampireHunters;

public class MenuScene extends StaticScene {
	
	private VampireHunters vampireHunters;


    public MenuScene(VampireHunters vampireHunters) {
    	this.vampireHunters = vampireHunters;
	}

	@Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.gif");
    }

	@Override
	public void setupEntities() {
		
		  GameButton gameStartButton = new GameButton(new Coordinate2D(getWidth() / 2, getHeight() / 2)," Start Game ",vampireHunters, 2);
		  gameStartButton.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
		  addEntity(gameStartButton);
		
// ------------------- WORD NOG NIKS MEE GEDAAN --------------------
//		 // Player Name Label
//        TextEntity playerNameLabel = new TextEntity(new Coordinate2D(getWidth() / 3, getHeight() / 3), "Player Name:");
//        playerNameLabel.setFill(Color.WHITE);
//        playerNameLabel.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(playerNameLabel);
//
//        // TextBlock for Player Name Input
//        TextEntity playerNameInput = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Your Name");
//        playerNameInput.setFill(Color.WHITE);
//        playerNameInput.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(playerNameInput);
// =================================================================================
		

		
	}

}
