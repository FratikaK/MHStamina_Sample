package com.github.fratikak.mhstamina_sample;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * プレイヤーのFoodLevelを減少させるTask
 */
public class DecreaseTask extends BukkitRunnable {

    private final Player player;

    public DecreaseTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {

        //プレイヤーがスプリントをしていなければTaskをキャンセル
        if (!player.isSprinting()) {
            cancel();
            return;
        }

        //プレイヤーのFoodLevelを1減らす
        player.setFoodLevel(player.getFoodLevel() - 1);
    }
}
