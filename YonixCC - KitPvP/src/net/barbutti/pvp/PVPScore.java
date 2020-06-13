package net.barbutti.pvp;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import api.KitAPI;

public class PVPScore implements Listener {
	@EventHandler
	public void joinServer(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		ScoreboardManager scoreboardManager = Main.getPlugin().getServer().getScoreboardManager();
		Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("barbutti", "dev");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("§5§lYonix§f§lCC");
		objective.getScore("§f").setScore(13);
		Team kills = scoreboard.registerNewTeam("kills");
		kills.addEntry(" §fKills: ");
		kills.setSuffix("");
		kills.setPrefix("");
		objective.getScore(" §fKills: ").setScore(12);
		objective.getScore(" ").setScore(11);
		Team deaths = scoreboard.registerNewTeam("deaths");
		deaths.addEntry(" §fDeaths: ");
		deaths.setSuffix("");
		deaths.setPrefix("");
		objective.getScore(" §fDeaths: ").setScore(10);
		objective.getScore(" ").setScore(9);
		Team killstreak = scoreboard.registerNewTeam("killstreak");
		killstreak.addEntry(" §fKillstreak: ");
		killstreak.setSuffix("");
		killstreak.setPrefix("");
		objective.getScore(" §fKillstreak: ").setScore(8);
		objective.getScore("§e").setScore(7);
		Team kits = scoreboard.registerNewTeam("kits");
		kits.addEntry(" §fKit: ");
		kits.setSuffix("");
		kits.setPrefix("");
		objective.getScore(" §fKit: ").setScore(6);
		objective.getScore("§b").setScore(5);
		Team coins = scoreboard.registerNewTeam("coins");
		coins.addEntry(" §fCoins: ");
		coins.setSuffix("");
		coins.setPrefix("");
		objective.getScore(" §fCoins: ").setScore(4);
		objective.getScore(" ").setScore(3);
		Team xp = scoreboard.registerNewTeam("xp");
		xp.addEntry(" §fXP: ");
		xp.setSuffix("");
		xp.setPrefix("");
		objective.getScore(" §fXP: ").setScore(2);
		objective.getScore(" ").setScore(1);
		objective.getScore("     §7Yonix.CC ").setScore(0);
		

		new BukkitRunnable() {

			@Override
			public void run() {
				kits.setSuffix("§7" + KitAPI.getKit(p));
				kills.setSuffix("§7" +p.getStatistic(Statistic.PLAYER_KILLS));
				deaths.setSuffix("§7" +p.getStatistic(Statistic.DEATHS));
				killstreak.setSuffix("§70");
				coins.setSuffix("§2$ §a0");
				xp.setSuffix("§60");
			}
		}.runTaskTimer(Main.getPlugin(), 0, 10);

		p.setScoreboard(scoreboard);
	}
}
