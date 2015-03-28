package io.github.jdollar.listeners;

import io.github.jdollar.kits.ParticleEffects;
import io.github.jdollar.tasks.ParticleDisplayTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

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
                                                          30,
                                                          ParticleEffects.CRIT_MAGIC,
                                                          playerDropItemEvent.getPlayer());
            particleDisplayTask.runTaskTimer(javaPlugin, 0L, 1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
