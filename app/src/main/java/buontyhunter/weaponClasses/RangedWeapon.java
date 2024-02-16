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
    //private List<Bullet> bullets = new ArrayList<Bullet>();
    
    public RangedWeapon(int damage,int attackSpeed, int range, int speed, ImageType sprite, FighterEntity owner , ImageType bulletSprite) {
        super(damage, attackSpeed, range, speed, sprite, owner);
    }

    public void getShot() {
        if (!owner.getDamagingArea().isShow()) {
            return;
        }
        if(bullet!=null){
            bullet.update();
        }
        /*if (bullets.getFirst()!=null) {
            for (Bullet bullet : bullets) {
                bullet.update();
            }*/

        else{
            owner.getDamagingArea().setShow(false);
        }
    }

    /*public List<Bullet> getBullets() {
        return bullets;
    }*/

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void directAttack() {
        
        bullet = new Bullet(bulletSprite);
        //bullets.add(new Bullet(bulletSprite));
        
    }

    private class Bullet{

        private double travelDistance;
        private Point2d pos;
        private Direction dir;
        private ImageType sprite;

        public Bullet(ImageType sprite) {
            travelDistance = 0;
            this.sprite = sprite;
            pos = owner.getPos();
            dir = owner.getDirection();
            hitbox = new RectBoundingBox(pos, 30 ,30 );
        }

        public Point2d getPos() {
            return pos;
        }
        
        public ImageType getSprite() {
            return sprite;
        }
        public Direction getDirection(){
            return dir;
        }

        public void update() {

            //for (Bullet bullet : bullets) {

                if (travelDistance > range) {
                    bullet = null;
                    
                }else{
                    switch (bullet.getDirection()) {
                        case STAND_UP:{
                            pos = new Point2d(pos.x, pos.y - speed);
                            hitbox = ((RectBoundingBox)hitbox).withPoint(new Point2d(pos.x, pos.y - speed));
                            break;
                        }
                        case STAND_DOWN:{
                            pos = new Point2d(pos.x, pos.y + speed);
                            hitbox = ((RectBoundingBox)hitbox).withPoint(new Point2d(pos.x, pos.y + speed));
                            break;
                        }
                        case STAND_LEFT:{
                            pos = new Point2d(pos.x - speed, pos.y);
                            hitbox = ((RectBoundingBox)hitbox).withPoint(new Point2d(pos.x - speed, pos.y));
                            break;
                        }
                        case STAND_RIGHT:{
                            pos = new Point2d(pos.x + speed, pos.y);
                            hitbox = ((RectBoundingBox)hitbox).withPoint(new Point2d(pos.x + speed, pos.y));
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    
                }
                travelDistance += speed;
            //}
        }

    }
}
