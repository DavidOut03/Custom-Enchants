package global.customenchants.Core;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;

import global.customenchants.Commands.Command_CustomEnchant;
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
import global.customenchants.Events.Event_Enchant;
import global.customenchants.GUI.GUI_Anvil;
import global.customenchants.GUI.GUI_Enchant;
import global.customenchants.GUI.GUI_Enchantments;

public class Register {

	
	
	static Main plugin = Main.getPlugin(Main.class);
	
	public static void Register() {
		registerCommands();
		registerEvents();
		registerGUI();
		registerFunctionCustomEnchantments();
	}
	
	private static void registerCommands() {
	plugin.getCommand("customenchant").setExecutor(new Command_CustomEnchant());	
	}
	
	private static void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new Event_Enchant(), plugin);
	}
	private static void registerGUI() {
		Bukkit.getPluginManager().registerEvents(new GUI_Enchant(), plugin);
		Bukkit.getPluginManager().registerEvents(new GUI_Enchantments(), plugin);
		Bukkit.getPluginManager().registerEvents(new GUI_Anvil(), plugin);
	}
	
	private static void registerFunctionCustomEnchantments() {
		Bukkit.getPluginManager().registerEvents(new Enchantment_Multiblock(101), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_AutoSmelt(102), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_JellyLegs(103), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_FireResistance(104), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_Speed(105), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_FastBow(106), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_Explosive(107), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_RandomOre(108), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_Telepathy(109), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_Lumberjack(110), plugin);
		Bukkit.getPluginManager().registerEvents(new Enchantment_Fullbright(111), plugin);
	}
	public static void registerEnchantments() {
		
		Enchantment multiblock = new Enchantment_Multiblock(101);
		Enchantment.registerEnchantment(multiblock);
		
		Enchantment autosmelt = new Enchantment_AutoSmelt(102);
		Enchantment.registerEnchantment(autosmelt);
		
		Enchantment jellylegs = new Enchantment_JellyLegs(103);
		Enchantment.registerEnchantment(jellylegs);
		
		Enchantment fress = new Enchantment_FireResistance(104);
		Enchantment.registerEnchantment(fress);
		
		Enchantment speed = new Enchantment_Speed(105);
		Enchantment.registerEnchantment(speed);

		Enchantment fastbow = new Enchantment_FastBow(106);
		Enchantment.registerEnchantment(fastbow);
		
		Enchantment explosive = new Enchantment_Explosive(107);
		Enchantment.registerEnchantment(explosive);
		
		Enchantment randomore = new Enchantment_RandomOre(108);
		Enchantment.registerEnchantment(randomore);
		
		Enchantment telepathy = new Enchantment_Telepathy(109);
		Enchantment.registerEnchantment(telepathy);
		
		Enchantment lumberjack = new Enchantment_Lumberjack(110);
		Enchantment.registerEnchantment(lumberjack);
		
		Enchantment fullbright = new Enchantment_Fullbright(111);
		Enchantment.registerEnchantment(fullbright);
	}
	
	
}
