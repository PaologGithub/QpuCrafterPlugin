package pao.paolog.plugins.paper.types;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import pao.paolog.plugins.paper.types.QpuCButton;

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
    public static List<QpuCPlayer> fetchPlayers() {
        List<QpuCPlayer> players = new ArrayList<QpuCPlayer>();



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
