package buontyhunter.weaponClasses;

import buontyhunter.common.Point2d;
import buontyhunter.common.ImageType;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.HidableObject;
import buontyhunter.model.RectBoundingBox;

public abstract class Weapon {
    private int damage;
    private int attackSpeed; // the higher the attack speed, the slower the attack
    private int range;
    private int speed;
    // da implementare
    private RectBoundingBox hitbox;
    private ImageType sprite;
    private FighterEntity owner;

    public Weapon(int damage, int attackSpeed, int range, int speed, ImageType sprite, FighterEntity owner) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.speed = speed;
        this.sprite = sprite;
        this.owner = owner;
        // create a RectBoundingBox calculated from the range of the weapon
        directAttack();
    }

    public void directAttack() {
        Point2d offet;
        switch (owner.getDirection()) {
            case STAND_UP:
                offet = new Point2d(owner.getPos().x, owner.getPos().y - range);
                hitbox = new RectBoundingBox(offet, range, ((RectBoundingBox) owner.getBBox()).getHeight());
                break;
            case STAND_DOWN:
                offet = new Point2d(owner.getPos().x, owner.getPos().y + range);
                hitbox = new RectBoundingBox(owner.getPos(), range, ((RectBoundingBox) owner.getBBox()).getHeight());

                break;
            case STAND_LEFT:
                offet = new Point2d(owner.getPos().x - range, owner.getPos().y);
                hitbox = new RectBoundingBox(offet, ((RectBoundingBox) owner.getBBox()).getWidth(), range);
                break;
            case STAND_RIGHT:
                offet = new Point2d(owner.getPos().x + range, owner.getPos().y);
                hitbox = new RectBoundingBox(owner.getPos(), ((RectBoundingBox) owner.getBBox()).getWidth(), range);
                break;

            default:
                break;
        }
    }

    /* Getters */
    public int getDamage() {
        return damage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getRange() {
        return range;
    }

    public int getSpeed() {
        return speed;
    }

    public RectBoundingBox getHitbox() {
        return hitbox;
    }

    public ImageType getSprite() {
        return sprite;
    }

    /* Setters */

    public void setDamage(int damage) {
        if (damage <= 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        this.damage = damage;
    }

    public void setAttackSpeed(int attackSpeed) {
        if (attackSpeed <= 0) {
            throw new IllegalArgumentException("Attack Speed cannot be negative");
        }
        this.attackSpeed = attackSpeed;
    }

    public void setRange(int range) {
        if (range <= 0) {
            throw new IllegalArgumentException("Range cannot be negative");
        }
        this.range = range;
    }

    public void setSpeed(int speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.speed = speed;
    }

    public void setHitbox(RectBoundingBox hitbox) {
        if (hitbox == null) {
            throw new IllegalArgumentException("Hitbox cannot be null");
        }
        this.hitbox = hitbox;
    }

}
