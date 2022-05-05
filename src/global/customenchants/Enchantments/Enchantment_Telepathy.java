package global.customenchants.Enchantments;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import global.customenchants.Utils.AlternateCodes;

public class Enchantment_Telepathy extends Enchantment implements Listener {

	public Enchantment_Telepathy(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().containsEnchantment(this)) {
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage(AlternateCodes.format("&cYour inventory is full."));
				e.setCancelled(true);
			} else {
				p.getInventory().addItem(new ItemStack(e.getBlock().getType()));
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
			}
		}
	}
	
	@Override
	public int getId() {
		return 109;
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
		return "Telepathy";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
