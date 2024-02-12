package buontyhunter.model;

import buontyhunter.common.Point2d;
import buontyhunter.common.Vector2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.graphics.GraphicsComponent;
import buontyhunter.input.InputComponent;
import java.util.*;
import buontyhunter.physics.PhysicsComponent;

public class QuestPannel extends HidableObject{

    private final List<Quest> quests;

    public QuestPannel(GameObjectType type, Point2d pos, Vector2d vel, BoundingBox box, InputComponent input,
            GraphicsComponent graph, PhysicsComponent phys, boolean show) {
        super(type, pos, vel, box, input, graph, phys, show);
        quests = GameFactory.getInstance(GameEngine.resizator).createQuests();
    }
    
    public List<Quest> getQuests() {
        return new ArrayList<Quest>(quests);
    }
}
