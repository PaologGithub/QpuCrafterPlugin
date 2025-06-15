package pao.paolog.plugins.paper.types;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.ArrayList;

public class QpuCPlayer {

    private final Player minecraftPlayer;
    private final int score;

    public QpuCPlayer(Player player) {
        this.minecraftPlayer = player;
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

        // Some debug information, to replace after
        players.add(new QpuCPlayer(
                Bukkit.getPlayer("Player")
        ));

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
}
