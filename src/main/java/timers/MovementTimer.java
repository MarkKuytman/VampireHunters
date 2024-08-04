package timers;

import com.github.hanyaeger.api.Timer;
import entities.enemies.Enemy;
import entities.weapons.ranged.Projectile;
import scenes.LevelScene;

import java.util.ArrayList;

public class MovementTimer extends Timer {
    /**
     * Create a new instance of {@link Timer} for the given interval in milliseconds.
     *
     * @param intervalInMs the interval in milliseconds
     */
    LevelScene scene;

    public MovementTimer(long intervalInMs, LevelScene scene) {
        super(intervalInMs);
        this.scene = scene;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        ArrayList<Enemy> enemies = scene.getEnemies();
        ArrayList<Projectile> projectiles = scene.getProjectiles();

        for (Enemy enemy : enemies) {
            enemy.moveTowardsPlayer();
        }

        for (Projectile projectile: projectiles) {
            projectile.fly();
        }
    }
}
