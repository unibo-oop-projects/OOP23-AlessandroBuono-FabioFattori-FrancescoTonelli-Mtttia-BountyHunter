package buontyhunter.weaponClasses;

import buontyhunter.common.ImageType;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.common.Point2d;
import buontyhunter.core.GameFactory;

public class RangedWeapon extends Weapon {

    private ImageType bulletSprite;
    private Bullet bullet;

    public RangedWeapon(int damage, int range, int speed, ImageType sprite, FighterEntity owner , ImageType bulletSprite) {
        super(damage, range, range, speed, sprite, owner);
    }

    public void getShot() {
        if (!owner.getDamagingArea().isShow()) {
            return;
        }
        if (bullet != null) {
            bullet.update();

        }else{
            owner.getDamagingArea().setShow(false);
        }
    }

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void directAttack() {
        // if (owner.getAmmo() > 0) {
        //     owner.setAmmo(owner.getAmmo() - 1);
            bullet = new Bullet(bulletSprite);
        //}
    }

    private class Bullet{

        private double travelDistance;
        private Point2d pos;
        private ImageType sprite;

        public Bullet(ImageType sprite) {
            travelDistance = 0;
            this.sprite = sprite;
            pos = owner.getPos();
            hitbox = new RectBoundingBox(pos, 30 ,30 );
        }

        public Point2d getPos() {
            return pos;
        }
        
        public ImageType getSprite() {
            return sprite;
        }

        public void update() {
            travelDistance += speed;
            if (travelDistance > range) {
                bullet = null;
                owner.getDamagingArea().setShow(false);
            }else{
                pos = new Point2d(pos.x + speed,pos.y + ((RectBoundingBox)owner.getBBox()).getHeight() / 4);
                hitbox = ((RectBoundingBox)hitbox).withPoint(new Point2d(pos.x + speed, pos.y + ((RectBoundingBox)owner.getBBox()).getHeight() / 4));
            }
        }

    }
}
