package fr.minecraftforgefrance.sfd.common.item;

import fr.minecraftforgefrance.sfd.common.weapons.WeaponDefinition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

/**
 * Same thing than WeaponItem but with cooldown and preFiringPause both at minimum
 */
public class FunWeaponItem extends WeaponItem {
    public FunWeaponItem(WeaponDefinition definition) {
        super(definition);
        setMaxDamage(1);
        setUnlocalizedName("fun_"+getUnlocalizedName().substring("item.".length()));
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 0;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.ITALIC+"Infinite ammo");
        tooltip.add(TextFormatting.ITALIC+"No cooldown");
        tooltip.add("Go kill things, have fun!");
    }
}
