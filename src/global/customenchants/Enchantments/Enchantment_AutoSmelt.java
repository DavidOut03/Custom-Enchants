package global.customenchants.Enchantments;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Enchantment_AutoSmelt extends Enchantment implements Listener {

	public Enchantment_AutoSmelt(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(e.getPlayer().getItemInHand() != null) {
			if(e.getPlayer().getItemInHand().containsEnchantment(this)) {
				Enchantment ench = new Enchantment_Telepathy(109);
				if(e.getBlock().getType() == Material.IRON_ORE) {
					e.setCancelled(true);
					e.getBlock().setType(Material.AIR);
					if(e.getPlayer().getItemInHand().containsEnchantment(ench)) {
						e.setCancelled(true);
						e.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_INGOT));
						e.getBlock().setType(Material.AIR);
					} else {
						e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
					}
				} else if(e.getBlock().getType() == Material.GOLD_ORE) {
					e.setCancelled(true);
					e.getBlock().setType(Material.AIR);
					if(e.getPlayer().getItemInHand().containsEnchantment(ench)) {
						e.setCancelled(true);
						e.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
						e.getBlock().setType(Material.AIR);
					} else {
						e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
					}
				}
			}
 		}
	}
	
	@Override
	public int getId() {
		return 102;
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
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AutoSmelt";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
