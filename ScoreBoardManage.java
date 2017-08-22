/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoreboardmanage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoardManage extends JavaPlugin implements Listener {
public static Plugin plugin;
    public void onEnable() {
            plugin = this;
              
                saveDefaultConfig();
                
		if (getServer().getPluginManager().isPluginEnabled("PermissionsEx")){

		} else {
                        getServer().getLogger().info("前提プラグインが不足しています。");
                        getServer().getLogger().info("前提プラグインはPermissionEXです。");
			getServer().getPluginManager().disablePlugin(this);
		}
            getServer().getPluginManager().registerEvents((Listener) new Core(), (Plugin)this);  
            getServer().getPluginManager().registerEvents(this, this);
	    	}
	public void onDisable(){
        }
@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {

		
		final Player p = e.getPlayer();

		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(ScoreBoardManage.plugin, new Runnable() {
			public void run() {
				
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				final Scoreboard board = manager.getNewScoreboard();
				final Objective objective = board.registerNewObjective("test", "dummy");
				
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("ScoreBoardName").replaceAll("%player%", e.getPlayer().getName())));
                                String message = plugin.getConfig().getString("10");
				Score score = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("10").replaceAll("%player%", e.getPlayer().getName())));
				score.setScore(10);
                                
                                Score score1 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("9").replaceAll("%player%", e.getPlayer().getName())));
				score1.setScore(9);
			        
				Score score3 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("8").replaceAll("%player%", e.getPlayer().getName())));
				score3.setScore(8);
				
                                Score score4 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("7").replaceAll("%player%%", e.getPlayer().getName())));
				score4.setScore(7);
                                
                                Score score5 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("6").replaceAll("%player%", e.getPlayer().getName())));
				score5.setScore(6);
                                
                                Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("5").replaceAll("%player%", e.getPlayer().getName())));
				score6.setScore(5);
			
				Score score7 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("4").replaceAll("%player%", e.getPlayer().getName())));
				score7.setScore(4);
				
                                Score score8 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("3").replaceAll("%player%", e.getPlayer().getName())));
				score8.setScore(3);
                                
				Score score9 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("2").replaceAll("%player%", e.getPlayer().getName())));
				score9.setScore(2);
				
                                Score score10 = objective.getScore(ChatColor.translateAlternateColorCodes('&', getConfig().getString("1").replaceAll("%player%", e.getPlayer().getName())));
				score10.setScore(1);                                
                                
				p.setScoreboard(board);

			}
		},0, 20 * 10);
		
	}
}