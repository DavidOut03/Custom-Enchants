package global.customenchants.Enchantments;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.minecraft.server.v1_8_R3.Block;

public class Enchantment_FireResistance extends Enchantment implements Listener {

	public Enchantment_FireResistance(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	Material[] chestplate = {Material.DIAMOND_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_CHESTPLATE};


	@EventHandler
	public void onMove(InventoryClickEvent e) {
		
		if(e.getWhoClicked() instanceof Player) {
		if(e.getClickedInventory()  == e.getWhoClicked().getInventory()) {
		Player p = (Player) e.getWhoClicked();
		
		for(Material mat : chestplate) {
			if(e.getClick().equals(ClickType.RIGHT) || e.getClick().equals(ClickType.LEFT)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
				if(e.getSlot() == 38) {
				if(e.getCursor().getType() == Material.AIR || e.getCursor() == null) {
					if(e.getCurrentItem().containsEnchantment(this)) {
						if(e.getCurrentItem().getType() == mat) {
						p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					}
					}
				} else {
					if(e.getCursor().getType() == mat) {
					if(e.getCursor().containsEnchantment(this)) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000000, 0), true);
					} else {
						if(e.getCurrentItem().containsEnchantment(this)) {
							p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						}
					}
				}
				}
				}
				}
			} else if(e.getClick().equals(ClickType.SHIFT_LEFT) || e.getClick().equals(ClickType.SHIFT_RIGHT)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					if(e.getSlot() == 38) {
					if(e.getCurrentItem().getType() == mat) {
					if(e.getCurrentItem().containsEnchantment(this)) {
						p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					}
					}
					}
				} else {
					if(p.getInventory().getLeggings() == null || p.getInventory().getLeggings().getType() == Material.AIR) {
						if(e.getCurrentItem().containsEnchantment(this)) {
							if(e.getCurrentItem().getType() == mat) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000000, 0), true);
							}
						}
					}
				}
			} else if(e.getClick().equals(ClickType.NUMBER_KEY)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					if(e.getSlot() == 38) {
						if(e.getAction().equals(InventoryAction.HOTBAR_SWAP)) {
							if(e.getCurrentItem().containsEnchantment(this)) {
								p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							} 
						}
					}
				}
			} else  {
				if(e.getSlot() == 38) {
					if(e.getCurrentItem().containsEnchantment(this)) {
						p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
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
		
				for(Material mat : chestplate) {
					if(p.getItemInHand().getType() == mat) {
				if(p.getInventory().getLeggings() == null) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000000, 0), true);
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
		return 104;
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
		return "Fireresistance";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
