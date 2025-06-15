package pao.paolog.plugins.paper;

import pao.paolog.plugins.paper.types.QpuCPlayer;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class QpuCrafterPlugin extends JavaPlugin {

    private static QpuCrafterPlugin instance;

    private List<QpuCPlayer> players;

    @Override
    public void onEnable() {
        // Fetch the players
        this.players = QpuCPlayer.fetchPlayers();
    }

    @Override
    public void onDisable() {

    }


    // Getters
    public List<QpuCPlayer> getPlayers() {
        return players;
    }

    // Get instance
    public static QpuCrafterPlugin getInstance() {
        return QpuCrafterPlugin.instance;
    }
}
