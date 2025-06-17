package pao.paolog.plugins.paper.types;

import net.kyori.adventure.text.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.HangingSign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;

import pao.paolog.plugins.paper.utils.ZoneScanner;

import java.util.List;
import java.util.ArrayList;

public class QpuCPlayer {

    private final Player minecraftPlayer;
    private final QpuCButton button;
    private final int score;

    public QpuCPlayer(Player player, QpuCButton button) {
        this.minecraftPlayer = player;
        this.button = button;
        this.score = 0;
    }

    public Player getMinecraftPlayer() {
        return this.minecraftPlayer;
    }

    public int getScore() {
        return this.score;
    }

    // Static functions
    public static List<QpuCPlayer> fetchPlayers(Location startLocation, Location endLocation) {
        List<QpuCPlayer> players = new ArrayList<QpuCPlayer>();

        List<Block> signs = ZoneScanner.scanZone(startLocation, endLocation, Material.OAK_HANGING_SIGN);

        for (Block signBlock : signs) {
            HangingSign sign = (HangingSign) signBlock.getState();
            TextComponent firstLine = (TextComponent) sign.getSide(Side.FRONT).line(0);
            String username = firstLine.content();

            Player player = Bukkit.getPlayerExact(username);

            if (player != null)  {
                Block buttonBlock = signBlock.getRelative(BlockFace.UP, 2);

                QpuCButton button = new QpuCButton(buttonBlock);

                players.add(new QpuCPlayer(
                        player,
                        button
                ));
            }
        }

        return players;
    }

    public static QpuCPlayer getPlayerFromName(List<QpuCPlayer> players, Player minecraftPlayer) {
        for (QpuCPlayer player : players) {
            if (player.minecraftPlayer == minecraftPlayer) {
                return player;
            }
        }

        return null;
    }

    public static QpuCPlayer getPlayerFromButton(List<QpuCPlayer> players, QpuCButton button) {
        for (QpuCPlayer player : players) {
            if (player.button == button) {
                return player;
            }
        }

        return null;
    }
}
