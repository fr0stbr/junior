package net.barbutti.pvp;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cmd.Aplicar;
import cmd.KitsGive;
import events.Eventos;
import events.Mensagens;
import gui.KitsGUI;
import gui.LojaGUI;
import gui.WarpsGUI;
import warps.Configs;
import warps.Spawn;
import warps.Warp;
import warps.WarpComando;
import warps.WarpListener;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	private static Map<String, Warp> warps = new HashMap<>();
	private static FileConfiguration messages;
	
	public static Map<String, Warp> getWarp() {
		return warps;
	}
	public static Collection<Warp> getWarps() {
		return warps.values();
	}
	public static String message (String path) {
		return ChatColor.translateAlternateColorCodes('&', messages.getString(path));
	}
	public static String SemPerm = "§4§lPERM §cVocê não possui permissão!";
	
	private static Main main;

	public void onEnable() {
		main = this;
		plugin = this;
		saveResource("messages.yml", false);
		messages = YamlConfiguration.loadConfiguration(new File (plugin.getDataFolder(),"messages.yml"));
		Bukkit.getConsoleSender().sendMessage("§6[!] §5Yonix§fCC §e- §5KitPvP §ffoi habilitado!");
		Mensagens.AutoMensagem();
		Comandos();
		Eventos();
	}
	
	public static void setWarp(String name, Location location) {
		Configs config = new Configs(plugin,"warp/" + name.toLowerCase() + ".yml");
		config.getConfig().set("name", name);
		config.getConfig().set("world", location.getWorld().getName());
		config.getConfig().set("x", location.getX());
		config.getConfig().set("y", location.getY());
		config.getConfig().set("z", location.getZ());
		config.getConfig().set("yaw", location.getYaw());
		config.getConfig().set("pitch", location.getPitch());
		config.saveConfig();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§6[!] §5Yonix§fCC §e- §5KitPvP §ffoi desabilitado!");
	}
	
	public void Comandos() {
		getCommand("kit").setExecutor(new KitsGive());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("aplicar").setExecutor(new Aplicar());
		getCommand("warp").setExecutor(new WarpComando());
	}
	
	public void Eventos() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Eventos(), this);
		pm.registerEvents(new PVPScore(), this);
		pm.registerEvents(new KitsGUI(), this);
		pm.registerEvents(new LojaGUI(), this);
		pm.registerEvents(new WarpsGUI(), this);
		pm.registerEvents(new Mensagens(), this);
		pm.registerEvents(new WarpListener(), this);
	}
	
	public static void Hotbar(Player p) {
		
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§eKits §7(Clique)");
		kits.setItemMeta(kitsm);
		
		ItemStack warps = new ItemStack(Material.COMPASS);
		ItemMeta warpsm = warps.getItemMeta();
		warpsm.setDisplayName("§cWarps §7(Clique)");
		warps.setItemMeta(warpsm);
		
		ItemStack loja = new ItemStack(Material.DIAMOND);
		ItemMeta lojam = loja.getItemMeta();
		lojam.setDisplayName("§bLoja §7(Clique)");
		loja.setItemMeta(lojam);
		
		p.getInventory().setItem(1, warps);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(7, loja);
	}

	public static Main getPlugin() {
		return main;
	}

}










