package warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.barbutti.pvp.Main;

public class WarpComando implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (args.length == 0) {
				p.sendMessage("§4§lWARP §cUtilize /warp (warp)");
				return true;
			}

			String command = args[0];

			// WarpSET
			if (command.equalsIgnoreCase("set")) {
				// warp set $warp
			} else if (command.equalsIgnoreCase("del")
					| command.equalsIgnoreCase("delete")
					| command.equalsIgnoreCase("remove")) {

			} else if (command.equalsIgnoreCase("lista")) {
				
			} else {
				String name = command;
				if (Main.getWarp().containsKey(name)) {
					
					Warp warp = Main.getWarp().get(name);
					p.teleport(warp.getLocation());
					p.sendMessage(Main.message("WarpTELEPORT").replace("<warp>", name));
					
				} else {
					p.sendMessage(Main.message("WarpINVALIDA").replace("<warp>", name));
				}
			}
			if (args.length == 1) {
				p.sendMessage("§4§lWARP §cUtilize /warp set (warp)");
			} else {
				String name = args[1];
				Warp warp = new Warp(name, p.getLocation());
				Main.getWarp().put(name.toLowerCase(), warp);

				p.sendMessage(Main.message("WarpSET").replace("<warp>", name));
			}

			// WARP <WARP>

			// WarpDEL

			// WarpLIST

			// Warps|SetWarp|DelWarp
		}
		return false;
	}

}
