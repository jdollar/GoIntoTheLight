package io.github.jdollar.kits;

import io.github.jdollar.utils.ReflectionUtils;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by jdollar on 3/25/2015.
 */
public enum ParticleEffects {

    CRIT("CRIT"),
    CLOUD("CLOUD");

    private String particleName;

    ParticleEffects(String particleName) {
        this.particleName = particleName;
    }

    public void sendToPlayer(Player player) {
        try {
            Location playerLocation = player.getLocation();
            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles();

            ReflectionUtils.setValue(packet, "a", (EnumParticle) EnumParticle.valueOf(particleName));
            ReflectionUtils.setValue(packet, "b", (float) playerLocation.getX());
            ReflectionUtils.setValue(packet, "c", (float) playerLocation.getY() + 15);
            ReflectionUtils.setValue(packet, "d", (float) playerLocation.getZ());
            ReflectionUtils.setValue(packet, "e", 0);
            ReflectionUtils.setValue(packet, "f", 0);
            ReflectionUtils.setValue(packet, "g", 0);
            ReflectionUtils.setValue(packet, "h", 1);
            ReflectionUtils.setValue(packet, "i", 1000);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
