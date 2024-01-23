package dragon.game.policy.damage.impl;

import dragon.game.entity.Monster;
import dragon.game.entity.Player;
import dragon.game.entity.Weapon;
import dragon.game.policy.damage.DamagePolicy;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public class DefaultDamagePolicy implements DamagePolicy {
    @Override
    public boolean canApplay(Player player, Weapon weapon, Monster monster) {
        return true;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage();
    }
}
