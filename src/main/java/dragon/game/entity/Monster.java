package dragon.game.entity;

import lombok.Data;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
@Data
public class Monster implements Movable {
    private MonsterId id;
    private MonsterClass monsterClass;
    private Health health;
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

    @Override
    public Transform getPosition() {
        return this.position;
    }

    @Override
    public Vector getVelocity() {
        return this.velocity;
    }

    public void moveTo(long x, long y) {
        this.position = new Transform(x, y);
    }

    @Override
    public void startMove(long velX, long velY) {
        this.velocity = new Vector(velX, velY);
    }

    @Override
    public void stopMove() {
        this.velocity = Vector.ZERO;
    }

    @Override
    public boolean isMoving() {
        return this.velocity.getX() != 0 || this.velocity.getY() != 0;
    }
}
