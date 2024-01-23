package dragon.game.policy.damage.impl;

import dragon.game.entity.*;
import dragon.game.policy.damage.DamagePolicy;

/**
 * 玩家是龙骑，且怪物是龙，伤害加倍
 * @author yangxian007
 * @date 2024/1/22
 */
public class DragoonPolicy implements DamagePolicy {
    @Override
    public boolean canApplay(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() ==  PlayerClass.DRAGOON && monster.getMonsterClass() == MonsterClass.DRAGON;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() * 2;
    }
}
