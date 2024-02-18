package buontyhunter.model.AI.enemySpawner;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import buontyhunter.common.Point2d;
import buontyhunter.model.World;

public interface EnemySpawner {

    /**
     * this method is used to spawn some or a enemy in the world based on his
     * implementation
     * 
     * @param w the world where the enemy will be spawned
     */
    void spawn(World w);

    /**
     * this method is used to generate a point where the enemy will be spawned
     * 
     * @param conf the configuration of the enemy
     * @param w    the world where the enemy will be spawned
     * @return the point where the enemy will be spawned
     */
    static Optional<Point2d> generatePoint(EnemyConfiguration conf, World w) {
        var maxDistanceFromPlayer = conf.getMaxSpawnDistanceFromPlayer();
        var minDistanceFromPlayer = conf.getMinSpawnDistanceFromPlayer();
        var playerPos = w.getPlayer().getPos();

        var tilesAvailable = w.getTileManager().getTiles().stream()
                .flatMap(List::stream)
                .filter(t -> t.isTraversable())
                .filter(t -> t.getPoint().deltaX(playerPos) < maxDistanceFromPlayer
                        && t.getPoint().deltaX(playerPos) > minDistanceFromPlayer
                        && t.getPoint().deltaY(playerPos) < maxDistanceFromPlayer
                        && t.getPoint().deltaY(playerPos) > minDistanceFromPlayer)
                .collect(Collectors.toList());

        if (tilesAvailable.size() == 0) {
            return Optional.empty();
        }

        var random = new Random();
        var tile = tilesAvailable.get(random.nextInt(tilesAvailable.size()));
        return Optional.of(tile.getPoint());

    }
}
