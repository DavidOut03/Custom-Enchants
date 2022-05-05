package global.customenchants.Utils;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.ItemMeta.Spigot;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class ItemCreator {

	public static void setItem(Material mat, String displayname, String lore, int id, int amount, Inventory inv, int slot) {
		
		ItemStack item = new ItemStack(mat, amount, (short) id);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(AlternateCodes.format(displayname));
		ArrayList<String> itemlore = new ArrayList<String>();
		itemlore.add(AlternateCodes.format(lore));
		im.setLore(itemlore);
		item.setItemMeta(im);
		inv.setItem(slot, item);
	}
	
    public static void addItem(Material mat, String displayname, String lore, int id, int amount, Inventory inv) {
		
		ItemStack item = new ItemStack(mat, amount, (short) id);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(AlternateCodes.format(displayname));
		ArrayList<String> itemlore = new ArrayList<String>();
		itemlore.add(AlternateCodes.format(lore));
		im.setLore(itemlore);
		item.setItemMeta(im);
		inv.addItem(item);
	}
    
    public static ItemStack addEnchantment(ItemStack item, Enchantment enchantment, int level){
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
        meta.addStoredEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

}
