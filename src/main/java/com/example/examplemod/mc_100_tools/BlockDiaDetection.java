package com.example.examplemod.mc_100_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

public class BlockDiaDetection extends Block {

    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 3);

    public BlockDiaDetection() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(10f));
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        int color = state.getValue(COLOR);

        // 個数をカウントするための変数
        int count = 0;

        // 範囲の指定 ここではブロックを置いたところと周辺8マスの、置いた高さから最低高度まで
        for (int y = pos.getY(); y >= -64; y--) {
            for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
                for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
                    // 指定した座標のブロックの種類を取得
                    BlockState blockState = level.getBlockState(new BlockPos(x, y, z));
                    Block block = blockState.getBlock();
                    // 指定したブロックなら個数を増やす
                    if (block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE) count++;
                }
            }
        }

        // 個数によって指定するテクスチャを変更
        if (1 <= count && count < 4) color = 1;
        else if (4 <= count && count < 8) color = 2;
        else if (8 <= count) color = 3;

        level.setBlockAndUpdate(pos, state.setValue(COLOR, color));
    }
}