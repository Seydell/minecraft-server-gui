package com.seydell.minecraft.plugin.gui;

import static org.bukkit.Bukkit.getLogger;

/**
 *
 * @author das oLL
 */
public class MainThread implements Runnable {

    final GuiFrame guiFrame = new GuiFrame();

    public GuiFrame getGuiFrame() {
        return guiFrame;
    }

    @Override
    public void run() {
        try {
            guiFrame.run();
            guiFrame.setVisible(true);
        } catch (Exception e) {
            getLogger().severe(e.getMessage());
        }
    }

}
