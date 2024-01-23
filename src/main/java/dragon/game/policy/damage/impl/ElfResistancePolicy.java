package dragon.game.policy.damage.impl;

import dragon.game.entity.Monster;
import dragon.game.entity.MonsterClass;
import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.policy.damage.DamagePolicy;

/**
 * 精灵对魔法攻击伤害减半
 * @author yangxian007
 * @date 2024/1/22
 */
public class ElfResistancePolicy implements DamagePolicy {

    @Override
    public boolean canApplay(Player player, Weapon weapon, Monster monster) {
        return monster.getMonsterClass() == MonsterClass.ELF && (weapon.getDamageType() == 1 || weapon.getDamageType() == 2);
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() / 2;
    }
}
