package spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import entities.items.gemstone.Gemstone;
import entities.items.power_ups.HealthUp;
import entities.player.Player;

import java.util.Random;

public class ItemSpawner extends EntitySpawner {

    private Coordinate2D spawnLocation;
    private boolean doSpawning = false;
    private Player player;
    /**
     * Create a new instance of {@link EntitySpawner} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milliseconds.
     */
    public ItemSpawner(long intervalInMs, Player player) {
        super(intervalInMs);
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        if (doSpawning){
            int r = new Random().nextInt(101);

            if (r < 10){
                spawn(new HealthUp(spawnLocation, player));
            } else {
                spawn(new Gemstone(spawnLocation, player));
            }
            doSpawning = !doSpawning;
        }
    }

    public void spawnItem(Coordinate2D enemyLocation){
        this.spawnLocation = enemyLocation;
        doSpawning = true;
    }
}
