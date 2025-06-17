package pao.paolog.plugins.paper.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ZoneScanner {

    public static List<Block> scanZone(Location startLocation, Location endLocation, Material toFind) {
        List<Block> blocks = new ArrayList<Block>();

        if (!startLocation.getWorld().equals(endLocation.getWorld())) {
            throw new IllegalArgumentException("Locations must be on the same world");
        }

        World world = startLocation.getWorld();

        int minX = Math.min(startLocation.getBlockX(), endLocation.getBlockX());
        int minY = Math.min(startLocation.getBlockY(), endLocation.getBlockY());
        int minZ = Math.min(startLocation.getBlockZ(), endLocation.getBlockZ());

        int maxX = Math.max(startLocation.getBlockX(), endLocation.getBlockX());
        int maxY = Math.max(startLocation.getBlockY(), endLocation.getBlockY());
        int maxZ = Math.max(startLocation.getBlockZ(), endLocation.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);

                    if (block.getType() == toFind) {
                        blocks.add(block);
                    }
                }
            }
        }

        return blocks;
    }

}
