package fr.minecraftforgefrance.sfd;

import fr.minecraftforgefrance.sfd.common.item.FunWeaponItem;
import fr.minecraftforgefrance.sfd.common.item.ItemAmmo;
import fr.minecraftforgefrance.sfd.common.item.WeaponItem;
import fr.minecraftforgefrance.sfd.common.weapons.EnumWeaponType;
import fr.minecraftforgefrance.sfd.common.weapons.WeaponDefinition;
import net.minecraft.item.Item;
import net.minecraft.util.MinecraftError;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SFDLib.modid)
public class SFDLib {

    public static final String modid = "sfd_lib";
    @Mod.Instance(SFDLib.modid)
    public static SFDLib instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent evt) {
        // check if we are in a deobfuscated environment
        if(MinecraftError.class.getSimpleName().contains("Minecraft")) {
            WeaponDefinition definition = new WeaponDefinition();
            definition.setAmmoType("sfd_test");
            definition.setId("sfd_test");
            definition.setCooldown(5*10);
            definition.setWeaponType(EnumWeaponType.HITSCAN);
            definition.setBaseDamage(1);
            Item weapon = new WeaponItem(definition);
            Item funVersion = new FunWeaponItem(definition);

            weapon.setRegistryName(modid, definition.getId());
            GameRegistry.register(weapon);

            funVersion.setRegistryName(modid, "fun_"+definition.getId());
            GameRegistry.register(funVersion);

            String ammoType = definition.getAmmoType();
            ItemAmmo ammo = new ItemAmmo(ammoType);
            ammo.setRegistryName(modid, "ammo_"+ammoType);
            GameRegistry.register(ammo);
        }
    }

}
