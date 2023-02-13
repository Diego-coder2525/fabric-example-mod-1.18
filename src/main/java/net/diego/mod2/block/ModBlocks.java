package net.diego.mod2.block;

import net.diego.mod2.Mod2;
import net.diego.mod2.block.custom.SpeedyBlock;
import net.diego.mod2.item.ModItemGroup;
import net.diego.mod2.item.custom.GrapeVineBlock;
import net.diego.mod2.item.custom.MythrilLampBlock;
import net.diego.mod2.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ModBlocks {
    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.MYTHRIL,"tooltip.mod2.mythril_block");
    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block NETHERRACK_MYTHRIL_ORE = registerBlock("netherrack_mythril_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);

    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_BUTTON = registerBlock("mythril_button",
            new StoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(6f).noCollision()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_PRESSURE_PLATE = registerBlock("mythril_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_FENCE = registerBlock("mythril_fence",
            new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_FENCE_GATE = registerBlock("mythril_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_WALL = registerBlock("mythril_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);

    public static final Block MOD2_DOOR = registerBlock("mod2_door",
            new DoorBlock(FabricBlockSettings.of(Material.WOOD).strength(6f).requiresTool().nonOpaque()),ModItemGroup.MYTHRIL);
    public static final Block MOD2_TRAPDOOR = registerBlock("mod2_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(6f).requiresTool().nonOpaque()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_STAIRS = registerBlock("mythril_stairs",
            new StairsBlock(ModBlocks.MYTHRIL_BLOCK.getDefaultState(),FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_SLAB = registerBlock("mythril_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),ModItemGroup.MYTHRIL);

    public static final Block LILAC_FLOWER = registerBlock("lilac_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE,12,FabricBlockSettings.copy(Blocks.DANDELION).strength(4f).nonOpaque()),ModItemGroup.MYTHRIL);
    public static final Block POTTED_LILAC_FLOWER = registerBlockWOBlockItem("potted_lilac_flower",
            new FlowerPotBlock(ModBlocks.LILAC_FLOWER,
                    FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).nonOpaque()),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_LAMP = registerBlock("mythril_lamp",
            new MythrilLampBlock(FabricBlockSettings.of(Material.METAL)
            .sounds(ModSounds.MYTHRIL_SOUNDS).strength(4f).requiresTool().luminance((state)->state.get(MythrilLampBlock.CLICKED) ? 15 : 0)),ModItemGroup.MYTHRIL);

    public static final Block WINTER_WINDOW = registerBlock("winter_window",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(3.0f).nonOpaque()), ModItemGroup.MYTHRIL);
    public static final Block GRAPE_VINE = registerBlockWOBlockItem("grape_vine",
            new GrapeVineBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()), ModItemGroup.MYTHRIL);



    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(Mod2.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(Mod2.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name,block,group);
        return Registry.register(Registry.BLOCK, new Identifier(Mod2.MOD_ID,name),block);
    }
    private static Block registerBlockWOBlockItem(String name, Block block, ItemGroup group){

        return Registry.register(Registry.BLOCK, new Identifier(Mod2.MOD_ID,name),block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(Mod2.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks(){
        Mod2.LOGGER.info("Registering ModBlocks for "+Mod2.MOD_ID);
    }
}
