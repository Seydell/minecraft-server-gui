package com.seydell.minecraft.plugin.gui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author das oLL
 */
public class Main extends JavaPlugin implements Listener {

    private final MainThread mainThread = new MainThread();
    private static CommandMap commandMap = null;

    static {
        try {

            if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
                final Field f = SimplePluginManager.class.getDeclaredField("commandMap");
                f.setAccessible(true);
                commandMap = (CommandMap) f.get(Bukkit.getPluginManager());
            }

        } catch (final SecurityException e) {
        } catch (final Exception e) {
        }
    }

    @Override
    public void onEnable() {
        commandMap.register("oLLs", new Command("showgui", "open server GUI", "/showgui", new ArrayList<String>()) {
            @Override
            public boolean execute(CommandSender cs, String string, String[] strings) {
                mainThread.getGuiFrame().setVisible(true);
                return true;
            }
        });
        getServer().getPluginManager().registerEvents(this, this);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Thread(mainThread).start();
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc="bukkit events">
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        mainThread.getGuiFrame().addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onLogout(PlayerQuitEvent event) {
        mainThread.getGuiFrame().removePlayer(event.getPlayer());
    }

    @EventHandler
    public void onKick(PlayerKickEvent event) {
        mainThread.getGuiFrame().removePlayer(event.getPlayer());
    }

    @EventHandler
    public void onWeatherRainingChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            mainThread.getGuiFrame().weatherChanged(1);
        } else {
            mainThread.getGuiFrame().weatherChanged(0);
        }
    }

    @EventHandler
    public void onWeatherThunderChange(ThunderChangeEvent event) {
        if (event.toThunderState()) {
            mainThread.getGuiFrame().weatherChanged(2);
        }
    }
    //</editor-fold>

}
