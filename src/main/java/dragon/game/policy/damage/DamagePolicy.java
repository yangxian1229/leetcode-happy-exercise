package dragon.game.policy.damage;

import dragon.game.entity.Monster;
import dragon.game.entity.Player;
import dragon.game.entity.Weapon;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public interface DamagePolicy {
    /**
     * 是否能使用该策略
     * @param player
     * @param weapon
     * @param monster
     * @return
     */
    boolean canApplay(Player player, Weapon weapon, Monster monster);

    /**
     * 计算伤害值
     * @param player
     * @param weapon
     * @param monster
     * @return
     */
    int calculateDamage(Player player, Weapon weapon, Monster monster);
}
