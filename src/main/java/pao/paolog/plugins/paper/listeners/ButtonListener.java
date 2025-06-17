package pao.paolog.plugins.paper.listeners;

import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import pao.paolog.plugins.paper.QpuCrafterPlugin;
import pao.paolog.plugins.paper.types.QpuCButton;

public class ButtonListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (block == null) return;
        if (!Tag.BUTTONS.isTagged(block.getType())) return;

        Switch blockSwitch = (Switch) block.getBlockData();
        // Is not powered, but will be in the next tick
        if (blockSwitch.isPowered()) return;

        QpuCButton button = QpuCButton.getAllButtons().get(block.getLocation());
        if (button == null) return;

        if (button.clickEventHandler != null) {
            button.clickEventHandler.run(button, player);
        }
    }

}
