package com.seydell.minecraft.plugin.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getOnlinePlayers;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.SimplePluginManager;

/**
 *
 * @author das oLL
 */
public class GuiFrame extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="declaration">
    private static final long TIMER_DELAY = 10000L;
    private static TreeSet<String> commandSet = new TreeSet<>();
    private static List<Player> playerList = new ArrayList<>();
    private Server server = null;
    private String iconFileName = "com/seydell/minecraft/plugin/gui/images/diamond.png";
    private String delImageFileName = "com/seydell/minecraft/plugin/gui/images/delete2.png";
    private URL iconFileUrl;
    private URL delImageUrl;
    private Image delImage;
    private static SimpleCommandMap simpleCommandMap = null;

    static {
        try {

            if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
                final Field f = SimplePluginManager.class.getDeclaredField("commandMap");
                f.setAccessible(true);
                simpleCommandMap = (SimpleCommandMap) f.get(Bukkit.getPluginManager());
            }

        } catch (final SecurityException e) {
        } catch (final Exception e) {
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="initialization">
    public GuiFrame() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            // java.util.logging.Logger.getLogger(GuiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        delImageUrl = getClass().getClassLoader().getResource(delImageFileName);
        delImage = new ImageIcon(delImageUrl).getImage();
        initComponents();
        setLocationRelativeTo(null);
        iconFileUrl = getClass().getClassLoader().getResource(iconFileName);
        this.setIconImage(new ImageIcon(iconFileUrl).getImage());
    }

    public void run() {
        updateServerStatus();
    }

    private void initCommandBox() {
        commandSet.clear();
        for (Command command : simpleCommandMap.getCommands()) {
            commandSet.add(command.getName());
        }
        commandComboBox.setModel(new DefaultComboBoxModel(commandSet.toArray()));
        Command command = simpleCommandMap.getCommand(commandComboBox.getSelectedItem().toString());
        String cmd = command.getUsage().split(" ")[0];
        jLabel1.setText(cmd);
        jLabel2.setText(command.getUsage().replace(cmd, ""));
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTicks = new javax.swing.ButtonGroup();
        weatherPopupMenu = new javax.swing.JPopupMenu();
        clearMenuItem = new javax.swing.JMenuItem();
        rainMenuItem = new javax.swing.JMenuItem();
        thunderMenuItem = new javax.swing.JMenuItem();
        opPlayerPopupMenu = new javax.swing.JPopupMenu();
        idCardMenuItem = new javax.swing.JMenuItem();
        addNameMenuItem = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        removeMenuItem = new javax.swing.JMenuItem();
        timePopupMenu = new javax.swing.JPopupMenu();
        dayMenuItem = new javax.swing.JMenuItem();
        nightMenuItem = new javax.swing.JMenuItem();
        gameModePopupMenu = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        ticksPopupMenu = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        difficultyPopupMenu = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        bannedPlayerPopupMenu = new javax.swing.JPopupMenu();
        idCardMenuItem1 = new javax.swing.JMenuItem();
        addNameMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        removeMenuItem1 = new javax.swing.JMenuItem();
        whitePlayerPopupMenu = new javax.swing.JPopupMenu();
        idCardMenuItem2 = new javax.swing.JMenuItem();
        addNameMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        removeMenuItem2 = new javax.swing.JMenuItem();
        onlinePlayerPopupMenu = new javax.swing.JPopupMenu();
        idCardMenuItem3 = new javax.swing.JMenuItem();
        addNameMenuItem3 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        spawnMenuItem = new javax.swing.JMenuItem();
        kickMenuItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        addOPMenuItem = new javax.swing.JMenuItem();
        addWhiteMenuItem = new javax.swing.JMenuItem();
        addBlackMenuItem = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        serverNameLabel = new javax.swing.JLabel();
        motdLabel = new javax.swing.JLabel();
        numberOfPlayersLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        weatherButton = new MenuButton("Weather", weatherPopupMenu);
        gamemodeButton = new MenuButton("Gamemode", gameModePopupMenu);
        difficultyButton = new MenuButton("Difficulty", difficultyPopupMenu);
        jToggleButton4 = new MenuButton("Time", timePopupMenu);
        jToggleButton5 = new MenuButton("TickSpeed", ticksPopupMenu);
        jPanel9 = new javax.swing.JPanel();
        commandComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JLabel label = new JLabel(new ImageIcon(delImage));
        label.setCursor(Cursor.getDefaultCursor());
        commandTextField = new javax.swing.JTextField();
        commandButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serverTypeLabel = new javax.swing.JLabel();
        worldLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        onlinePlayerList = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        opPlayerList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        whitePlayerList = new javax.swing.JList<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bannedPlayerList = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        clearMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/sun_and_cloud.png"))); // NOI18N
        clearMenuItem.setText("clear");
        clearMenuItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMenuItemActionPerformed(evt);
            }
        });
        weatherPopupMenu.add(clearMenuItem);

        rainMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/cloud_dark.png"))); // NOI18N
        rainMenuItem.setText("rain");
        rainMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rainMenuItemActionPerformed(evt);
            }
        });
        weatherPopupMenu.add(rainMenuItem);

        thunderMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/flash.png"))); // NOI18N
        thunderMenuItem.setText("thunder");
        thunderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thunderMenuItemActionPerformed(evt);
            }
        });
        weatherPopupMenu.add(thunderMenuItem);

        idCardMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card.png"))); // NOI18N
        idCardMenuItem.setText("Player ID-Card");
        idCardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCardMenuItemActionPerformed(evt);
            }
        });
        opPlayerPopupMenu.add(idCardMenuItem);

        addNameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card_add.png"))); // NOI18N
        addNameMenuItem.setText("Add Player Name to Command");
        addNameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameMenuItemActionPerformed(evt);
            }
        });
        opPlayerPopupMenu.add(addNameMenuItem);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/photo_portrait.png"))); // NOI18N
        jMenuItem16.setText("Take Avatar as Server Icon");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        opPlayerPopupMenu.add(jMenuItem16);
        opPlayerPopupMenu.add(jSeparator4);

        removeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/pawn_delete.png"))); // NOI18N
        removeMenuItem.setText("Remove from List");
        removeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        opPlayerPopupMenu.add(removeMenuItem);

        dayMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/sun.png"))); // NOI18N
        dayMenuItem.setText("day");
        dayMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayMenuItemActionPerformed(evt);
            }
        });
        timePopupMenu.add(dayMenuItem);

        nightMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/moon.png"))); // NOI18N
        nightMenuItem.setText("night");
        nightMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nightMenuItemActionPerformed(evt);
            }
        });
        timePopupMenu.add(nightMenuItem);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/palm.png"))); // NOI18N
        jMenuItem4.setText("survival");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        gameModePopupMenu.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/toolbox.png"))); // NOI18N
        jMenuItem5.setText("creative");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        gameModePopupMenu.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/knight.png"))); // NOI18N
        jMenuItem6.setText("adventure");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        gameModePopupMenu.add(jMenuItem6);

        buttonGroupTicks.add(jRadioButtonMenuItem1);
        jRadioButtonMenuItem1.setText("slow");
        jRadioButtonMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/tractor_green.png"))); // NOI18N
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        ticksPopupMenu.add(jRadioButtonMenuItem1);

        buttonGroupTicks.add(jRadioButtonMenuItem2);
        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("normal");
        jRadioButtonMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/car_sedan_blue.png"))); // NOI18N
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        ticksPopupMenu.add(jRadioButtonMenuItem2);

        buttonGroupTicks.add(jRadioButtonMenuItem3);
        jRadioButtonMenuItem3.setText("fast");
        jRadioButtonMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/sportscar.png"))); // NOI18N
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        ticksPopupMenu.add(jRadioButtonMenuItem3);

        buttonGroupTicks.add(jRadioButtonMenuItem5);
        jRadioButtonMenuItem5.setText("very fast");
        jRadioButtonMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/helicopter.png"))); // NOI18N
        jRadioButtonMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem5ActionPerformed(evt);
            }
        });
        ticksPopupMenu.add(jRadioButtonMenuItem5);

        buttonGroupTicks.add(jRadioButtonMenuItem4);
        jRadioButtonMenuItem4.setText("very very fast");
        jRadioButtonMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/airplane.png"))); // NOI18N
        jRadioButtonMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem4ActionPerformed(evt);
            }
        });
        ticksPopupMenu.add(jRadioButtonMenuItem4);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/angel.png"))); // NOI18N
        jMenuItem8.setText("peaceful");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        difficultyPopupMenu.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/yinyang.png"))); // NOI18N
        jMenuItem9.setText("easy");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        difficultyPopupMenu.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/boxing_gloves_blue.png"))); // NOI18N
        jMenuItem10.setText("normal");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        difficultyPopupMenu.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/skull.png"))); // NOI18N
        jMenuItem11.setText("hard");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        difficultyPopupMenu.add(jMenuItem11);

        idCardMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card.png"))); // NOI18N
        idCardMenuItem1.setText("Player ID-Card");
        idCardMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCardMenuItem1ActionPerformed(evt);
            }
        });
        bannedPlayerPopupMenu.add(idCardMenuItem1);

        addNameMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card_add.png"))); // NOI18N
        addNameMenuItem1.setText("Add Player Name to Command");
        addNameMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameMenuItem1ActionPerformed(evt);
            }
        });
        bannedPlayerPopupMenu.add(addNameMenuItem1);
        bannedPlayerPopupMenu.add(jSeparator3);

        removeMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/pawn_delete.png"))); // NOI18N
        removeMenuItem1.setText("Remove from List");
        removeMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItem1ActionPerformed(evt);
            }
        });
        bannedPlayerPopupMenu.add(removeMenuItem1);

        idCardMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card.png"))); // NOI18N
        idCardMenuItem2.setText("Player ID-Card");
        idCardMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCardMenuItem2ActionPerformed(evt);
            }
        });
        whitePlayerPopupMenu.add(idCardMenuItem2);

        addNameMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card_add.png"))); // NOI18N
        addNameMenuItem2.setText("Add Player Name to Command");
        addNameMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameMenuItem2ActionPerformed(evt);
            }
        });
        whitePlayerPopupMenu.add(addNameMenuItem2);
        whitePlayerPopupMenu.add(jSeparator2);

        removeMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/pawn_delete.png"))); // NOI18N
        removeMenuItem2.setText("Remove from List");
        removeMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItem2ActionPerformed(evt);
            }
        });
        whitePlayerPopupMenu.add(removeMenuItem2);

        idCardMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card.png"))); // NOI18N
        idCardMenuItem3.setText("Player ID-Card");
        idCardMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCardMenuItem3ActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(idCardMenuItem3);

        addNameMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/id_card_add.png"))); // NOI18N
        addNameMenuItem3.setText("Add Player Name to Command");
        addNameMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameMenuItem3ActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(addNameMenuItem3);
        onlinePlayerPopupMenu.add(jSeparator5);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/playingcard.png"))); // NOI18N
        jMenu2.setText("Set Player Gamemode");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/palm.png"))); // NOI18N
        jMenuItem13.setText("survival");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/toolbox.png"))); // NOI18N
        jMenuItem14.setText("creative");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/knight.png"))); // NOI18N
        jMenuItem15.setText("adventure");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        onlinePlayerPopupMenu.add(jMenu2);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/hand_money.png"))); // NOI18N
        jMenuItem2.setText("Give to Player ...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(jMenuItem2);

        spawnMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/signpost.png"))); // NOI18N
        spawnMenuItem.setText("Send Player to Spawn Point");
        spawnMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spawnMenuItemActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(spawnMenuItem);

        kickMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/hand_red_card.png"))); // NOI18N
        kickMenuItem.setText("Kick Player");
        kickMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kickMenuItemActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(kickMenuItem);
        onlinePlayerPopupMenu.add(jSeparator6);

        addOPMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/dude6.png"))); // NOI18N
        addOPMenuItem.setText("Add Player to OP List");
        addOPMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOPMenuItemActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(addOPMenuItem);

        addWhiteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/policeman_bobby.png"))); // NOI18N
        addWhiteMenuItem.setText("Add Player to White List");
        addWhiteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWhiteMenuItemActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(addWhiteMenuItem);

        addBlackMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/robber.png"))); // NOI18N
        addBlackMenuItem.setText("Add Player to Black List");
        addBlackMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBlackMenuItemActionPerformed(evt);
            }
        });
        onlinePlayerPopupMenu.add(addBlackMenuItem);

        setTitle("oLL's Minecraft Server GUI Plugin");
        setMinimumSize(new java.awt.Dimension(996, 706));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Avatar images are provided by cravatar.eu - Thanks to all authors of stackoverflow.com and greetings to sBros and crafter120");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Server"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/minecraft.png"))); // NOI18N
        jButton1.setActionCommand("imageButton");
        jButton1.setMaximumSize(new java.awt.Dimension(72, 72));
        jButton1.setMinimumSize(new java.awt.Dimension(72, 72));
        jButton1.setPreferredSize(new java.awt.Dimension(72, 72));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        serverNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        serverNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/refresh16.png"))); // NOI18N
        serverNameLabel.setText("Minecraft Server");
        serverNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        serverNameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serverNameLabelMouseClicked(evt);
            }
        });

        motdLabel.setText("A Minecraft Server");

        numberOfPlayersLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/users1.png"))); // NOI18N
        numberOfPlayersLabel.setText("0 / 0");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        weatherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/sun_and_cloud.png"))); // NOI18N
        weatherButton.setText("Weather");
        jPanel8.add(weatherButton);

        gamemodeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/playingcard.png"))); // NOI18N
        gamemodeButton.setText("Gamemode");
        jPanel8.add(gamemodeButton);

        difficultyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/weight2.png"))); // NOI18N
        difficultyButton.setText("Difficulty");
        jPanel8.add(difficultyButton);

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/clock.png"))); // NOI18N
        jToggleButton4.setText("Time");
        jPanel8.add(jToggleButton4);

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/clock_refresh.png"))); // NOI18N
        jToggleButton5.setText("TickSpeed");
        jPanel8.add(jToggleButton5);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        commandComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                commandComboBoxItemStateChanged(evt);
            }
        });
        commandComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                commandComboBoxPopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setText("command");

        commandTextField.setLayout(new BorderLayout());
        commandTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        commandTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                commandTextFieldKeyReleased(evt);
            }
        });

        commandButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/gears_run.png"))); // NOI18N
        commandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("syntax");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(commandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(commandTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(commandComboBox)
                    .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commandTextField.add(label, BorderLayout.EAST);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                commandTextField.setText("");
            }
        });

        serverTypeLabel.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        serverTypeLabel.setText("Server Type");

        worldLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/earth2.png"))); // NOI18N
        worldLabel.setText("-");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(serverTypeLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(motdLabel)
                                    .addComponent(serverNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numberOfPlayersLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(worldLabel, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(worldLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberOfPlayersLabel))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(serverNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverTypeLabel)))
                .addGap(24, 24, 24)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Players"));

        onlinePlayerList.setComponentPopupMenu(onlinePlayerPopupMenu);
        jScrollPane4.setViewportView(onlinePlayerList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("OPs"));

        opPlayerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        opPlayerList.setComponentPopupMenu(opPlayerPopupMenu);
        jScrollPane3.setViewportView(opPlayerList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("White List"));

        whitePlayerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        whitePlayerList.setComponentPopupMenu(whitePlayerPopupMenu);
        jScrollPane1.setViewportView(whitePlayerList);

        jCheckBox1.setText("Use White List");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Black List"));

        bannedPlayerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bannedPlayerList.setComponentPopupMenu(bannedPlayerPopupMenu);
        jScrollPane2.setViewportView(bannedPlayerList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(263, 35));

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/wrench.png"))); // NOI18N
        jMenu6.setText("Server");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/server_edit.png"))); // NOI18N
        jMenuItem3.setText("Server Properties");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/refresh.png"))); // NOI18N
        jMenuItem7.setText("Restart Server");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/stop.png"))); // NOI18N
        jMenuItem12.setText("Stop Server");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar1.add(jMenu6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/help.png"))); // NOI18N
        jMenu1.setText("Support");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/seydell/minecraft/plugin/gui/images/creditcards.png"))); // NOI18N
        jMenuItem1.setText("Donation");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="menu actions">
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            File file = getFile();

            BufferedImage originalImage = ImageIO.read(file);
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            BufferedImage resizeImagePng = resizeImage(originalImage, type);
            Files.deleteIfExists(new File(getServerDirectory() + "server-icon.png").toPath());
            ImageIO.write(resizeImagePng, "png", new File(getServerDirectory() + "server-icon.png"));
        } catch (IOException ex) {
            int i = 0;
        }
        updateServerStatus();
        JOptionPane.showMessageDialog(null, "You have to restart sever to take effect");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void commandComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_commandComboBoxItemStateChanged
        Command command = simpleCommandMap.getCommand(evt.getItem().toString());
        String cmd = command.getUsage().split(" ")[0];
        jLabel1.setText(cmd);
        jLabel2.setText(command.getUsage().replace(cmd, ""));
    }//GEN-LAST:event_commandComboBoxItemStateChanged

    private void commandComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_commandComboBoxPopupMenuWillBecomeVisible
        initCommandBox();
    }//GEN-LAST:event_commandComboBoxPopupMenuWillBecomeVisible

    private void clearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearMenuItemActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
    }//GEN-LAST:event_clearMenuItemActionPerformed

    private void rainMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rainMenuItemActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather rain");
    }//GEN-LAST:event_rainMenuItemActionPerformed

    private void thunderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thunderMenuItemActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather thunder");
    }//GEN-LAST:event_thunderMenuItemActionPerformed

    private void dayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayMenuItemActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set day");
    }//GEN-LAST:event_dayMenuItemActionPerformed

    private void nightMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nightMenuItemActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set night");
    }//GEN-LAST:event_nightMenuItemActionPerformed

    private void commandTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commandTextFieldKeyReleased
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 13) {
            search();
        }
        commandTextField.setBackground(java.awt.SystemColor.controlLtHighlight);
    }//GEN-LAST:event_commandTextFieldKeyReleased

    private void commandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandButtonActionPerformed
        search();
    }//GEN-LAST:event_commandButtonActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule randomTickSpeed 1");
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule randomTickSpeed 3");
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule randomTickSpeed 100");
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem5ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule randomTickSpeed 1000");
    }//GEN-LAST:event_jRadioButtonMenuItem5ActionPerformed

    private void jRadioButtonMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem4ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule randomTickSpeed 10000");
    }//GEN-LAST:event_jRadioButtonMenuItem4ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode 0 @a");
        gamemodeButton.setIcon(jMenuItem4.getIcon());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode 1 @a");
        gamemodeButton.setIcon(jMenuItem5.getIcon());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode 2 @a");
        gamemodeButton.setIcon(jMenuItem6.getIcon());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty p");
        difficultyButton.setIcon(jMenuItem8.getIcon());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty e");
        difficultyButton.setIcon(jMenuItem9.getIcon());
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty n");
        difficultyButton.setIcon(jMenuItem10.getIcon());
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty h");
        difficultyButton.setIcon(jMenuItem11.getIcon());
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            openWebpage(new URL("https://www.paypal.me/Seydell/"));
        } catch (MalformedURLException ex) {
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void removeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuItemActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = opPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "deop " + offlinePlayer.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_removeMenuItemActionPerformed

    private void removeMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuItem1ActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = bannedPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pardon " + offlinePlayer.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_removeMenuItem1ActionPerformed

    private void removeMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuItem2ActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = whitePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist remove " + offlinePlayer.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_removeMenuItem2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist on");
        } else {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist off");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void addNameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameMenuItemActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = opPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            commandTextField.setText(commandTextField.getText() + " " + offlinePlayer.getName());
        }
    }//GEN-LAST:event_addNameMenuItemActionPerformed

    private void addNameMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameMenuItem1ActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = bannedPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            commandTextField.setText(commandTextField.getText() + " " + offlinePlayer.getName());
        }
    }//GEN-LAST:event_addNameMenuItem1ActionPerformed

    private void addNameMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameMenuItem2ActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = whitePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            commandTextField.setText(commandTextField.getText() + " " + offlinePlayer.getName());
        }
    }//GEN-LAST:event_addNameMenuItem2ActionPerformed

    private void addNameMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameMenuItem3ActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof Player) {
            player = (Player) result;
        }
        if (player != null) {
            if (commandTextField.getText().isEmpty()) {
                commandTextField.setText(player.getName());
            } else {
                commandTextField.setText(commandTextField.getText() + " " + player.getName());
            }
        }
    }//GEN-LAST:event_addNameMenuItem3ActionPerformed

    private void kickMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kickMenuItemActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "kick " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_kickMenuItemActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode 0 " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode 1 " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamemode 2 " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void serverNameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serverNameLabelMouseClicked
        updateServerStatus();
    }//GEN-LAST:event_serverNameLabelMouseClicked

    private void addBlackMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBlackMenuItemActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ban " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_addBlackMenuItemActionPerformed

    private void addWhiteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWhiteMenuItemActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_addWhiteMenuItemActionPerformed

    private void addOPMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOPMenuItemActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "op " + player.getName());
        }
        updateServerStatus();
    }//GEN-LAST:event_addOPMenuItemActionPerformed

    private void spawnMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spawnMenuItemActionPerformed
        Location location = Bukkit.getWorld(getProperty("level-name")).getSpawnLocation();
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + location.getX() + " " + location.getY() + " " + location.getZ());
        }
    }//GEN-LAST:event_spawnMenuItemActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        OfflinePlayer offlinePlayer = null;
        Object result = opPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            offlinePlayer = (OfflinePlayer) result;
        }
        if (offlinePlayer != null) {
            BufferedImage image = PlayerPictureCache.loadPlayerAvatar(offlinePlayer.getName());
            try {
                ImageIO.write(image, "png", new File(getServerDirectory() + "server-icon.png"));
            } catch (IOException ex) {
            }
        }
        updateServerStatus();
        JOptionPane.showMessageDialog(null, "You have to restart sever to take effect");

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void idCardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCardMenuItemActionPerformed
        OfflinePlayer player = null;
        Object result = opPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (OfflinePlayer) result;
        }
        if (player != null) {
            PlayerIdCardFrame playerIdCardFrame = new PlayerIdCardFrame();
            playerIdCardFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            playerIdCardFrame.setPlayer(player);
            playerIdCardFrame.setVisible(true);
        }
    }//GEN-LAST:event_idCardMenuItemActionPerformed

    private void idCardMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCardMenuItem1ActionPerformed
        OfflinePlayer player = null;
        Object result = bannedPlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (OfflinePlayer) result;
        }
        if (player != null) {
            PlayerIdCardFrame playerIdCardFrame = new PlayerIdCardFrame();
            playerIdCardFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            playerIdCardFrame.setPlayer(player);
            playerIdCardFrame.setVisible(true);
        }
    }//GEN-LAST:event_idCardMenuItem1ActionPerformed

    private void idCardMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCardMenuItem2ActionPerformed
        OfflinePlayer player = null;
        Object result = whitePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (OfflinePlayer) result;
        }
        if (player != null) {
            PlayerIdCardFrame playerIdCardFrame = new PlayerIdCardFrame();
            playerIdCardFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            playerIdCardFrame.setPlayer(player);
            playerIdCardFrame.setVisible(true);
        }
    }//GEN-LAST:event_idCardMenuItem2ActionPerformed

    private void idCardMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCardMenuItem3ActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof Player) {
            player = (Player) result;
        }
        if (player != null) {
            PlayerIdCardFrame playerIdCardFrame = new PlayerIdCardFrame();
            playerIdCardFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            playerIdCardFrame.setPlayer(player);
            playerIdCardFrame.setVisible(true);
        }
    }//GEN-LAST:event_idCardMenuItem3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        PropertyFrame propertyFrame = new PropertyFrame(this);
        propertyFrame.setPropertyFileName(getServerDirectory() + "server.properties");
        propertyFrame.setVisible(true);
        if (propertyFrame.getRetStatus() == PropertyFrame.RET_OK) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    updateServerStatus();
                    JOptionPane.showMessageDialog(null, "You have to restart sever to take effect");
                }
            });
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Player player = null;
        Object result = onlinePlayerList.getSelectedValue();
        if (result instanceof OfflinePlayer) {
            player = (Player) result;
        }
        if (player != null) {
            MaterialFrame materialFrame = new MaterialFrame(this);
            materialFrame.setVisible(true);
            if (materialFrame.getRetStatus() == PropertyFrame.RET_OK) {
                try {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " + player.getName() + " " + materialFrame.getSelectedMaterial() + " " + materialFrame.getNumberOfMaterials());
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addBlackMenuItem;
    private javax.swing.JMenuItem addNameMenuItem;
    private javax.swing.JMenuItem addNameMenuItem1;
    private javax.swing.JMenuItem addNameMenuItem2;
    private javax.swing.JMenuItem addNameMenuItem3;
    private javax.swing.JMenuItem addOPMenuItem;
    private javax.swing.JMenuItem addWhiteMenuItem;
    private javax.swing.JList<String> bannedPlayerList;
    private javax.swing.JPopupMenu bannedPlayerPopupMenu;
    private javax.swing.ButtonGroup buttonGroupTicks;
    private javax.swing.JMenuItem clearMenuItem;
    private javax.swing.JButton commandButton;
    private javax.swing.JComboBox<String> commandComboBox;
    private javax.swing.JTextField commandTextField;
    private javax.swing.JMenuItem dayMenuItem;
    private javax.swing.JToggleButton difficultyButton;
    private javax.swing.JPopupMenu difficultyPopupMenu;
    private javax.swing.JPopupMenu gameModePopupMenu;
    private javax.swing.JToggleButton gamemodeButton;
    private javax.swing.JMenuItem idCardMenuItem;
    private javax.swing.JMenuItem idCardMenuItem1;
    private javax.swing.JMenuItem idCardMenuItem2;
    private javax.swing.JMenuItem idCardMenuItem3;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JMenuItem kickMenuItem;
    private javax.swing.JLabel motdLabel;
    private javax.swing.JMenuItem nightMenuItem;
    private javax.swing.JLabel numberOfPlayersLabel;
    private javax.swing.JList<String> onlinePlayerList;
    private javax.swing.JPopupMenu onlinePlayerPopupMenu;
    private javax.swing.JList<String> opPlayerList;
    private javax.swing.JPopupMenu opPlayerPopupMenu;
    private javax.swing.JMenuItem rainMenuItem;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenuItem removeMenuItem1;
    private javax.swing.JMenuItem removeMenuItem2;
    private javax.swing.JLabel serverNameLabel;
    private javax.swing.JLabel serverTypeLabel;
    private javax.swing.JMenuItem spawnMenuItem;
    private javax.swing.JMenuItem thunderMenuItem;
    private javax.swing.JPopupMenu ticksPopupMenu;
    private javax.swing.JPopupMenu timePopupMenu;
    private javax.swing.JToggleButton weatherButton;
    private javax.swing.JPopupMenu weatherPopupMenu;
    private javax.swing.JList<String> whitePlayerList;
    private javax.swing.JPopupMenu whitePlayerPopupMenu;
    private javax.swing.JLabel worldLabel;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="event handling">
    public void addPlayer(Player player) {
        if (!playerList.contains(player)) {
            playerList.add(player);
        }
        updatePlayerList(playerList, onlinePlayerList);
    }

    public void removePlayer(Player player) {
        if (playerList.contains(player)) {
            playerList.remove(player);
        }
        updatePlayerList(playerList, onlinePlayerList);
    }

    public void setPlayers() {
        playerList = (List<Player>) getOnlinePlayers();
        updatePlayerList(playerList, onlinePlayerList);
    }

    private void updatePlayerList(Collection<Player> playerList, JList<String> onlinePlayerList) {
        onlinePlayerList.removeAll();
        onlinePlayerList.setCellRenderer(new PlayerListRenderer());
        onlinePlayerList.setModel(new DefaultComboBoxModel(playerList.toArray()));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                updateServerStatus();
            }
        });
    }

    void weatherChanged(int weatherMode) {
        switch (weatherMode) {
            case 0:
                weatherButton.setIcon(clearMenuItem.getIcon());
                break;
            case 1:
                weatherButton.setIcon(rainMenuItem.getIcon());
                break;
            case 2:
                weatherButton.setIcon(thunderMenuItem.getIcon());
                break;
            default:
                throw new AssertionError();
        }
        weatherButton.repaint();
        weatherButton.revalidate();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get server data">
    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(getServerDirectory() + "server.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException ex) {
            int i = 0;
        }
        return properties;
    }

    private String getProperty(String name) {
        return getProperties().get(name).toString();
    }

    private String getServerDirectory() {
        String pluginPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        File f = new File(pluginPath);
        String serverPath = f.getParentFile().getParent() + File.separator;
        return serverPath.replace("%20", " ");
    }
    //</editor-fold>

    private void updateServerStatus() {
        // server icon
        String serverIconPath = getServerDirectory() + "server-icon.png";
        File imageFile = new File(serverIconPath);
        if (Files.exists(imageFile.toPath())) {
            BufferedImage originalImage = null;
            try {
                originalImage = ImageIO.read(imageFile);
            } catch (IOException ex) {

            }
            if (originalImage != null) {
                jButton1.setIcon(new ImageIcon(originalImage));
            }
        }
        // server status
        numberOfPlayersLabel.setText(Bukkit.getOnlinePlayers().size() + " / " + Bukkit.getMaxPlayers());
        serverNameLabel.setText(Bukkit.getServerName());
        motdLabel.setText(Bukkit.getMotd());
        serverTypeLabel.setText(Bukkit.getName() + " version " + Bukkit.getVersion());
        worldLabel.setText(getProperty("level-name"));
        switch (Bukkit.getDefaultGameMode()) {
            case SURVIVAL:
                gamemodeButton.setIcon(jMenuItem4.getIcon());
                break;
            case CREATIVE:
                gamemodeButton.setIcon(jMenuItem5.getIcon());
                break;
            case ADVENTURE:
                gamemodeButton.setIcon(jMenuItem6.getIcon());
                break;
            default:
                break;
        }
        switch (getProperty("difficulty")) {
            case "0":
                difficultyButton.setIcon(jMenuItem8.getIcon());
                break;
            case "1":
                difficultyButton.setIcon(jMenuItem9.getIcon());
                break;
            case "2":
                difficultyButton.setIcon(jMenuItem10.getIcon());
                break;
            case "3":
                difficultyButton.setIcon(jMenuItem11.getIcon());
                break;
            default:
                break;
        }
        // OP list
        if (Bukkit.getOperators() != null && !Bukkit.getOperators().isEmpty()) {
            opPlayerList.removeAll();
            opPlayerList.setCellRenderer(new PlayerListRenderer());
            opPlayerList.setModel(new DefaultComboBoxModel(Bukkit.getServer().getOperators().toArray()));
        }
        // Banned list
        if (Bukkit.getBannedPlayers() != null && !Bukkit.getBannedPlayers().isEmpty()) {
            bannedPlayerList.removeAll();
            bannedPlayerList.setCellRenderer(new PlayerListRenderer());
            bannedPlayerList.setModel(new DefaultComboBoxModel(Bukkit.getServer().getBannedPlayers().toArray()));
        }
        // White list
        if (Bukkit.getWhitelistedPlayers() != null && !Bukkit.getWhitelistedPlayers().isEmpty()) {
            whitePlayerList.removeAll();
            whitePlayerList.setCellRenderer(new PlayerListRenderer());
            whitePlayerList.setModel(new DefaultComboBoxModel(Bukkit.getServer().getWhitelistedPlayers().toArray()));
        }
        jCheckBox1.setSelected(Bukkit.hasWhitelist());
    }

    private void search() {
        commandButton.requestFocus();
        Command command = simpleCommandMap.getCommand(commandComboBox.getSelectedItem().toString());
        boolean success = Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command.getName() + " " + commandTextField.getText());
        if (!success) {
            commandTextField.setBackground(Color.red);
        } else {
            commandTextField.setText("");
        }
    }

    //<editor-fold defaultstate="collapsed" desc="little helper">
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setFileFilter(new FileNameExtensionFilter("png Image File", "png"));
        fc.setFileFilter(new FileNameExtensionFilter("jpg Image File", "jpg"));
        fc.setCurrentDirectory(new File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()));
        fc.setMultiSelectionEnabled(false);
        if (fc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        }
        return null;
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(64, 64, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 64, 64, null);
        g.dispose();

        return resizedImage;
    }
    //</editor-fold>

}
