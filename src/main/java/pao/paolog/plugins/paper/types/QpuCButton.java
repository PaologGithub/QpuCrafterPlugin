package pao.paolog.plugins.paper.types;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Switch;

import pao.paolog.plugins.paper.interfaces.ButtonClickHandler;

import java.util.HashMap;

public class QpuCButton {

    private static final HashMap<Location, QpuCButton> buttons = new HashMap<Location, QpuCButton>();

    private final Block buttonBlock;
    private final Switch minecraftButton;

    public ButtonClickHandler clickEventHandler;

    public QpuCButton(Block button) {
        if (!Tag.BUTTONS.isTagged(button.getType())) {
            throw new IllegalArgumentException("BlockData must be have the BUTTONS tag.");
        }

        this.buttonBlock = button;
        this.minecraftButton = (Switch) button.getBlockData();

        if (!QpuCButton.buttons.containsKey(button.getLocation())) {
            QpuCButton.buttons.put(button.getLocation(), this);
        }
    }

    public void setPowered(boolean value) {
        minecraftButton.setPowered(value);
        buttonBlock.setBlockData(minecraftButton);
    }

    public void disable() {
        buttonBlock.setType(Material.AIR);
    }

    public void enable() {
        // Because QpuCButton#setPowered already sets the block as the crimson button, we can just use QpuCButton#setPowered(false);
        this.setPowered(false);
    }

    public boolean isEnabled() {
        return buttonBlock.getType() != Material.AIR;
    }

    // ClickEvent
    public void setClickEventHandler(ButtonClickHandler eventHandler) {
        this.clickEventHandler = eventHandler;
    }

    // Getters
    public static HashMap<Location, QpuCButton> getAllButtons() {
        return buttons;
    }
}
