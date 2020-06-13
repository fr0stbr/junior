package cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Aplicar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
	
				if (args.length == 0) {
					p.sendMessage("§e§l[APLICAR]");
					p.sendMessage(" ");
					p.sendMessage("§d§lTRIAL §f- §etrialmod.com");
					p.sendMessage("§5§lMOD §f- §emodgc.com");
				}
			
			
		}
		
		
		return false;
	}

}
