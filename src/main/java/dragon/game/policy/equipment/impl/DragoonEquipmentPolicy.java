package dragon.game.policy.equipment.impl;

import dragon.game.entity.Player;
import dragon.game.entity.PlayerClass;
import dragon.game.entity.Weapon;
import dragon.game.entity.WeaponType;
import dragon.game.policy.equipment.EquipmentPolicy;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public class DragoonEquipmentPolicy implements EquipmentPolicy {
    @Override
    public boolean canApply(Player player, Weapon weapon) {
        return player.getPlayerClass() == PlayerClass.FIGHTER;
    }

    /**
     * 龙骑能转呗剑和匕首
     * @param player
     * @param weapon
     * @return
     */
    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return weapon.getWeaponType() == WeaponType.SWORD || weapon.getWeaponType() == WeaponType.DAGGER;
    }
}
