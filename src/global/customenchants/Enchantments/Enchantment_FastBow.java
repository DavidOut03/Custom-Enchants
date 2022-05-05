package global.customenchants.Enchantments;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Enchantment_FastBow extends Enchantment implements Listener {

	public Enchantment_FastBow(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onInterackt(PlayerInteractEvent e) {
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Player p = e.getPlayer();
			if(p.getItemInHand().getType() == Material.BOW) {
				if(p.getItemInHand().containsEnchantment(this)) {
					if(p.getInventory().contains(Material.ARROW)) {
						e.setCancelled(true);
						Arrow ar = p.launchProjectile(Arrow.class);
						ar.setShooter(p);
						ar.setVelocity(p.getLocation().getDirection().multiply(1.8));
						p.getInventory().removeItem(new ItemStack(Material.ARROW,1 ));

					}
				}
 			}
		}
	}
	
	@Override
	public int getId() {
		return 106;
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
		return "Fastbow";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
