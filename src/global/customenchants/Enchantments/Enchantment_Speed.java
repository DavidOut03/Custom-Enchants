package global.customenchants.Enchantments;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Enchantment_Speed extends Enchantment implements Listener {

	public Enchantment_Speed(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	Material[] boots = {Material.DIAMOND_BOOTS, Material.IRON_BOOTS, Material.CHAINMAIL_BOOTS, Material.GOLD_BOOTS, Material.LEATHER_BOOTS};


	@EventHandler
	public void onMove(InventoryClickEvent e) {
		
		if(e.getWhoClicked() instanceof Player) {
		if(e.getClickedInventory()  == e.getWhoClicked().getInventory()) {
		Player p = (Player) e.getWhoClicked();
		
		for(Material mat : boots) {
			if(e.getClick().equals(ClickType.RIGHT) || e.getClick().equals(ClickType.LEFT)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
				if(e.getSlot() == 36) {
				if(e.getCursor().getType() == Material.AIR || e.getCursor() == null) {
					if(e.getCurrentItem().containsEnchantment(this)) {
						if(e.getCurrentItem().getType() == mat) {
						p.removePotionEffect(PotionEffectType.SPEED);
					}
					}
				} else {
					if(e.getCursor().getType() == mat) {
					if(e.getCursor().containsEnchantment(this)) {
						if(e.getCursor().getEnchantmentLevel(this) == 1) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0), true);
							} else if(p.getItemInHand().getEnchantmentLevel(this) == 2){
								p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 1), true);
							}
					} else {
						if(e.getCurrentItem().containsEnchantment(this)) {
							p.removePotionEffect(PotionEffectType.SPEED);
						}
					}
				}
				}
				}
				}
			} else if(e.getClick().equals(ClickType.SHIFT_LEFT) || e.getClick().equals(ClickType.SHIFT_RIGHT)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					if(e.getSlot() == 36) {
					if(e.getCurrentItem().getType() == mat) {
					if(e.getCurrentItem().containsEnchantment(this)) {
						p.removePotionEffect(PotionEffectType.SPEED);
					}
					}
					}
				} else {
					if(p.getInventory().getLeggings() == null || p.getInventory().getLeggings().getType() == Material.AIR) {
						if(e.getCurrentItem().containsEnchantment(this)) {
							if(e.getCurrentItem().getType() == mat) {
								if(e.getCurrentItem().getEnchantmentLevel(this) == 1) {
									p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0), true);
									} else {
										p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 1), true);
									}
							}
						}
					}
				}
			} else if(e.getClick().equals(ClickType.NUMBER_KEY)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					if(e.getSlot() == 36) {
						if(e.getAction().equals(InventoryAction.HOTBAR_SWAP)) {
							if(e.getCurrentItem().containsEnchantment(this)) {
								p.removePotionEffect(PotionEffectType.SPEED);
							} 
						}
					}
				}
			}  else  {
				if(e.getSlot() == 36) {
					if(e.getCurrentItem().containsEnchantment(this)) {
						p.removePotionEffect(PotionEffectType.SPEED);
					}
				}
			}
		}
		}
		}

	}
	
	@EventHandler
	public void onMove(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE) {
			if(p.getItemInHand().containsEnchantment(this)) {
		
				for(Material mat : boots) {
					if(p.getItemInHand().getType() == mat) {
				if(p.getInventory().getBoots() == null) {
					if(p.getItemInHand().getEnchantmentLevel(this) == 1) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0), true);
					} else {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 1), true);
					}
				} else {
					e.setCancelled(false);
				}
					}
				}
		}
			} 
			}
	}

	@Override
	public int getId() {
		return 105;
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
		return 2;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Speed";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}
	

}
