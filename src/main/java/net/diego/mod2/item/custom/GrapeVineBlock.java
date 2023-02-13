package net.diego.mod2.item.custom;

import net.diego.mod2.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class GrapeVineBlock extends CropBlock {


    public GrapeVineBlock(Settings settings) {
        super(settings);
    }



    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GRAPE_SEEDS;
    }
}
