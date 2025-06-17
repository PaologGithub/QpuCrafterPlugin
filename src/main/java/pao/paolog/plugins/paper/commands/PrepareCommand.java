package pao.paolog.plugins.paper.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import com.mojang.brigadier.Command;
import org.bukkit.command.CommandSender;
import pao.paolog.plugins.paper.QpuCrafterPlugin;
import pao.paolog.plugins.paper.types.QpuCPlayer;

public class PrepareCommand implements Command<CommandSourceStack> {

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        // Get the plugin instance
        QpuCrafterPlugin instance = QpuCrafterPlugin.getInstance();
        // Get the sender
        CommandSender sender = context.getSource().getSender();

        // Fetch the players
        sender.sendMessage("Fetching players");
        instance.fetchPlayers();
        sender.sendMessage("Found " + instance.getPlayers().size() + " players: ");
        for (QpuCPlayer player : instance.getPlayers()) {
            sender.sendMessage(" - " + player.getMinecraftPlayer().getName());
        }

        // Show the scoreboard
        instance.getScoreBoard().show();
        sender.sendMessage("Showed ScoreBoard");

        // TO REMOVE
        var scoreBoard = instance.getScoreBoard();
        scoreBoard.addLine("Non sponsorisé par \uD835\uDD2C");
        scoreBoard.addLine("Sponsorisé par: Sponsorisateur secret");
        scoreBoard.addLine("§cScores: §r");
        for (QpuCPlayer player : instance.getPlayers()) {
            scoreBoard.addLine(" - §a" + player.getMinecraftPlayer().getName() + "§r: §e" + player.getScore());
        }

        return Command.SINGLE_SUCCESS;
    }
}
