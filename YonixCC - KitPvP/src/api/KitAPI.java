package api;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class KitAPI {
	
	public static HashMap<Player, String> Kit = new HashMap<>();

	public static void setKit(Player player, String kit) {
	        Kit.put(player, kit);
	    }

	    public static String getKit(Player player) {
	        if (Kit.containsKey(player)) {
	            return Kit.get(player);
	        } else {
	            return "Nenhum";
	        }
	    }

	        public static void RemoveKits(Player player) {
	        Kit.remove(player);
	    }

}
