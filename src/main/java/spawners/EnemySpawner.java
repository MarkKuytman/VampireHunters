package spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import entities.enemies.Enemy;
import entities.enemies.big_enemy.BigEnemy;
import entities.enemies.normal_enemy.NormalEnemy;
import entities.player.Player;
import entities.enemies.small_enemy.SmallEnemy;
import javafx.geometry.Point2D;
import scenes.LevelScene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EnemySpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    private final Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ItemSpawner itemSpawner;

    /**
     * Create a new instance of {@link EntitySpawner} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milliseconds.
     */
    public EnemySpawner(long intervalInMs, double sceneWidth, double sceneHeight, Player player, ItemSpawner itemSpawner) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.player = player;
        this.itemSpawner = itemSpawner;
    }

    @Override
    protected void spawnEntities() {
        int r = new Random().nextInt(101);

        Enemy enemy;
        if (r<10){
            //1/10 Spawn the big Enemy
            enemy = new BigEnemy(randomLocation(), player, itemSpawner);
            enemies.add(enemy);
            spawn(enemy);
        } else if (r<30){
            //3/10 Spawn normal Enemy
            enemy = new NormalEnemy(randomLocation(), player, itemSpawner);
            enemies.add(enemy);
            spawn(enemy);
        } else if (r < 50) {
            //5/10 Spawn small enemy, anything above 7 doesn't spawn anything.
            enemy = new SmallEnemy(randomLocation(), player, itemSpawner);
            enemies.add(enemy);
            spawn(enemy);
        }
    }

    private Coordinate2D randomLocation() {
        double xRandom = new Random().nextInt((int) sceneWidth);
        double yRandom = new Random().nextInt((int) sceneHeight);
        int r = new Random().nextInt(3);
        switch (r){
            case 0 -> {
                return new Coordinate2D(sceneWidth, yRandom);
            }
            case 1 -> {
                return new Coordinate2D(xRandom, sceneHeight);
            }
            case 2 -> {
                return new Coordinate2D(0, yRandom);
            }
            default -> {
                return new Coordinate2D(xRandom, 0);
            }
        }

    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

}
