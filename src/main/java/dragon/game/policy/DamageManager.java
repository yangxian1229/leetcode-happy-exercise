package dragon.game.policy;

import dragon.game.entity.Monster;
import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.policy.damage.DamagePolicy;
import dragon.game.policy.damage.impl.DragonImmunityPolicy;
import dragon.game.policy.damage.impl.DragoonPolicy;
import dragon.game.policy.damage.impl.ElfResistancePolicy;
import dragon.game.policy.damage.impl.OrcResistancePolicy;

import java.util.ArrayList;
import java.util.List;

/**
 * 伤害策略优先级管理
 * @author yangxian007
 * @date 2024/1/22
 */
public class DamageManager {
    private static final List<DamagePolicy> POLICIES = new ArrayList<>();
    static {
        POLICIES.add(new DragoonPolicy());
        POLICIES.add(new DragonImmunityPolicy());
        POLICIES.add(new OrcResistancePolicy());
        POLICIES.add(new ElfResistancePolicy());
    }

    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        for (DamagePolicy policy : POLICIES) {
            if (policy.canApplay(player, weapon, monster)) {
                return policy.calculateDamage(player, weapon, monster);
            }
        }
        return 0;
    }
}
