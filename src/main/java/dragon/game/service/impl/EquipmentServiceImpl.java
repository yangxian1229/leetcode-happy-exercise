package dragon.game.service.impl;

import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.entity.WeaponType;
import dragon.game.policy.EquipmentManager;
import dragon.game.service.EquipmentService;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public class EquipmentServiceImpl implements EquipmentService {
    private EquipmentManager equipmentManager;
    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return equipmentManager.canEquip(player, weapon);
    }
}
