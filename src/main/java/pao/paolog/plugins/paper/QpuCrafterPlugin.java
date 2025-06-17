package pao.paolog.plugins.paper;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

import pao.paolog.plugins.paper.commands.QpuCCommand;
import pao.paolog.plugins.paper.listeners.ButtonListener;
import pao.paolog.plugins.paper.types.QpuCPlayer;
import pao.paolog.plugins.paper.types.QpuCScoreBoard;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

import java.util.List;

public final class QpuCrafterPlugin extends JavaPlugin {

    private static QpuCrafterPlugin instance;

    private List<QpuCPlayer> players;
    private QpuCScoreBoard scoreBoard;

    // Configuration
    private Location scannerStartLocation;
    private Location scannerEndLocation;

    @Override
    public void onEnable() {
        // Set the instance
        QpuCrafterPlugin.instance = this;
        // Save default config
        saveDefaultConfig();

        // Get the config
        this.scannerStartLocation = getConfig().getLocation("scannerStartLocation");
        this.scannerEndLocation = getConfig().getLocation("scannerEndLocation");

        // Register the events and commands
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            QpuCCommand.register(commands.registrar().getDispatcher());
        });
        getServer().getPluginManager().registerEvents(new ButtonListener(), this);

        // Set the scoreboard
        this.scoreBoard = new QpuCScoreBoard("qpuc-scoreboard", "\uD835\uDD29");
    }

    @Override
    public void onDisable() {
        // Hide the scoreboard
        scoreBoard.hide();
    }


    // Public functions to be used on commands
    public void fetchPlayers() {
        this.players = QpuCPlayer.fetchPlayers(
                scannerStartLocation,
                scannerEndLocation
        );
    }

    // Getters
    public List<QpuCPlayer> getPlayers() {
        return players;
    }
    public QpuCScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    // Get instance
    public static QpuCrafterPlugin getInstance() {
        return QpuCrafterPlugin.instance;
    }
}
