package dragon.game.policy.equipment;

import dragon.game.entity.Player;
import dragon.game.entity.Weapon;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public interface EquipmentPolicy {
    /**
     * 是否适用于该策略
     * @param player
     * @param weapon
     * @return
     */
    boolean canApply(Player player, Weapon weapon);

    /**
     * 是否能装备
     * @param player
     * @param weapon
     * @return
     */
    boolean canEquip(Player player, Weapon weapon);
}
