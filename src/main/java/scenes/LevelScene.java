package scenes;

import java.util.ArrayList;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.buttons.GameButton;
import com.github.hanyaeger.api.scenes.DynamicScene;

import entities.enemies.Enemy;
import entities.ui.gameoverlay.OverLay;
import entities.ui.weaponsdisplay.WeaponsDisplay;
import entities.weapons.ranged.Projectile;
import entities.player.Player;
import entities.ui.text.HealthDisplay;
import entities.ui.text.LevelDisplay;
import entities.ui.text.ScoreDisplay;
import javafx.scene.paint.Color;
import launcher.VampireHunters;
import spawners.EnemySpawner;
import spawners.ItemSpawner;
import spawners.ProjectileSpawner;
import timers.CooldownTimer;
import timers.MovementTimer;
import timers.attack_timers.EnemyAttackTimer;

public class LevelScene extends DynamicScene implements EntitySpawnerContainer, UpdateExposer, TimerContainer {
	private HealthDisplay healthDisplay;
	private LevelDisplay levelDisplay;
	private ScoreDisplay highScoreDisplay;
	private OverLay gameOverOverlay;
//    private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private MovementTimer movementTimer;
	private EnemyAttackTimer attackTimer;
	private ProjectileSpawner projectileSpawner;
	private EnemySpawner spawner;
	private CooldownTimer cooldownTimer;
	private Player player;
	private GameButton gameMenuButton;
	private VampireHunters vampireHunters;
	private GameButton gameRetryButton;

//	GameTimer gameTimer;

	public LevelScene(VampireHunters vampireHunters) {

		this.vampireHunters = vampireHunters;
	}

	@Override
	public void setupTimers() {
		movementTimer = new MovementTimer(100, this);
		attackTimer = new EnemyAttackTimer(1000, this);
		cooldownTimer = new CooldownTimer(500, player);

		addTimer(cooldownTimer);
		addTimer(movementTimer);
		addTimer(attackTimer);
	}

	@Override
	public void setupEntities() {
		// Create and add a Player entity
		player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), this);
		addEntity(player);

		// Create and add a Healthdisplay entity
		healthDisplay = new HealthDisplay(new Coordinate2D(), player);
		addEntity(healthDisplay);

		// Create and add an LevelDisplay entity to display the players current level
		levelDisplay = new LevelDisplay(new Coordinate2D(), player);
		levelDisplay.placeAtMiddle(getWidth());
		addEntity(levelDisplay);

		// Create and add a WeaponsDisplay entity to display the inventory of weapons
		var weaponsDisplay = new WeaponsDisplay(new Coordinate2D(getWidth() - 170, getHeight() - 50));
		addEntity(weaponsDisplay);

		// Create and add game over overlay
		gameOverOverlay = new OverLay(new Coordinate2D(0, 0), new Size(getWidth(), getHeight()));
		gameOverOverlay.setFill(Color.BLACK);
		gameOverOverlay.setOpacity(0.9);
		gameOverOverlay.setVisible(false); // Initially hidden
		addEntity(gameOverOverlay);

		// Create and add a ScoreDisplay entity to display highscore
		highScoreDisplay = new ScoreDisplay(new Coordinate2D(), player);
		highScoreDisplay.setVisible(false);
		highScoreDisplay.placeAtMiddle(getWidth());
		addEntity(highScoreDisplay);

		gameMenuButton = new GameButton(new Coordinate2D(getWidth() - 300, getHeight()), " Back to Menu ",
				vampireHunters, 0);
		gameMenuButton.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
		gameMenuButton.setVisible(false);
		addEntity(gameMenuButton);

		gameRetryButton = new GameButton(new Coordinate2D(getWidth() - 200, getHeight()), " Retry ", vampireHunters, 1);
		gameRetryButton.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
		gameRetryButton.setVisible(false);
		addEntity(gameRetryButton);
	}

	@Override
	public void explicitUpdate(long timestamp) {
		if (!player.isDead()) {
			healthDisplay.setText("Health: " + player.getHealth());
			levelDisplay.setText("PLAYER LEVEL: " + player.getLevel());
		if (player.getHealth() == 0 || player.getHealth() < 0) {
			gameOver();
		}
		}
	}

	public void gameOver() {
		highScoreDisplay.setText("YOUR HIGHSCORE: " + player.getHighScore());
		spawner.remove();
		for (var timer : getTimers()) {
			timer.pause();
		}
		player.playerDeath();

		// Show game over overlay and related UI elements
		gameOverOverlay.setVisible(true);
		highScoreDisplay.setVisible(true);
		gameRetryButton.setVisible(true);
		gameMenuButton.setVisible(true);

	}

	@Override
	public void setupEntitySpawners() {
		var gemSpawner = new ItemSpawner(50, player);
		addEntitySpawner(gemSpawner);

		projectileSpawner = new ProjectileSpawner(100, player, this);
		addEntitySpawner(projectileSpawner);

		spawner = new EnemySpawner(1000, getWidth(), getHeight(), player, gemSpawner);
		addEntitySpawner(spawner);
	}

	public ArrayList<Enemy> getEnemies() {
		return spawner.getEnemies();
	}

	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public ProjectileSpawner getProjectileSpawner() {
		return projectileSpawner;
	}

	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub

	}
}