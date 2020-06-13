package gui;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LojaGUI implements Listener {
	
	@EventHandler
	public void clicarDiamante(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.DIAMOND) {
			p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1, 1);
			p.sendMessage("ß4ßlINDISPONÌVEL ßcEm breve!");
			e.setCancelled(true);
		}
	}

}
