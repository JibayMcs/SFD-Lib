package fr.minecraftforgefrance.sfd.common;

import fr.minecraftforgefrance.sfd.common.entity.SFDProjectileEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public interface ProjectileSupplier {
    SFDProjectileEntity create(World world, EntityLivingBase shooter);
}
