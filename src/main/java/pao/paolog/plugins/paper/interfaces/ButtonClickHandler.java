package pao.paolog.plugins.paper.interfaces;

import org.bukkit.entity.Player;
import pao.paolog.plugins.paper.types.QpuCButton;

@FunctionalInterface
public interface ButtonClickHandler {
    void run(QpuCButton button, Player player);
}
