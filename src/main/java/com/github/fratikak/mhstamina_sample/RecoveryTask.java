package com.github.fratikak.mhstamina_sample;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * プレイヤーのFoodLevelを回復させるTask
 */
public class RecoveryTask extends BukkitRunnable {

    private final Player player;

    //delayが0になったらFoodLevelを回復させる
    private int delay = 5;

    public RecoveryTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {

        //プレイヤーがスプリント状態か、FoodLevelが全快している時はTaskをキャンセル
        if (player.isSprinting() || player.getFoodLevel() == 20) {
            cancel();
            return;
        }

        if (delay <= 0) {
            player.setFoodLevel(player.getFoodLevel() + 1);
            return;
        }
        delay--;
    }
}
