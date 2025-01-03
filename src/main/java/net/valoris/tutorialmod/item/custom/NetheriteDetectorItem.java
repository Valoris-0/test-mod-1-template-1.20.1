package net.valoris.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetheriteDetectorItem extends Item {
    public NetheriteDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            // Calculate the chunk boundaries
            int chunkXStart = (positionClicked.getX() >> 4) << 4;
            int chunkZStart = (positionClicked.getZ() >> 4) << 4;

            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    for (int y = positionClicked.getY(); y >= -64; y--) {
                        BlockPos blockPos = new BlockPos(chunkXStart + x, y, chunkZStart + z);
                        BlockState state = context.getWorld().getBlockState(blockPos);

                        if (isValuableBlock(state)) {
                            ouputValuableCoordinates(blockPos, player, state.getBlock());
                            foundBlock = true;
                        }
                    }
                }
            }

            if (!foundBlock) {
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
        return state.isOf(Blocks.ANCIENT_DEBRIS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.netherite_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
