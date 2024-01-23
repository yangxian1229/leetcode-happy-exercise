package dragon.game.entity;

import dragon.game.service.EquipmentService;
import lombok.Data;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
@Data
public class Player implements Movable {
    private PlayerId id;
    private String name;
    private PlayerClass playerClass;
    private WeaponId weaponId;
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;


    /**
     * 装备武器
     * @param weapon
     * @param equipmentService
     */
    public void equip(Weapon weapon, EquipmentService equipmentService) {
        if (equipmentService.canEquip(this, weapon)) {
            this.weaponId = weapon.getId();
        } else {
            throw new RuntimeException("Can not equip weapon");
        }
    }

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
