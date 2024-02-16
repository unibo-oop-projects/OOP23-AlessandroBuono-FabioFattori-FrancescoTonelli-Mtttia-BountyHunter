package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import buontyhunter.physics.PhysicsComponent;
import buontyhunter.weaponClasses.Weapon;
import buontyhunter.weaponClasses.WeaponFactory;

import java.util.*;
import java.util.stream.Collectors;

public class WizardBossEntity extends FighterEntity {

    private static final int health = 100;
    private static final int maxHealth = 100;
    private static final Vector2d vel = new Vector2d(0.5, 0.5);

    public WizardBossEntity(GameObjectType type, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, World w) {
        super(type, new Point2d(0, 0), vel, box, input, graph, phys, health, maxHealth, null);

        // setPos(generateStartPoint(w));
        setWeapon(generateWeapon());
    }

    private Point2d generateStartPoint(World w) {
        // get a list of tile, getTiles is list<list<tile>> I want list<tile>
        var availablePoints = flattenList(w.getTileManager().getTiles()).stream()
                .filter(tile -> tile.isTraversable())
                .collect(Collectors.toList());
        var random = new Random();
        var startPoint = availablePoints.get(random.nextInt(availablePoints.size()));
        return startPoint.getPoint();
    }

    private Weapon generateWeapon() {
        return WeaponFactory.getInstance().createBossBow(this);
    }

    private List<Tile> flattenList(List<List<Tile>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
