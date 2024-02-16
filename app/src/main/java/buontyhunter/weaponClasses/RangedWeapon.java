package buontyhunter.weaponClasses;

import java.util.ArrayList;
import java.util.List;

import buontyhunter.common.Direction;
import buontyhunter.common.ImageType;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.common.Point2d;

public class RangedWeapon extends Weapon {

    private ImageType bulletSprite;
    private Bullet bullet;
    // private List<Bullet> bullets = new ArrayList<Bullet>();

    public RangedWeapon(int damage, double attackSpeed, int range, double speed, ImageType sprite, FighterEntity owner,
            ImageType bulletSprite) {
        super(damage, attackSpeed, range, speed, sprite, owner);
    }

    public void getShot() {
        if (!owner.getDamagingArea().isShow()) {
            return;
        }
        if (bullet != null) {
            bullet.update();
        } else {
            owner.getDamagingArea().setShow(false);
        }
    }

    /*
     * public List<Bullet> getBullets() {
     * return bullets;
     * }
     */

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void directAttack() {

        bullet = new Bullet(bulletSprite, owner.getDirection());
        // bullets.add(new Bullet(bulletSprite));

    }

    private class Bullet {

        private double travelDistance;
        private Point2d pos;
        private ImageType sprite;
        private Direction attackDirection;

        public Bullet(ImageType sprite, Direction direction) {
            travelDistance = 0;
            this.attackDirection = direction;
            this.sprite = sprite;
            pos = owner.getPos();
            hitbox = new RectBoundingBox(pos, 30, 30);
        }

        public void update() {

            // for (Bullet bullet : bullets) {

            if (travelDistance > range) {
                bullet = null;

            } else {
                switch (attackDirection) {
                    case STAND_UP: {
                        pos = new Point2d(pos.x, pos.y - speed);
                        hitbox = ((RectBoundingBox) hitbox).withPoint(pos);
                        break;
                    }
                    case STAND_DOWN: {
                        pos = new Point2d(pos.x, pos.y + speed);
                        hitbox = ((RectBoundingBox) hitbox).withPoint(pos);
                        break;
                    }
                    case STAND_LEFT: {
                        pos = new Point2d(pos.x - speed, pos.y);
                        hitbox = ((RectBoundingBox) hitbox).withPoint(pos);
                        break;
                    }
                    case STAND_RIGHT: {
                        pos = new Point2d(pos.x + speed, pos.y);
                        hitbox = ((RectBoundingBox) hitbox).withPoint(pos);
                        break;
                    }
                    default: {
                        break;
                    }
                }

                owner.getDamagingArea().setBBox(hitbox);
            }
            travelDistance += speed;
            // }
        }

    }
}
