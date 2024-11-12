package com.example.examplemod.mc_106_custom_fluid;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fluids.FluidAttributes;

public class CustomFluid extends FlowingFluid {
    public Fluid getFlowing() {
        return ExampleMod.FLOWING_CUSTOM_FLUID;
    }

    public Fluid getSource() {
        return ExampleMod.CUSTOM_FLUID;
    }

    public Item getBucket() {
        return ExampleMod.CUSTOM_FLUID_BUCKET;
    }

    @Override
    protected FluidAttributes createAttributes() {
        return net.minecraftforge.fluids.FluidAttributes.builder(
                        new ResourceLocation("block/lava_still"),
                        new ResourceLocation("block/lava_flow"))
                .translationKey("block.minecraft.lava")
                .luminosity(15).density(3000).viscosity(6000).temperature(1300)
                .sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA)
                .build(this);
    }

    protected boolean canConvertToSource() {
        return false;
    }

    public boolean isSource(FluidState pState) {
        return false;
    }

    protected void beforeDestroyingBlock(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        this.fizz(pLevel, pPos);
    }

    private void fizz(LevelAccessor pLevel, BlockPos pPos) {
        pLevel.levelEvent(1501, pPos, 0);
    }

    public int getSlopeFindDistance(LevelReader pLevel) {
        return pLevel.dimensionType().ultraWarm() ? 4 : 2;
    }

    public int getDropOff(LevelReader pLevel) {
        return pLevel.dimensionType().ultraWarm() ? 1 : 2;
    }

    public int getAmount(FluidState pState) {
        return pState.getValue(LEVEL);
    }

    public boolean canBeReplacedWith(FluidState pFluidState, BlockGetter pBlockReader, BlockPos pPos, Fluid pFluid, Direction pDirection) {
        return pFluidState.getHeight(pBlockReader, pPos) >= 0.44444445F && pFluid.is(FluidTags.WATER);
    }

    public int getTickDelay(LevelReader p_76226_) {
        return p_76226_.dimensionType().ultraWarm() ? 10 : 30;
    }

    protected float getExplosionResistance() {
        return 100.0F;
    }

    public BlockState createLegacyBlock(FluidState pState) {
        return Blocks.LAVA.defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(pState)));
    }

    public static class Flowing extends CustomFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> pBuilder) {
            super.createFluidStateDefinition(pBuilder);
            pBuilder.add(LEVEL);
        }

        public int getAmount(FluidState pState) {
            return pState.getValue(LEVEL);
        }

        public boolean isSource(FluidState pState) {
            return false;
        }
    }

    public static class Source extends CustomFluid {
        public int getAmount(FluidState pState) {
            return 8;
        }

        public boolean isSource(FluidState pState) {
            return true;
        }
    }
}
