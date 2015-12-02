package com.seydell.minecraft.plugin.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author das oLL
 */
public class PlayerPictureCache {

    private static LinkedHashMap<String, Icon> pictureCache = new LinkedHashMap<>();

    public static Icon getPlayerIcon(String playerName, String size) {
        String pictureLocator = playerName + "/" + size;
        if (pictureCache.containsKey(pictureLocator)) {
            return pictureCache.get(pictureLocator);
        } else {
            Icon icon = loadPlayerIcon(pictureLocator, Integer.parseInt(size));
            pictureCache.put(pictureLocator, icon);
            return icon;
        }
    }

    private static Icon loadPlayerIcon(String pictureLocator, int size) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new URL("http://cravatar.eu/head/" + pictureLocator));
        } catch (IOException ex) {
        }

        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        }

        return new ImageIcon(bufferedImage);
    }

    public static BufferedImage loadPlayerAvatar(String playerName) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new URL("http://cravatar.eu/avatar/" + playerName + "/64"));
        } catch (IOException ex) {
        }

        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
        }

        return bufferedImage;
    }

}
