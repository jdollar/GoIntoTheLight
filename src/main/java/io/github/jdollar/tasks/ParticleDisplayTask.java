package io.github.jdollar.tasks;

import io.github.jdollar.kits.ParticleEffects;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by jdollar on 3/25/2015.
 */
public class ParticleDisplayTask extends BukkitRunnable {

    private final JavaPlugin goIntoTheLight;
    private int particleCount;
    private int particleLimit;
    private ParticleEffects particleEffects;
    private Player player;

    public ParticleDisplayTask(JavaPlugin goIntoTheLight,
                               int particleLimit,
                               ParticleEffects particleEffects,
                               Player player) {
        this.goIntoTheLight = goIntoTheLight;
        this.particleLimit = particleLimit;
        this.particleCount = 0;
        this.particleEffects = particleEffects;
        this.player = player;
    }

    @Override
    public void run() {
        if (particleCount <= particleLimit) {
            particleEffects.sendToPlayer(player, 10);
            particleCount++;
        } else {
            particleEffects.setPacketCount(0);
            this.cancel();
        }
    }
}
