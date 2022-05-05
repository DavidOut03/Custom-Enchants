package global.customenchants.Core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import global.customenchants.Enchantments.Enchantment_AutoSmelt;
import global.customenchants.Enchantments.Enchantment_Explosive;
import global.customenchants.Enchantments.Enchantment_FastBow;
import global.customenchants.Enchantments.Enchantment_FireResistance;
import global.customenchants.Enchantments.Enchantment_Fullbright;
import global.customenchants.Enchantments.Enchantment_JellyLegs;
import global.customenchants.Enchantments.Enchantment_Lumberjack;
import global.customenchants.Enchantments.Enchantment_Multiblock;
import global.customenchants.Enchantments.Enchantment_RandomOre;
import global.customenchants.Enchantments.Enchantment_Telepathy;
import global.customenchants.Enchantments.Enchantment_Speed;
import global.customenchants.Utils.AlternateCodes;
import global.customenchants.Utils.Message;

public class Main extends JavaPlugin implements Listener {
	
	public Enchantment ench1 = new Enchantment_Multiblock(101);
	public Enchantment ench2 = new Enchantment_AutoSmelt(102);
	public Enchantment ench3 = new Enchantment_JellyLegs(103);
	public Enchantment ench4 = new Enchantment_FireResistance(104);
	public Enchantment ench5 = new Enchantment_Speed(105);
	public Enchantment ench6 = new Enchantment_FastBow(106);
	public Enchantment ench7 = new Enchantment_Explosive(107);
	public Enchantment ench8 = new Enchantment_RandomOre(108);
	public Enchantment ench9 = new Enchantment_Telepathy(109);
	public Enchantment ench10 = new Enchantment_Lumberjack(110);
	public Enchantment ench11 = new Enchantment_Fullbright(111);
	
	
	public void onEnable() {
		LoadCustomEnchantments();
		Register.Register();
	}
	
	

	
	@SuppressWarnings("unchecked")
	public void onDisable() {
		try {
			Field byIdField = Enchantment.class.getDeclaredField("byId");
			Field byNameField = Enchantment.class.getDeclaredField("byName");
			
			byIdField.setAccessible(true);
			byNameField.setAccessible(true);
			
			HashMap<Integer, Enchantment> byId = (HashMap<Integer, Enchantment>) byIdField.get(null);
			HashMap<Integer, Enchantment> byName = (HashMap<Integer, Enchantment>) byNameField.get(null);
			
			if(byId.containsKey(ench1.getId())) {
				byId.remove(ench1.getId());
			}
			if(byName.containsKey(ench1.getName())) {
				byName.remove(ench1.getName());
			}
			
			if(byId.containsKey(ench2.getId())) {
				byId.remove(ench2.getId());
			}
			if(byName.containsKey(ench2.getName())) {
				byName.remove(ench2.getName());
			}
			
			if(byId.containsKey(ench3.getId())) {
				byId.remove(ench3.getId());
			}
			if(byName.containsKey(ench3.getName())) {
				byName.remove(ench3.getName());
			}
			
			if(byId.containsKey(ench4.getId())) {
				byId.remove(ench4.getId());
			}
			if(byName.containsKey(ench4.getName())) {
				byName.remove(ench4.getName());
			}
			
			if(byId.containsKey(ench5.getId())) {
				byId.remove(ench5.getId());
			}
			if(byName.containsKey(ench5.getName())) {
				byName.remove(ench5.getName());
			}

			if(byId.containsKey(ench6.getId())) {
				byId.remove(ench6.getId());
			}
			if(byName.containsKey(ench6.getName())) {
				byName.remove(ench6.getName());
			}
			
			if(byId.containsKey(ench7.getId())) {
				byId.remove(ench7.getId());
			}
			if(byName.containsKey(ench7.getName())) {
				byName.remove(ench7.getName());
			}
			
			if(byId.containsKey(ench8.getId())) {
				byId.remove(ench8.getId());
			}
			if(byName.containsKey(ench8.getName())) {
				byName.remove(ench8.getName());
			}
			
			if(byId.containsKey(ench9.getId())) {
				byId.remove(ench9.getId());
			}
			if(byName.containsKey(ench9.getName())) {
				byName.remove(ench9.getName());
			}
		
			if(byId.containsKey(ench10.getId())) {
				byId.remove(ench10.getId());
			}
			if(byName.containsKey(ench10.getName())) {
				byName.remove(ench10.getName());
			}
			if(byId.containsKey(ench11.getId())) {
				byId.remove(ench11.getId());
			}
			if(byName.containsKey(ench11.getName())) {
				byName.remove(ench11.getName());
			}
			
			
		
		} catch (Exception ignore) {
			
		}
	}
	
	public void LoadCustomEnchantments() {
		try {
			try {
				Field f = Enchantment.class.getDeclaredField("acceptingNew");
				f.setAccessible(true);
				f.set(null, true);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Register.registerEnchantments();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
}
