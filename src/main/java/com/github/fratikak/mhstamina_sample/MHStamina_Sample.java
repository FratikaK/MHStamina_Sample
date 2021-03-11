package com.github.fratikak.mhstamina_sample;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MHStamina_Sample extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //onToggleSplintとonChangeFoodLevelのeventを登録する
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    /**
     * スプリント状態を切り替えたプレイヤーのFoodLevelを
     * 増やしたり減らしたりするTaskを実行する
     *
     * @param event
     */
    @EventHandler
    public void onToggleSplint(PlayerToggleSprintEvent event) {
        //スプリントを切り替えたプレイヤーを取得
        Player player = event.getPlayer();

        if (event.isSprinting()) {
            new DecreaseTask(player).runTaskTimer(this, 0, 10);
        } else {
            new RecoveryTask(player).runTaskTimer(this, 0, 5);
        }
    }

    /**
     * 通常のFoodLevel減少は無効にする
     *
     * @param event
     */
    @EventHandler
    public void onChangeFoodLevel(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
