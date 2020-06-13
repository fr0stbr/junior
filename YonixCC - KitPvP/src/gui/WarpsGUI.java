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

import api.KitAPI;

public class WarpsGUI implements Listener {

	Inventory warps = Bukkit.createInventory(null, 3 * 9, "§7Warps");

	@EventHandler
	public void clicarBússola(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		ItemStack fps = new ItemStack(Material.GLASS);
		ItemMeta fpsm = fps.getItemMeta();
		fpsm.setDisplayName("§6FPS");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§7Uma warp boa para PvP! Se você quiser mais FPS é claro :)");
		fps.setItemMeta(fpsm);
		fpsm.setLore(lore);
		
		ItemStack x1 = new ItemStack(Material.BLAZE_ROD);
		ItemMeta x1m = x1.getItemMeta();
		x1m.setDisplayName("§61v1");
		ArrayList<String> lore0 = new ArrayList<>();
		lore0.add("§7Tire 1v1 sem ninguém te atrapalhar!");
		x1.setItemMeta(x1m);
		x1m.setLore(lore0);
		
		ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta lavam = lava.getItemMeta();
		lavam.setDisplayName("§6LC");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§7Treine seu refil e recraft!");
		lava.setItemMeta(lavam);
		lavam.setLore(lore1);

		warps.setItem(10, fps);
		warps.setItem(11, x1);
		warps.setItem(12, lava);

		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.COMPASS) {
			p.openInventory(warps);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void clicarInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		ItemStack sopas = new ItemStack (Material.MUSHROOM_SOUP);
		ItemMeta sopasm = sopas.getItemMeta();
		sopasm.setDisplayName("§eSopa");
		sopas.setItemMeta(sopasm);
		

		if (e.getInventory().getName().equalsIgnoreCase("§7Warps")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				e.setCancelled(true);
				p.chat("/warp fps");
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.chat("/warp 1v1");
			}
			if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				e.setCancelled(true);
				p.chat("/warp lava");
			}
		}
	}

}
