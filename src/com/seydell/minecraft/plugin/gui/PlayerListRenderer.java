package com.seydell.minecraft.plugin.gui;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 *
 * @author das oLL
 */
public class PlayerListRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setOpaque(true);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        if (value instanceof Player) {
            Player player = (Player) value;
            label.setIcon(PlayerPictureCache.getPlayerIcon(player.getName(), "24"));
            label.setText(player.getName());
        } else if (value instanceof OfflinePlayer) {
            OfflinePlayer offlinePlayer = (OfflinePlayer) value;
            label.setIcon(PlayerPictureCache.getPlayerIcon(offlinePlayer.getName(), "24"));
            label.setText(offlinePlayer.getName());
        }

        return label;
    }

}
