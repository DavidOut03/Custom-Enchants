package global.customenchants.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import global.customenchants.Utils.AlternateCodes;
import global.customenchants.Utils.ItemCreator;
import net.md_5.bungee.api.ChatColor;

public class GUI_Anvil implements Listener {

	public static void sendGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 45, AlternateCodes.format("&8CustomEnchant Anvil"));
		
		for(int slot = 0; slot <= 17; slot++) {
			ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, slot);
		}
		
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, 18);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, 19);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "&6New Item", "&7Put here the item you want to keep.", 1, 1, inv, 20);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, 21);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "&6Old Item", "&7Put here the item you want to transfer the enchantments from.", 1, 1, inv, 22);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, 23);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, 24);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "&aNew Item", "&7The new item comes here.", 13, 1, inv, 25);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, 26);
		
		for(int slot = 27; slot <= 44; slot++) {
			ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, slot);
		}
		
		
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void close(InventoryCloseEvent e) {
		
		if(e.getInventory() != null) {
			if(e.getInventory() != e.getPlayer().getInventory()) {
				if(e.getInventory().getName().equalsIgnoreCase(AlternateCodes.format("&8CustomEnchant Anvil"))) {
					if(e.getInventory().getItem(20) != null || e.getInventory().getItem(20).getType() != Material.STAINED_GLASS_PANE) {
						e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), e.getInventory().getItem(20));
					}
					if(e.getInventory().getItem(22) != null || e.getInventory().getItem(22).getType() != Material.STAINED_GLASS_PANE) {
						e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), e.getInventory().getItem(22));
					}
 				}
			}
		}
	}
	
	@EventHandler
	public void click(InventoryClickEvent e) {
		
		
		
		if(e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			p.sendMessage(ChatColor.RED + "" + e.getSlot() + " " + e.getCurrentItem().getTypeId());
			if(e.getClickedInventory().getName() != null) {
				if(e.getClickedInventory().getName().equalsIgnoreCase(AlternateCodes.format("&8CustomEnchant Anvil"))) {
					if(e.getCurrentItem().isSimilar(new ItemStack(Material.STAINED_GLASS_PANE, (short) 15))) {
						e.setCancelled(true);
					} else if(e.getCurrentItem().isSimilar(new ItemStack(Material.STAINED_GLASS_PANE, (short) 1))) {
						e.setCancelled(true);
						e.setCurrentItem(e.getCursor());
					}
				}
			} 
		}
	}
}
