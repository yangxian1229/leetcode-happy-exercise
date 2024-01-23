package dragon.game.policy.damage.impl;

import dragon.game.entity.Monster;
import dragon.game.entity.MonsterClass;
import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.policy.damage.DamagePolicy;

/**
 * 	兽人对物理攻击伤害减半
 * @author yangxian007
 * @date 2024/1/22
 */
public class OrcResistancePolicy implements DamagePolicy {
    @Override
    public boolean canApplay(Player player, Weapon weapon, Monster monster) {
        return monster.getMonsterClass() == MonsterClass.ORC && weapon.getDamageType() == 0;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() / 2;
    }
}
