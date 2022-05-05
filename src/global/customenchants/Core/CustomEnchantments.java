package global.customenchants.Core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;

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

public class CustomEnchantments {
	
	
	private static ArrayList<Enchantment> enchantments = new ArrayList<Enchantment>();
	
	public static Enchantment multiblock = new Enchantment_Multiblock("multiblock");
	public static Enchantment autosmelt = new Enchantment_AutoSmelt("autosmelt");
	public static Enchantment jellylegs = new Enchantment_JellyLegs("jellylegs");
	public static Enchantment fireresistance = new Enchantment_FireResistance("fireresistance");
	public static Enchantment speed = new Enchantment_Speed("speed");
	public static Enchantment fastbow = new Enchantment_FastBow("fastbow");
	public static Enchantment explosive = new Enchantment_Explosive("explosive");
	public static Enchantment randomore = new Enchantment_RandomOre("randomore");
	public static Enchantment telepathy = new Enchantment_Telepathy("telepathy");
	public static Enchantment lumberjack = new Enchantment_Lumberjack("lumberjack");
	public static Enchantment fullbright = new Enchantment_Fullbright("fullbright");
	
	
	private static void registerFunctionCustomEnchantments() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Enchantment_Multiblock("multiblock"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_AutoSmelt("autosmelt"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_JellyLegs("jellylegs"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_FireResistance("fireresistance"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_Speed("speed"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_FastBow("fastbow"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_Explosive("explosive"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_RandomOre("randomore"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_Telepathy("telepathy"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_Lumberjack("lumberjack"),  Main.getPlugin(Main.class));
		pm.registerEvents(new Enchantment_Fullbright("fullbright"),  Main.getPlugin(Main.class));
	}
	
	public static void registerEnchantments() {
		loadCustomEnchantments();
		try {
			try {
				Field field = Enchantment.class.getDeclaredField("acceptingNew");
				field.setAccessible(true);
				field.set(null, true);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				for(Enchantment ench : enchantments) {
					Enchantment.registerEnchantment(ench);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		registerFunctionCustomEnchantments();
	}
	public static void unLoadEnchantments() {
		if(enchantments.isEmpty()) {
			loadCustomEnchantments();
		}
	try {
		Field byKeyField = Enchantment.class.getDeclaredField("byKey");
		Field byNameField = Enchantment.class.getDeclaredField("byName");
		
		byKeyField.setAccessible(true);
		byNameField.setAccessible(true);
		
		HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) byKeyField.get(null);
		HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) byNameField.get(null);
		
		for(Enchantment ench : enchantments) {
		if(byKey.containsKey(ench.getKey())) {
			byKey.remove(ench.getKey());
		}
		if(byName.containsKey(ench.getName())) {
			byName.remove(ench.getName());
		}
		}
	} catch (Exception ignore) {
		
	}
}
	
	private static void loadCustomEnchantments() {
		enchantments.add(multiblock);
		enchantments.add(autosmelt);
		enchantments.add(jellylegs);
		enchantments.add(fireresistance);
		enchantments.add(speed);
		enchantments.add(fastbow);
		enchantments.add(explosive);
		enchantments.add(randomore);
		enchantments.add(telepathy);
		enchantments.add(lumberjack);
		enchantments.add(fullbright);
	}


}
