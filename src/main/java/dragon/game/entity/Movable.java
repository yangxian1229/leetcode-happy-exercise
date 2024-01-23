package dragon.game.entity;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public interface Movable {
    // 属性 -- 相当于组件
    Transform getPosition();
    Vector getVelocity();

    // 行为
    void moveTo(long x, long y);
    void startMove(long velX, long velY);

    void stopMove();

    boolean isMoving();

}
