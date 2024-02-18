package buontyhunter.model.AI;

import buontyhunter.common.Direction;
import buontyhunter.common.ExponentialProbability;
import buontyhunter.common.PercentageHelper;
import buontyhunter.common.Point2d;
import buontyhunter.common.Probability;

public class AttackHelper {
    private long millisecondCheck = 1000;
    private Probability probability;
    private long millisecondSinceLastAttach = 0;
    private long millisecondSinceLastCheck = 0;

    /**
     * Create a new attack helper
     * 
     * @param attachCoolDown the attack cool down
     */
    public AttackHelper(long attachCoolDown) {
        probability = new ExponentialProbability(Math.pow(attachCoolDown, -1));
    }

    /**
     * Check if the item can attack
     * 
     * @param elapsed the elapsed time
     * @return if the item can attack
     */
    public boolean canAttack(long elapsed) {
        millisecondSinceLastAttach += elapsed;
        millisecondSinceLastCheck += elapsed;
        boolean attack = false;
        if (millisecondSinceLastCheck > millisecondCheck) {
            millisecondSinceLastCheck = 0;
            attack = PercentageHelper.match(probability.p(millisecondSinceLastAttach) * 100);
            if (attack) {
                millisecondSinceLastAttach = 0;
            }
        }

        return attack;
    }

    /**
     * Get the millisecond since last attach
     * 
     * @return the millisecond since last attach
     */
    public long getMillisecondSinceLastAttach() {
        return millisecondSinceLastAttach;
    }

    /**
     * Get the attack direction
     * 
     * @param itemPos   the item position
     * @param targetPos the target position
     * @return the attack direction
     */
    public Direction getAttackDirection(Point2d itemPos, Point2d targetPos) {
        var deltaX = Math.abs(targetPos.x - itemPos.x);
        var deltaY = Math.abs(targetPos.y - itemPos.y);

        Direction direction;
        if (deltaX > deltaY) {
            direction = targetPos.x > itemPos.x ? Direction.STAND_RIGHT : Direction.STAND_LEFT;
        } else {
            direction = targetPos.y > itemPos.y ? Direction.STAND_DOWN : Direction.STAND_UP;
        }

        return direction;
    }
}
