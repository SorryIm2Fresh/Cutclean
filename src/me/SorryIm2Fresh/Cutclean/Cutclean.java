package me.SorryIm2Fresh.Cutclean;

import java.util.logging.Logger;
import me.SorryIm2Fresh.Cutclean.Listeners.CutcleanListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Cutclean
  extends JavaPlugin
{
  private final Logger logger = Logger.getLogger("Minecraft");
  public static Cutclean plugin;
  
  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " has been disabled.");
            getLogger().info(ChatColor.BLUE + "Cutclean has been disabled, ores will no longer auto smelt!");
                   for (Player p : Bukkit.getOnlinePlayers()) {
        	  if (p.hasPermission("cutclean.staff")) {
        		  p.sendMessage(Messages.STAFF + ChatColor.DARK_RED + ChatColor.BOLD + "WARNING!" + ChatColor.GRAY + " Cutclean has been disabled, ores will no longer auto smelt! Please alert a server administratora about this problem!");
        	    }
           } 
  }
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " has been enabled.");
    
    plugin = this;
    Bukkit.getServer().getPluginManager().registerEvents(new CutcleanListener(), this);
  }
}
