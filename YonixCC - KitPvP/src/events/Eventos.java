package events;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import api.KitAPI;
import net.barbutti.pvp.Main;

public class Eventos implements Listener {
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.getInventory().clear();
		
		Main.Hotbar(p);
	}
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		if (KitAPI.getKit(p) != "Nenhum") {
			KitAPI.RemoveKits(p);
		}
	}
	
	@EventHandler
	public void quebrarBloco(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("break.bloco")) {
			e.setCancelled(false);
		} else {
			p.sendMessage("" + Main.SemPerm);
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void comFome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void respawnEvent(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		Main.Hotbar(p);
		if (KitAPI.getKit(p) != "Nenhum") {
			KitAPI.RemoveKits(p);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void durability(EntityDamageByEntityEvent e) {
		if (e.isCancelled()) {
			return;
		}
		if ((e.getDamager() instanceof Player)) {
			if (e.isCancelled()) {
				return;
			}
			Player p = (Player) e.getDamager();
			if ((p.getItemInHand().getType() == Material.STONE_AXE)) {
				p.getItemInHand().setDurability((short) 0);
				p.updateInventory();
			} else if ((p.getItemInHand().getType() == Material.STONE_SWORD)) {
				p.getItemInHand().setDurability((short) 0);
				p.updateInventory();
			}
		}
	}
	
	@EventHandler
	public void antiLag(ItemSpawnEvent e) {
		new BukkitRunnable() {
            public void run() {
                e.getEntity().remove();
                e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.POTION_SWIRL, 7);

            }
        }.runTaskLater(Main.getPlugin(), 220L);
	}
	
	@SuppressWarnings("deprecation")
	
	public int vida = 6, fome = 6;
	
	@EventHandler
	public void usarSopa(PlayerInteractEvent e) {
		if (e.getItem() == null) {
			return;
		}
		if (e.getItem().getType() == Material.MUSHROOM_SOUP) {
			Player p = e.getPlayer();
			Damageable dam = (Damageable) p;
			
			e.setCancelled(true);
			if (dam.getHealth() < 20) {
				p.setHealth(dam.getHealth() + vida >= 20 ? 20 : dam.getHealth() + vida);
				e.getItem().setType(Material.BOWL);
			}
			if (p.getFoodLevel() < 20) {
				p.setFoodLevel(p.getFoodLevel() + fome >= 20 ? 20 : p.getFoodLevel() + fome);
				e.getItem().setType(Material.BOWL);
			}
		}
	}
	
	@EventHandler
	public void aoDrop(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.CHEST) {
			e.setCancelled(true);
		} else if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
			e.setCancelled(true);
		} else if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND) {
			e.setCancelled(true);
		} else if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
			e.setCancelled(true);
		} else if (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE) {
			e.setCancelled(true);
		}
	}

}
