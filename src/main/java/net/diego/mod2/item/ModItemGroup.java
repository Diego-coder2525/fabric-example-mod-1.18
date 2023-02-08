package net.diego.mod2.item;

import net.diego.mod2.Mod2;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MYTHRIL = FabricItemGroupBuilder.build(new Identifier(Mod2.MOD_ID, "mythril"),
            ()->new ItemStack(ModItems.MYTHRIL_INGOT));
}
