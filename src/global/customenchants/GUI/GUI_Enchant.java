package global.customenchants.GUI;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import global.customenchants.Utils.AlternateCodes;
import global.customenchants.Utils.ItemCreator;
import global.customenchants.Utils.UtilsEnchantment;

public class GUI_Enchant implements Listener {

	public static void sendGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, AlternateCodes.format("&dEnchanter"));
		ItemCreator.setItem(Material.BOOKSHELF, "&eEnchantments", "&7Click to see all the Enchantments.", 0, 1, inv, 22);
		ItemCreator.setItem(Material.ANVIL, "&7Anvil", "&7Click to open the anvil", 0, 1, inv, 23);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "&aCommon", "&aCost&7: &e20 Levels", 5, 1, inv, 30);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "&bEpic", "&aCost&7: &e30 Levels", 3, 1, inv, 31);
		ItemCreator.setItem(Material.STAINED_GLASS_PANE, "&5Legendary", "&aCost&7: &e40 Levels", 10, 1, inv, 32);
		
		for(int slots = 21; slots >= 0; --slots) {
			ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, slots);
		}
		
		for(int slots = 24; slots <= 29; ++slots) {
			ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, slots);
		}
		for(int slots = 33; slots <= 53; ++slots) {
			ItemCreator.setItem(Material.STAINED_GLASS_PANE, "", "", 15, 1, inv, slots);
		}
		p.openInventory(inv);
	}
	
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			if(e.getClickedInventory() != null) {
			if(e.getClickedInventory().getName() != null) {
				if(e.getClickedInventory() != e.getWhoClicked().getInventory()) {
					Player p = (Player) e.getWhoClicked();
					if(e.getClickedInventory().getName().equalsIgnoreCase(AlternateCodes.format("&dEnchanter"))) {
						if(e.getCurrentItem().getType() == Material.BOOKSHELF) {
							e.setCancelled(true);
							GUI_Enchantments.sendGUI(p);
						} else if(e.getCurrentItem().getType() == Material.ANVIL) {
							e.setCancelled(true);
							GUI_Anvil.sendGUI(p);
						} else if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
							if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(AlternateCodes.format("&aCommon"))) {
								if(p.getGameMode() != GameMode.CREATIVE) {
								if(p.getLevel() >= 19) { 
									UtilsEnchantment enchantment = new UtilsEnchantment();
									enchantment.sendCommonEnchantment(p);
									p.setLevel(p.getLevel() - 20);
									e.setCancelled(true);
								} else {
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(AlternateCodes.format("&cYou don't have enough to levels to enchant."));
								}
								} else {
									UtilsEnchantment enchantment = new UtilsEnchantment();
									enchantment.sendCommonEnchantment(p);
									e.setCancelled(true);
								}
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(AlternateCodes.format("&bEpic"))) {
								if(p.getGameMode() != GameMode.CREATIVE) {
								if(p.getLevel() >= 29) { 
									UtilsEnchantment enchantment = new UtilsEnchantment();
									enchantment.sendEpicEnchantment(p);
									p.setLevel(p.getLevel() - 30);
									e.setCancelled(true);
								} else {
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(AlternateCodes.format("&cYou don't have enough to levels to enchant."));
								}
								} else {
									UtilsEnchantment enchantment = new UtilsEnchantment();
									enchantment.sendEpicEnchantment(p);
									e.setCancelled(true);
								}
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(AlternateCodes.format("&5Legendary"))) {
								if(p.getGameMode() != GameMode.CREATIVE) {
								if(p.getLevel() >= 39) { 
									UtilsEnchantment enchantment = new UtilsEnchantment();
									enchantment.sendLegendaryEnchantment(p);
									p.setLevel(p.getLevel() - 40);
									e.setCancelled(true);
								} else {
									e.setCancelled(true);
									p.closeInventory();
									p.sendMessage(AlternateCodes.format("&cYou don't have enough to levels to enchant."));
								}
								} else {
									UtilsEnchantment enchantment = new UtilsEnchantment();
									enchantment.sendLegendaryEnchantment(p);
									e.setCancelled(true);
								}
							}
							} else {
								e.setCancelled(true);
							}
						}
					}
				}
				}
			}
		}
 	}
}
