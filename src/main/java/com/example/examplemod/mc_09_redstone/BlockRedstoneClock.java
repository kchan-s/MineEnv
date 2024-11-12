package com.example.examplemod.mc_09_redstone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class BlockRedstoneClock extends Block {
    public static final BooleanProperty REDSTONE_CLOCK = BooleanProperty.create("redstone_clock");

    public BlockRedstoneClock() {
        super(Block.Properties.of(Material.STONE).strength(30f));
        this.registerDefaultState(this.stateDefinition.any().setValue(REDSTONE_CLOCK, true));
    }

    public boolean isSignalSource(BlockState pState) {
        return true;
    }

    public int getSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        boolean flag = pBlockState.getValue(REDSTONE_CLOCK);
        if (flag) return 15;
        else return 0;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(REDSTONE_CLOCK);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        pLevel.scheduleTick(pPos, this, 30);
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRand) {
        boolean flag = pLevel.hasNeighborSignal(pPos);
        if (flag) {
            pLevel.setBlock(pPos, pState.setValue(REDSTONE_CLOCK, false), 3);
        } else {
            pLevel.setBlock(pPos, pState.setValue(REDSTONE_CLOCK, true), 3);
        }
        pLevel.scheduleTick(pPos, pLevel.getBlockState(pPos).getBlock(), 30);
    }
}
