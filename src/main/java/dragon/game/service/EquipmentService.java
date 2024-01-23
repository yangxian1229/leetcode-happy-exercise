package dragon.game.service;

import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.entity.WeaponType;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public interface EquipmentService {
    boolean canEquip(Player player, Weapon weapon);
}
