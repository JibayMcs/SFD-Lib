package fr.minecraftforgefrance.sfd.common;

import com.google.common.collect.Maps;
import fr.minecraftforgefrance.sfd.common.entity.SFDProjectileEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import java.util.Map;

public class SFDProjectiles {

    private static final Map<String, ProjectileSupplier> projectiles;

    static {
        projectiles = Maps.newHashMap();
    }

    public static SFDProjectileEntity create(World world, String type, EntityLivingBase shooter) {
        return projectiles.get(type).create(world, shooter);
    }

    public static void registerProjectile(String type, ProjectileSupplier supplier) {
        projectiles.put(type, supplier);
    }
}
