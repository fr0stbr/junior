package warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import api.KitAPI;
import net.barbutti.pvp.Main;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("spawn.tel")) {
				if (args.length == 0) {
					p.getInventory().clear();
					p.setHealth(20);
					p.setFireTicks(0);
					p.sendMessage("§2§lWARP §aVocê teleportou até o §f§nspawn!");
					Main.Hotbar(p);
					if (KitAPI.getKit(p) != "Nenhum") {
						KitAPI.RemoveKits(p);
					}
				} else if (args.length == 1) {
					p.sendMessage("§4§lWARP §cUtilize /spawn");
				}
			} else {
				p.sendMessage("" + Main.SemPerm);
			}
		}
		
		return false;
	}

}
