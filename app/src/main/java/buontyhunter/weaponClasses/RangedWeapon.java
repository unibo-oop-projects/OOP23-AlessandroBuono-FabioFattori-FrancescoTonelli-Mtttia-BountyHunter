package buontyhunter.weaponClasses;


import buontyhunter.common.Direction;
import buontyhunter.common.ImageType;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.common.Point2d;

public class RangedWeapon extends Weapon {

    private Bullet bullet;
    private int ammo;
    // private List<Bullet> bullets = new ArrayList<Bullet>();

    public RangedWeapon(int damage, double attackSpeed, int range, double speed, ImageType sprite, FighterEntity owner, WeaponType weapontype) {
        super(damage, attackSpeed, range, speed, owner, weapontype);
        ammo=50;
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


    public void setAmmo(int ammo){
        this.ammo=ammo;
    }

    public void subtractAmmo(int ammo){
        this.ammo-=ammo;
    }

    public void addAmmo(int ammo){
        this.ammo+=ammo;
    }

    public int howManyAmmo(){
        return ammo;
    }

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void directAttack() {
        if(ammo>0){
            bullet = new Bullet(owner.getDirection());
        }
        

    }

    private class Bullet {

        private double travelDistance;
        private Point2d pos;
        private Direction attackDirection;

        public Bullet( Direction direction) {
            travelDistance = 0;
            this.attackDirection = direction;
            pos = owner.getPos();
            hitbox = new RectBoundingBox(pos, 1, 1);
        }

        public void update() {

            // for (Bullet bullet : bullets) {

            if (travelDistance > range) {
                bullet = null;

            } else
            {

                if(travelDistance==0){
                    ((RangedWeapon)owner.getWeapon()).subtractAmmo(1);
                }

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
