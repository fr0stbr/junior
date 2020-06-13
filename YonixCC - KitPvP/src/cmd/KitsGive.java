package cmd;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import api.KitAPI;
import net.barbutti.pvp.Main;

public class KitsGive implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			ItemStack kitpvp = new ItemStack(Material.STONE_SWORD);
			ItemMeta kitpvpm = kitpvp.getItemMeta();
			kitpvpm.setDisplayName("§6Espada");
			kitpvp.setItemMeta(kitpvpm);
			
			ItemStack viking = new ItemStack(Material.STONE_AXE);
			ItemMeta vikingm = viking.getItemMeta();
			vikingm.setDisplayName("§6Viking");
			vikingm.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
			viking.setItemMeta(vikingm);
			
			ItemStack sopas = new ItemStack (Material.MUSHROOM_SOUP);
			ItemMeta sopasm = sopas.getItemMeta();
			sopasm.setDisplayName("§eSopa");
			sopas.setItemMeta(sopasm);
			
			if (p.hasPermission("ver.kits")) {
				if (args.length == 0) {
					p.sendMessage("§4§lKIT §cUtilize o comando /kit §e(kit)§c!");
				}
				if (p.hasPermission("kit.pvp")) {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("pvp")) {
							p.getInventory().clear();
							p.getInventory().setItem(0, kitpvp);
							for (int i = 0; i < 54; i++) {
								p.getInventory().addItem(sopas);
							}
							KitAPI.setKit(p, "PvP");
						}
					}
				} else {
					p.sendMessage("" + Main.SemPerm);
				}
			} else {
				p.sendMessage("" + Main.SemPerm);
			}
			
			if (p.hasPermission("kit.viking")) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("viking")) {
						p.getInventory().clear();
						p.getInventory().setItem(0, viking);
						for (int i = 0; i < 54; i++) {
							p.getInventory().addItem(sopas);
						}
						KitAPI.setKit(p, "Viking");
					}
				}
			} else {
				p.sendMessage("" + Main.SemPerm);
			}
		} 
		
		return false;
	}

}
