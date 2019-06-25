package gtrevolution.item.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import net.minecraftforge.fluids.FluidStack;

import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.util.GTUtility;
import gregtech.common.tools.ToolBase;
import gtrevolution.machines.te.OilRig;

public class OilScanner extends ToolBase
{
    @Override
    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return 10;
    }

    @Override
    public int getToolDamagePerContainerCraft(ItemStack stack) {
        return 5;
    }

    public static class Behaviour implements IItemBehaviour
    {
        @Override
        public ActionResult<ItemStack> onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            if(!world.isRemote)
            {
                Chunk chunkAt = world.getChunkFromBlockCoords(pos);
                FluidStack output = new OilRig.ChunkReserve(chunkAt.x, chunkAt.z, world.getSeed()).getOutput();
                if (output != null)
                {
                    player.sendMessage(new TextComponentString("Found " + output.getLocalizedName() + "{" + output.amount + " mB}"));
                }
                else
                {
                    player.sendMessage(new TextComponentString("No oil reserves found"));
                }
                GTUtility.doDamageItem(player.getHeldItem(hand), 10, false);
            }
            player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 40);
            return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(hand));
        }
    }
}