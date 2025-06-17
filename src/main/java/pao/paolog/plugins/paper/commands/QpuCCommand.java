package pao.paolog.plugins.paper.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public class QpuCCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal("qpucrafter");

        root.then(
                Commands.literal("prepare")
                        .requires(sender -> sender.getSender().isOp())
                        .executes(new PrepareCommand())

        );
        root.then(Commands.literal("start"));

        dispatcher.register(root);
    }
}
