package pao.paolog.plugins.paper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import pao.paolog.plugins.paper.types.QpuCPlayer;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class QpuCrafterPlugin extends JavaPlugin {

    private static QpuCrafterPlugin instance;

    private List<QpuCPlayer> players;

    @Override
    public void onEnable() {
        // Set the instance
        QpuCrafterPlugin.instance = this;
        // Save default config
        saveDefaultConfig();

        // Get the config
        Location scannerStartLocation = getConfig().getLocation("scannerStartLocation");
        Location scannerEndLocation = getConfig().getLocation("scannerEndLocation");

        // Fetch the players
        this.players = QpuCPlayer.fetchPlayers(
                scannerStartLocation,
                scannerEndLocation
        );
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
