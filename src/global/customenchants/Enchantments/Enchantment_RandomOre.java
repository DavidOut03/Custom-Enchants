package global.customenchants.Enchantments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Enchantment_RandomOre extends Enchantment implements Listener {

	public Enchantment_RandomOre(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	static Enchantment autosmelt = new Enchantment_AutoSmelt(102);
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
			if(p.getItemInHand().containsEnchantment(this)) {
				if(e.getBlock().getType() == Material.STONE) {
				if(p.getItemInHand().getEnchantmentLevel(this) == 1) {
					sendRandomOreLvl1(p, e.getBlock());
				} else if(p.getItemInHand().getEnchantmentLevel(this) == 2) {
					sendRandomOreLvl2(p, e.getBlock());
				} else if(p.getItemInHand().getEnchantmentLevel(this) == 3) {
					sendRandomOreLvl3(p, e.getBlock());
				}
				}
			}
		}
	}
	
	public static void sendRandomOreLvl1(Player p, Block b) { 
		List<Material> ores = new ArrayList<Material>();
		ores.clear();
		
		ores.add(Material.COBBLESTONE); // 70
		ores.add(Material.COAL_ORE); // 11
		ores.add(Material.IRON_ORE); // 3
		
		Random r = new Random();
		int choice = r.nextInt(100) + 1;
		
		if(choice < 90) {
			b.setType(Material.COBBLESTONE);
		} else if(choice < 95) {
			b.setType(Material.COAL_ORE);
		} else if(choice < 100) {
			if(p.getItemInHand().containsEnchantment(autosmelt)) {
			p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.IRON_INGOT));
			b.setType(Material.AIR);
			} else {
				b.setType(Material.IRON_ORE);
			}
		}
		
		
	}
	
	public static void sendRandomOreLvl2(Player p, Block b) { 
		List<Material> ores = new ArrayList<Material>();
		ores.clear();
		
		ores.add(Material.COBBLESTONE); // 70
		ores.add(Material.COAL_ORE); // 11
		ores.add(Material.LAPIS_ORE); // 5
		ores.add(Material.REDSTONE_ORE); // 6
		ores.add(Material.IRON_ORE); // 3
		ores.add(Material.GOLD_ORE); // 2
		
		Random r = new Random();
		int choice = r.nextInt(100);
		
		if(choice < 85) {
			b.setType(Material.COBBLESTONE);
		} else if(choice < 88) {
			b.setType(Material.COAL);
		} else if(choice < 92) {
			b.setType(Material.LAPIS_ORE);
		} else if(choice < 95) {
			b.setType(Material.REDSTONE_ORE);
		} else if(choice < 97) {
			if(p.getItemInHand().containsEnchantment(autosmelt)) {
				p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.IRON_INGOT));
				b.setType(Material.AIR);
				} else {
					b.setType(Material.IRON_ORE);
				}
		} else if(choice < 100) {
			if(p.getItemInHand().containsEnchantment(autosmelt)) {
				p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.GOLD_INGOT));
				b.setType(Material.AIR);
				} else {
					b.setType(Material.GOLD_INGOT);
				}
		} 
	}
	
	public static void sendRandomOreLvl3(Player p, Block b) { 
		List<Material> ores = new ArrayList<Material>();
		ores.clear();
		
		ores.add(Material.COBBLESTONE); // 70
		ores.add(Material.IRON_ORE); // 3
		ores.add(Material.GOLD_ORE); // 2
		ores.add(Material.DIAMOND_ORE); // 2
		ores.add(Material.EMERALD_ORE); // 1
		
		Random r = new Random();
		int choice = r.nextInt(100);
		
		if(choice < 85) {
			b.setType(Material.COBBLESTONE);
		} else if(choice < 90) {
			if(p.getItemInHand().containsEnchantment(autosmelt)) {
				p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.IRON_INGOT));
				b.setType(Material.AIR);
				} else {
					b.setType(Material.IRON_INGOT);
				}
		} else if(choice < 95) {
			if(p.getItemInHand().containsEnchantment(autosmelt)) {
				p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.GOLD_INGOT));
				b.setType(Material.AIR);
				} else {
					b.setType(Material.GOLD_INGOT);
				}
		} else if(choice < 98) {
			b.setType(Material.DIAMOND_ORE);
		} else if(choice < 100) {
			b.setType(Material.EMERALD_ORE);
		} 
	}
	
	@Override
	public int getId() {
		return 108;
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "RandomOre";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

}
