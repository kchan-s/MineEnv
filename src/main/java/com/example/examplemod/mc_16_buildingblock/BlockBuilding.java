package com.example.examplemod.mc_16_buildingblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.Material;

public class BlockBuilding extends Block {

    int[][][] tofuHouse = {
            {
                    {2, 1, 1, 2, 2},
                    {2, 1, 1, 1, 2},
                    {2, 1, 1, 1, 2},
                    {2, 1, 1, 1, 2},
                    {2, 2, 2, 2, 2}
            },
            {
                    {2, 1, 1, 2, 2},
                    {2, 1, 1, 1, 2},
                    {2, 1, 1, 1, 2},
                    {2, 1, 1, 1, 2},
                    {2, 2, 2, 2, 2}
            },
            {
                    {2, 2, 2, 2, 2},
                    {2, 1, 1, 1, 2},
                    {2, 1, 1, 1, 2},
                    {2, 1, 1, 1, 2},
                    {2, 2, 2, 2, 2}
            },
            {
                    {3, 3, 3, 3, 3},
                    {4, 4, 4, 4, 4},
                    {5, 5, 5, 5, 5},
                    {2, 2, 2, 2, 2},
                    {2, 2, 2, 2, 2}
            }
    };

    public BlockBuilding() {
        super(BlockBehaviour.Properties.of(Material.DIRT).strength(30f));
    }

    @Override
    public void attack(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        super.attack(pState, pLevel, pPos, pPlayer);

        for (int y = 0; y < tofuHouse.length; y++) {
            for (int x = 0; x < tofuHouse[y].length; x++) {
                for (int z = 0; z < tofuHouse[y][x].length; z++) {
                    switch (tofuHouse[y][x][z]) {
                        case 1 -> pLevel.setBlockAndUpdate(pPos.offset(x, y, z), Blocks.OAK_LOG.defaultBlockState());
//                            BlockPos pos = pPlayer.blockPosition();
//                            BlockState wallState = Blocks.POLISHED_BLACKSTONE_WALL.defaultBlockState();
//                            BlockPos eastPos = pos.offset(x, y, z).relative(Direction.EAST);
//                            BlockPos westPos = pos.offset(x, y, z).relative(Direction.WEST);
//                            BlockPos northPos = pos.offset(x, y, z).relative(Direction.NORTH);
//                            BlockPos southPos = pos.offset(x, y, z).relative(Direction.SOUTH);
//
//                            if (!pLevel.isEmptyBlock(eastPos)) {
//                                wallState = wallState.setValue(WallBlock.EAST_WALL, true);
//                            } else if (!pLevel.isEmptyBlock(westPos)) {
//                                wallState = wallState.setValue(FenceBlock.WEST, true);
//                            } else if (!pLevel.isEmptyBlock(northPos)) {
//                                wallState = wallState.setValue(FenceBlock.NORTH, true);
//                            } else if (!pLevel.isEmptyBlock(southPos)) {
//                                wallState = wallState.setValue(FenceBlock.SOUTH, true);
//                            }
//                            pLevel.setBlockAndUpdate(pos.offset(x, y, z), wallState);
//                        }
                        case 2 -> pLevel.setBlockAndUpdate(pPos.offset(x, y, z), Blocks.OAK_TRAPDOOR.defaultBlockState().setValue(TrapDoorBlock.OPEN, false));
                        case 3 -> pLevel.setBlockAndUpdate(pPos.offset(x, y, z), Blocks.OAK_TRAPDOOR.defaultBlockState().setValue(TrapDoorBlock.OPEN, true));
                        case 4 -> pLevel.setBlockAndUpdate(pPos.offset(x, y, z), Blocks.GRINDSTONE.defaultBlockState().setValue(GrindstoneBlock.FACE, AttachFace.CEILING));
                        case 5 -> pLevel.setBlockAndUpdate(pPos.offset(x, y, z), Blocks.GRINDSTONE.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST));
                    }
                }
            }
        }
    }
}
