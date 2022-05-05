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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import global.customenchants.Enchantments.Enchantment_AutoSmelt;
import global.customenchants.Enchantments.Enchantment_Explosive;
import global.customenchants.Enchantments.Enchantment_FastBow;
import global.customenchants.Enchantments.Enchantment_FireResistance;
import global.customenchants.Enchantments.Enchantment_Fullbright;
import global.customenchants.Enchantments.Enchantment_JellyLegs;
import global.customenchants.Enchantments.Enchantment_Lumberjack;
import global.customenchants.Enchantments.Enchantment_Multiblock;
import global.customenchants.Enchantments.Enchantment_RandomOre;
import global.customenchants.Enchantments.Enchantment_Speed;
import global.customenchants.Enchantments.Enchantment_Telepathy;
import global.customenchants.Utils.AlternateCodes;

public class GUI_Enchantments implements Listener {

	 Enchantment ench1 = new Enchantment_Multiblock(101);
	 Enchantment ench2 = new Enchantment_AutoSmelt(102);
	 Enchantment ench3 = new Enchantment_JellyLegs(103);
	 Enchantment ench4 = new Enchantment_FireResistance(104);
	 Enchantment ench5 = new Enchantment_Speed(105);
	 Enchantment ench6 = new Enchantment_FastBow(106);
	 Enchantment ench7 = new Enchantment_Explosive(107);
	 Enchantment ench8 = new Enchantment_RandomOre(108);
	 Enchantment ench9 = new Enchantment_Telepathy(109);
	 Enchantment ench10 = new Enchantment_Lumberjack(110);
	 Enchantment ench11 = new Enchantment_Fullbright(111);
	
	
	public static void sendGUI(Player p) {

		 Enchantment ench1 = new Enchantment_Multiblock(101);
		 Enchantment ench2 = new Enchantment_AutoSmelt(102);
		 Enchantment ench3 = new Enchantment_JellyLegs(103);
		 Enchantment ench4 = new Enchantment_FireResistance(104);
		 Enchantment ench5 = new Enchantment_Speed(105);
		 Enchantment ench6 = new Enchantment_FastBow(106);
		 Enchantment ench7 = new Enchantment_Explosive(107);
		 Enchantment ench8 = new Enchantment_RandomOre(108);
		 Enchantment ench9 = new Enchantment_Telepathy(109);
		 Enchantment ench10 = new Enchantment_Lumberjack(110);
		 Enchantment ench11 = new Enchantment_Fullbright(111);
		
		Inventory inv = Bukkit.createInventory(null, 18, AlternateCodes.format("&eEnchantments"));	
		
		ArrayList<String> multiblock = new ArrayList<String>();
		multiblock.add(AlternateCodes.format("&7When youre mining you mine a 3x3 cube."));
		multiblock.add(AlternateCodes.format(""));
		multiblock.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		multiblock.add(AlternateCodes.format("&7Can be found in:"));
		multiblock.add(AlternateCodes.format("&7- &5Legendary"));
		createEnchantment(inv, "&6" + ench1.getName(), multiblock);
		
		ArrayList<String> lumberjack = new ArrayList<String>();
		lumberjack.add(AlternateCodes.format("&7Cut a hole tree in one time."));
		lumberjack.add(AlternateCodes.format(""));
		lumberjack.add(AlternateCodes.format("&7Enchantable items: &dAxes"));
		lumberjack.add(AlternateCodes.format("&7Can be found in:"));
		lumberjack.add(AlternateCodes.format("&7- &bEpic"));
		createEnchantment(inv, "&6" + ench10.getName(), lumberjack);
		
		ArrayList<String> autosmelt = new ArrayList<String>();
		autosmelt.add(AlternateCodes.format("&7When you mine iron or gold ore it smelts the ores."));
		autosmelt.add(AlternateCodes.format(""));
		autosmelt.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		autosmelt.add(AlternateCodes.format("&7Can be found in:"));
		autosmelt.add(AlternateCodes.format("&7- &aCommon"));
		createEnchantment(inv, "&6" + ench2.getName(), autosmelt);
		
		ArrayList<String> jellylegs = new ArrayList<String>();
		jellylegs.add(AlternateCodes.format("&7When you have fall-damage it will be drecreased.."));
		jellylegs.add(AlternateCodes.format(""));
		jellylegs.add(AlternateCodes.format("&7Enchantable items: &dLeggings"));
		jellylegs.add(AlternateCodes.format("&7Can be found in:"));
		jellylegs.add(AlternateCodes.format("&7- &aCommon"));
		jellylegs.add(AlternateCodes.format("&7- &bEpic"));
		jellylegs.add(AlternateCodes.format("&7- &5Legendary"));
		createEnchantment(inv, "&6" + ench3.getName(), jellylegs);
		
		ArrayList<String> fastbow = new ArrayList<String>();
		fastbow.add(AlternateCodes.format("&7When you Right-Click you shoot arrows."));
		fastbow.add(AlternateCodes.format(""));
		fastbow.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		fastbow.add(AlternateCodes.format("&7Can be found in:"));
		fastbow.add(AlternateCodes.format("&7- &bEpic"));
		fastbow.add(AlternateCodes.format("&7- &5Legendary"));
		createEnchantment(inv, "&6" + ench6.getName(), fastbow);
		
		
		ArrayList<String> speed = new ArrayList<String>();
		speed.add(AlternateCodes.format("&7When you equip boots you get Speed."));
		speed.add(AlternateCodes.format(""));
		speed.add(AlternateCodes.format("&7Enchantable items: &dBoots"));
		speed.add(AlternateCodes.format("&7Can be found in:"));
		speed.add(AlternateCodes.format("&7- &bEpic"));
		speed.add(AlternateCodes.format("&7- &5Legendary"));
		createEnchantment(inv, "&6" + ench5.getName(), speed);
		
	
		ArrayList<String> fress = new ArrayList<String>();
		fress.add(AlternateCodes.format("&7When you equip a chestplate you get Fire Resistance."));
		fress.add(AlternateCodes.format(""));
		fress.add(AlternateCodes.format("&7Enchantable items: &dChestplates"));
		fress.add(AlternateCodes.format("&7Can be found in:"));
		fress.add(AlternateCodes.format("&7- &aCommon"));
		createEnchantment(inv, "&6" + ench4.getName(), fress);
		
		ArrayList<String> explosive = new ArrayList<String>();
		explosive.add(AlternateCodes.format("&7When you shoot arrows and they land they will explode."));
		explosive.add(AlternateCodes.format(""));
		explosive.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		explosive.add(AlternateCodes.format("&7Can be found in:"));
		explosive.add(AlternateCodes.format("&7- &aCommon"));
		explosive.add(AlternateCodes.format("&7- &bEpic"));
		explosive.add(AlternateCodes.format("&7- &5Legendary"));
		createEnchantment(inv, "&6" + ench7.getName(), explosive);
		
		ArrayList<String> r = new ArrayList<String>();
		r.add(AlternateCodes.format("&7When youre mining stone it will sometimes give you a ore."));
		r.add(AlternateCodes.format(""));
		r.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		r.add(AlternateCodes.format("&7Can be found in:"));
		r.add(AlternateCodes.format("&7- &aCommon"));
		r.add(AlternateCodes.format("&7- &bEpic"));
		r.add(AlternateCodes.format("&7- &5Legendary"));
		createEnchantment(inv, "&6" + ench8.getName(), r);
		
		ArrayList<String> telepathy = new ArrayList<String>();
		telepathy.add(AlternateCodes.format("&7When youre mining blocks they teleport into your inventory."));
		telepathy.add(AlternateCodes.format(""));
		telepathy.add(AlternateCodes.format("&7Enchantable items: &dTools"));
		telepathy.add(AlternateCodes.format("&7Can be found in:"));
		telepathy.add(AlternateCodes.format("&7- &aCommon"));
		createEnchantment(inv, "&6" + ench9.getName(), telepathy);
		
		ArrayList<String> bright = new ArrayList<String>();
		bright.add(AlternateCodes.format("&7See everything in the dark."));
		bright.add(AlternateCodes.format(""));
		bright.add(AlternateCodes.format("&7Enchantable items: &dHelmets"));
		bright.add(AlternateCodes.format("&7Can be found in:"));
		bright.add(AlternateCodes.format("&7- &aCommon"));
		createEnchantment(inv, "&6" + ench11.getName(), bright);
		
		p.openInventory(inv);
	}
	
	public static void createEnchantment(Inventory inv, String displayname , List<String> lore) {
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(AlternateCodes.format(displayname));
		im.setLore(lore);
		item.setItemMeta(im);
		inv.addItem(item);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getClickedInventory() != null) {
			if(e.getWhoClicked() instanceof Player) {
				if(e.getClickedInventory().getName() != null) {
						if(e.getClickedInventory().getName().equalsIgnoreCase(AlternateCodes.format("&eEnchantments"))) {
							e.setCancelled(true);
						}
			}
			}
		}
	}
}
