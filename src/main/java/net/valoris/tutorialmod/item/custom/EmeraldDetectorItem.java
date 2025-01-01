package net.valoris.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class EmeraldDetectorItem extends Item {
    public EmeraldDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int x = -5; x <= 5; x++) {
                for (int z = -5; z <= 5; z++) {
                    for (int y = positionClicked.getY(); y >= -64; y--) {
                        BlockPos blockPos = new BlockPos(positionClicked.getX() + x, y, positionClicked.getZ() + z);
                        BlockState state = context.getWorld().getBlockState(blockPos);

                        if(isValuableBlock(state)) {
                            ouputValuableCoordinates(blockPos, player, state.getBlock());
                            foundBlock = true;
                        }
                    }
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("No Valuables Found!"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void ouputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.EMERALD_ORE) || state.isOf(Blocks.DEEPSLATE_EMERALD_ORE);
    }
}
