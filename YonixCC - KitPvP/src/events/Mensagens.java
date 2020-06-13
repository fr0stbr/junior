package events;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import net.barbutti.pvp.Main;

public class Mensagens implements Listener {
	
	public static void AutoMensagem() {
		final String[] Mensagens = {
				"§5§lYonix§f§lCC §7» §bEntre no discord do nosso servidor!",
				"§5§lYonix§f§lCC §7» §bCompre §6[VIP] §bpara manter o servidor online!",
				"§5§lYonix§f§lCC §7» §bEstamos com vaga na staff, digite /aplicar"
		};
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				Bukkit.broadcastMessage(Arrays.asList(Mensagens).get(new Random().nextInt(Mensagens.length)));
			}
		}, 0, 2*20*60);
	}

}
