package timers.attack_timers;

import com.github.hanyaeger.api.Timer;
import entities.enemies.Enemy;
import scenes.LevelScene;

import java.util.ArrayList;

public class EnemyAttackTimer extends Timer {

    protected LevelScene scene;
    /**
     * Create a new instance of {@link Timer} for the given interval in milliseconds.
     *
     * @param intervalInMs the interval in milliseconds
     */


    public EnemyAttackTimer(long intervalInMs, LevelScene scene) {
        super(intervalInMs);
        this.scene = scene;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        ArrayList<Enemy> enemies = scene.getEnemies();

        for (Enemy enemy : enemies) {
            if (enemy.isAttacking()) {
                enemy.attackPlayer();
            }
        }
    }
}
