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
    CRIT_MAGIC("CRIT_MAGIC"),
    CLOUD("CLOUD");

    private String particleName;
    private int packetCount = 0;

    ParticleEffects(String particleName) {
        this.particleName = particleName;
    }

    public void sendToPlayer(Player player, int distance) {
        try {
            Location playerLocation = player.getLocation();
            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles();
            ReflectionUtils.setValue(packet, "a", (EnumParticle) EnumParticle.valueOf(particleName));
            ReflectionUtils.setValue(packet, "b", (float) playerLocation.getX() + packetCount);
            ReflectionUtils.setValue(packet, "c", (float) playerLocation.getY());
            ReflectionUtils.setValue(packet, "d", (float) playerLocation.getZ());
            ReflectionUtils.setValue(packet, "e", 0);
            ReflectionUtils.setValue(packet, "f", 0);
            ReflectionUtils.setValue(packet, "g", 0);
            ReflectionUtils.setValue(packet, "h", 1);
            ReflectionUtils.setValue(packet, "i", 10);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
            packetCount = packetCount < distance ? packetCount + 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPacketCount(int packetCount) {
        this.packetCount = packetCount;
    }
}
