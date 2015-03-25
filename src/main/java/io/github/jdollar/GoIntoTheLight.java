package io.github.jdollar;

/**
 * Created by jdollarhide on 2/19/2015.
 */

import io.github.jdollar.listeners.PlayerListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class GoIntoTheLight extends JavaPlugin {

    private PlayerListener playerListener;

    @Override
    public void onEnable() {
        playerListener = new PlayerListener(this);
        getServer().getPluginManager().registerEvents(playerListener, this);
    }

    @Override
    public void onLoad() {
        playerListener = new PlayerListener(this);
        getServer().getPluginManager().registerEvents(playerListener, this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
