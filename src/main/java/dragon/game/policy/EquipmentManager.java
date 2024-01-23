package dragon.game.policy;

import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.policy.equipment.EquipmentPolicy;
import dragon.game.policy.equipment.impl.DragoonEquipmentPolicy;
import dragon.game.policy.equipment.impl.FighterEquipmentPolicy;
import dragon.game.policy.equipment.impl.MageEquipmentPolicy;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略优先级管理
 * @author yangxian007
 * @date 2024/1/22
 */
public class EquipmentManager {
    private static  final List<EquipmentPolicy> POLICIES = new ArrayList<>();
    static {
        POLICIES.add(new FighterEquipmentPolicy());
        POLICIES.add(new DragoonEquipmentPolicy());
        POLICIES.add(new MageEquipmentPolicy());
    }

    public boolean canEquip(Player player, Weapon weapon) {
        for (EquipmentPolicy policy : POLICIES) {
            if (policy.canApply(player, weapon)) {
                return policy.canEquip(player, weapon);
            }
        }
        return false;
    }
}
