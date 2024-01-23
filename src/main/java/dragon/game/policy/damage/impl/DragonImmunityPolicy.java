package dragon.game.policy.damage.impl;

import dragon.game.entity.*;
import dragon.game.policy.damage.DamagePolicy;

/**
 * 玩家非龙骑，怪物是龙，龙对物理和魔法攻击免疫
 * @author yangxian007
 * @date 2024/1/22
 */
public class DragonImmunityPolicy implements DamagePolicy {
    @Override
    public boolean canApplay(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() != PlayerClass.DRAGOON && monster.getMonsterClass() == MonsterClass.DRAGON;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return 0;
    }
}
