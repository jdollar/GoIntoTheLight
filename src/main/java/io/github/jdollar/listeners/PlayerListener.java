package io.github.jdollar.listeners;

import io.github.jdollar.kits.ParticleEffects;
import io.github.jdollar.tasks.ParticleDisplayTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by jdollar on 3/24/2015.
 */
public class PlayerListener implements Listener {
    private JavaPlugin javaPlugin;
    private ParticleDisplayTask particleDisplayTask;

    public PlayerListener(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent playerDropItemEvent) {
        try {
            particleDisplayTask = new ParticleDisplayTask(javaPlugin,
                                                          10,
                                                          ParticleEffects.CRIT,
                                                          playerDropItemEvent.getPlayer());
            particleDisplayTask.runTaskTimer(javaPlugin, 0L, 20L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
