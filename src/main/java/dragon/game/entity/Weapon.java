package dragon.game.entity;

import lombok.Data;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
@Data
public class Weapon {
    private WeaponId id;
    private String name;
    private WeaponType weaponType;
    private int damage;
    // 0 - physical, 1 - fire, 2 - ice
    private int damageType;
}
