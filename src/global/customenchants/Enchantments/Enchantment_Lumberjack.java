package global.customenchants.Enchantments;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Enchantment_Lumberjack extends Enchantment implements Listener {

	public Enchantment_Lumberjack(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand().containsEnchantment(this)) {
			if(e.getBlock().getType() == Material.LOG || e.getBlock().getType() == Material.LEAVES) {
				breakTree(p, e.getBlock());
			}
		}
 	}
	
	Enchantment ench = new Enchantment_Telepathy(109);
	
	public void breakTree(Player p, Block tree) {
		if(tree.getType() == Material.LOG || tree.getType() == Material.LEAVES) {
			if(p.getItemInHand().containsEnchantment(ench)) {
				for(ItemStack drops : tree.getDrops()) {
					p.getInventory().addItem(drops);
					tree.setType(Material.AIR);
				}
			} else {
				tree.breakNaturally(p.getItemInHand());
			}
			
			for(BlockFace face : BlockFace.values()) {
				breakTree(p, tree.getRelative(face));
			}
			
		}
	}
	@Override
	public int getId() {
		return 110;
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
		return "Lumberjack";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
