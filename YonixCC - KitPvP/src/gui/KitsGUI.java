package gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsGUI implements Listener {
	
	Inventory bau = Bukkit.createInventory(null, 9 * 6, "§7Seus Kits §c[2/2]");
	
	@EventHandler
	public void clicarBau(PlayerInteractEvent e) {
		
		ItemStack pvp = new ItemStack(Material.STONE_SWORD);
		ItemMeta pvpm = pvp.getItemMeta();
		pvpm.setDisplayName("§6Kit PvP");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(" ");
		lore.add("§bUm kit básico para matança!");
		lore.add(" ");
		lore.add("§eClique para selecionar!");
		pvpm.setLore(lore);
		pvp.setItemMeta(pvpm);
		
		ItemStack viking = new ItemStack(Material.STONE_AXE);
		ItemMeta vikingm = viking.getItemMeta();
		vikingm.setDisplayName("§6Viking");
		ArrayList<String> lore0 = new ArrayList<>();
		lore0.add(" ");
		lore0.add("§bMachado com habilidades de até sharp 3!");
		lore0.add(" ");
		lore0.add("§eClique para selecionar!");
		vikingm.setLore(lore0);
		viking.setItemMeta(vikingm);
		
		bau.setItem(10, pvp);
		bau.setItem(11, viking);
		
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.CHEST) {
			p.openInventory(bau);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void clicarInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getInventory().getName().equalsIgnoreCase("§7Seus Kits §c[2/2]")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				p.chat("/kit pvp");
				p.playSound(p.getLocation(), Sound.SHOOT_ARROW, 1, 1);
				p.closeInventory();
				p.sendMessage("§4§lKIT §cVocê selecionou o kit §6PvP§c!");
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				p.chat("/kit viking");
				p.playSound(p.getLocation(), Sound.SHOOT_ARROW, 1, 1);
				p.closeInventory();
				p.sendMessage("§4§lKIT §cVocê selecionou o kit §6Viking§c!");
				e.setCancelled(true);
				return;
			}
		}
	}

}






