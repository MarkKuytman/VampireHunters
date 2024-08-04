package spawners;

import com.github.hanyaeger.api.entities.EntitySpawner;
import entities.weapons.ranged.Projectile;
import entities.player.Player;
import scenes.LevelScene;

public class ProjectileSpawner extends EntitySpawner {

    private boolean doSpawning = false;

    private Player player;
    private LevelScene scene;

    /**
     * Create a new instance of {@link EntitySpawner} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milliseconds.
     */
    public ProjectileSpawner(long intervalInMs, Player player, LevelScene scene) {
        super(intervalInMs);
        this.player = player;
        this.scene = scene;
    }

    @Override
    protected void spawnEntities() {
        if (doSpawning){
            Projectile projectile = new Projectile(player.getCurrentLocation(), player);
            scene.addProjectile(projectile);
            spawn(projectile);
            doSpawning = !doSpawning;
        }
    }

    public void spawnProjectile(){
        doSpawning = true;
    }
}
