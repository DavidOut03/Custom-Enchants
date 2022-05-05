package global.customenchants.Enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

public class Enchantment_JellyLegs extends Enchantment implements Listener {

	public Enchantment_JellyLegs(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onFall(EntityDamageEvent e) {
		
		if(e.getCause().equals(DamageCause.FALL)) {
			if(e.getEntity().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				if(p.getInventory().getLeggings() != null) {
				if(p.getInventory().getLeggings().containsEnchantment(this)) {
					if(p.getInventory().getLeggings().getEnchantmentLevel(this) == 1) {
						double decrease = e.getDamage() * 0.25;
						double damage = e.getDamage() - decrease;
						e.setDamage(damage);
					} else if(p.getInventory().getLeggings().getEnchantmentLevel(this) == 2) {
						double decrease = e.getDamage() * 0.50;
						double damage = e.getDamage() - decrease;
						e.setDamage(damage);
					} else if(p.getInventory().getLeggings().getEnchantmentLevel(this) == 3) {
						double decrease = e.getDamage() * 0.75;
						double damage = e.getDamage() - decrease;
						e.setDamage(damage);
					} else if(p.getInventory().getLeggings().getEnchantmentLevel(this) == 4) {
						e.setCancelled(true);
					}
				}
				}
			} else {
				e.setCancelled(false);
			}
		} else {
			e.setCancelled(false);
		}
	}
	
	@Override
	public int getId() {
		return 103;
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
		return 4;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "JellyLegs";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
