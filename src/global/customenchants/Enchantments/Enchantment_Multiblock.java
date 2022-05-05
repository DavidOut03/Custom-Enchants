package global.customenchants.Enchantments;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Enchantment_Multiblock extends Enchantment implements Listener {

	public Enchantment_Multiblock(int id) {
		super(id);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		if(e.getPlayer().getItemInHand() != null) {
			Enchantment ench = new Enchantment_Multiblock(101);
			if(e.getPlayer().getItemInHand().containsEnchantment(ench)) {
					for(int x = -1; x <= 1; ++x) {
						for(int y = -1; y <= 1; ++y) {
							for(int z = -1; z <= 1; ++z) {
								Block currentblock = e.getBlock().getRelative(x, y, z);
								if(currentblock.getType() == Material.BEDROCK) {
									e.setCancelled(true);
								} else {
								
								 Enchantment ench1 = new Enchantment_AutoSmelt(102);
								 Enchantment ench2 = new Enchantment_Telepathy(109);
									if(e.getPlayer().getItemInHand().containsEnchantment(ench1)) {
										if(currentblock.getType() == Material.IRON_ORE) {
											e.setCancelled(true);
											currentblock.setType(Material.AIR);
											if(e.getPlayer().getItemInHand().containsEnchantment(ench2)) {
												e.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_INGOT));
											} else {
											currentblock.getWorld().dropItemNaturally(currentblock.getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										} else if(currentblock.getType() == Material.GOLD_ORE) {
											e.setCancelled(true);
											currentblock.setType(Material.AIR);
											if(e.getPlayer().getItemInHand().containsEnchantment(ench2)) {
												e.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
											} else {
											currentblock.getWorld().dropItemNaturally(currentblock.getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										} else {
											if(e.getPlayer().getItemInHand().containsEnchantment(ench2)) {
												e.setCancelled(true);
												e.getPlayer().getInventory().addItem(new ItemStack(currentblock.getType()));
												currentblock.setType(Material.AIR);
											} else {
											currentblock.breakNaturally(e.getPlayer().getItemInHand());
											}
										}
									} else {
										if(e.getPlayer().getItemInHand().containsEnchantment(ench2)) {
											e.setCancelled(true);
											e.getPlayer().getInventory().addItem(new ItemStack(currentblock.getType()));
											currentblock.setType(Material.AIR);
										} else {
										currentblock.breakNaturally(e.getPlayer().getItemInHand());
										}
									}
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public int getId() {
		return 101;
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Multiblock";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

}
