package global.customenchants.Events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
import global.customenchants.Utils.AlternateCodes;
import net.minecraft.server.v1_8_R3.MobSpawnerAbstract.a;

public class Event_Enchant implements Listener {
	
	 Enchantment fastbow = new Enchantment_FastBow(106);
	 Enchantment multiblock = new Enchantment_Multiblock(101);
	 Enchantment autosmelt = new Enchantment_AutoSmelt(102);
	 Enchantment jellylegs = new Enchantment_JellyLegs(103);
	 Enchantment fireresistance = new Enchantment_FireResistance(104);
	 Enchantment speed = new Enchantment_Speed(105);
	 Enchantment explosive = new Enchantment_Explosive(107);
	 Enchantment randomore = new Enchantment_RandomOre(108);
	 Enchantment telepathy = new Enchantment_Telepathy(109);
	 Enchantment lumberjack = new Enchantment_Lumberjack(110);
	 Enchantment fullbright = new Enchantment_Fullbright(111);
	
	Material[] pickaxe = {Material.DIAMOND_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.STONE_PICKAXE, Material.WOOD_PICKAXE};
	Material[] axe = {Material.DIAMOND_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.STONE_AXE, Material.WOOD_AXE};
	Material[] shovel = {Material.DIAMOND_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.STONE_SPADE, Material.WOOD_SPADE};
	Material[] hoe = {Material.DIAMOND_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.STONE_HOE, Material.WOOD_HOE};
	Material[] helmet = {Material.DIAMOND_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.CHAINMAIL_HELMET, Material.LEATHER_HELMET};
	Material[] chestplate = {Material.DIAMOND_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_CHESTPLATE};
	Material[] leggings = {Material.DIAMOND_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.LEATHER_LEGGINGS};
	Material[] boots = {Material.DIAMOND_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.LEATHER_BOOTS};
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getClickedInventory() != null) {
			if(e.getWhoClicked() instanceof Player) { 
			
				Player p = (Player) e.getWhoClicked();
				if(e.getCurrentItem() != null || e.getCurrentItem().getType() != Material.AIR) {
					if(e.getCursor() != null || e.getCursor().getType() != Material.AIR) {
				
				if(e.getCursor().getType() == Material.ENCHANTED_BOOK) {
					if(e.getCursor().containsEnchantment(fastbow)) {
						if(e.getCurrentItem().getType() == Material.BOW) {
							if(!e.getCurrentItem().containsEnchantment(fastbow)) {
							e.setCancelled(true);
							e.setCursor(null);
							ItemStack item = e.getCurrentItem();
							item.addUnsafeEnchantment(fastbow, 1);
							ItemMeta im = item.getItemMeta();
							ArrayList<String> lore = new ArrayList<String>();
							
							lore.add(ChatColor.GRAY + fastbow.getName() + " I");
							if(im.getLore() != null) {
								List<String> oldlore = new ArrayList<String>();
								oldlore = im.getLore();
								lore.addAll(oldlore);
							}
							im.setLore(lore);
							item.setItemMeta(im);
							e.setCurrentItem(item);
							} else {
								e.setCancelled(true);
							}
						}
					} else if(e.getCursor().containsEnchantment(telepathy)) {
						for(Material pk : pickaxe) {
							for(Material sh : shovel) {
								for(Material ex : axe) {
									for(Material how : hoe) {
										if(e.getCurrentItem().getType() == pk || e.getCurrentItem().getType() == sh || e.getCurrentItem().getType() == ex || e.getCurrentItem().getType() == how) {
											if(!e.getCurrentItem().containsEnchantment(telepathy)) {
												e.setCancelled(true);
												e.setCursor(null);
												ItemStack item = e.getCurrentItem();
												item.addUnsafeEnchantment(telepathy, 1);
												ItemMeta im = item.getItemMeta();
												ArrayList<String> lore = new ArrayList<String>();
												
												lore.add(ChatColor.GRAY + telepathy.getName() + " I");
												if(im.getLore() != null) {
													List<String> oldlore = new ArrayList<String>();
													oldlore = im.getLore();
													lore.addAll(oldlore);
												}
												im.setLore(lore);
												item.setItemMeta(im);
												e.setCurrentItem(item);
												} else {
													e.setCancelled(true);
												}
										}
									}
								}
							}
						}
							
						
					} else if(e.getCursor().containsEnchantment(randomore)) {
						for(Material mat : pickaxe) {
						if(e.getCurrentItem().getType() == mat) {
						
									if(!e.getCurrentItem().containsEnchantment(randomore)) {
									int level = e.getCursor().getEnchantmentLevel(Enchantment.getByName(randomore.getName()));
								e.setCancelled(true);
								e.setCursor(null);
							
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(randomore, level);
							
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								if(level == 1) {
								lore.add(ChatColor.GRAY + randomore.getName() + " I");
								} else if(level == 2) {
									lore.add(ChatColor.GRAY + randomore.getName() + " II");
								} else if(level == 3) {
									lore.add(ChatColor.GRAY + randomore.getName() + " III");
								} 
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
									} else {
										 if(e.getCursor().getEnchantmentLevel(randomore) == 1) {
												e.setCancelled(true);
											} else if(e.getCursor().getEnchantmentLevel(randomore) == 2) {
												if(e.getCurrentItem().getEnchantmentLevel(randomore) == 1) {
													int level = 2;
													e.setCancelled(true);
													e.setCursor(null);
												
													ItemStack item = e.getCurrentItem();
													item.removeEnchantment(randomore);
													item.addUnsafeEnchantment(randomore, level);
												
													ItemMeta im = item.getItemMeta();
													ArrayList<String> lore = new ArrayList<String>();
													
														lore.add(ChatColor.GRAY + randomore.getName() + " II");
												
													if(im.getLore() != null) {
														List<String> oldlore = new ArrayList<String>();
														oldlore = im.getLore();
														oldlore.remove(ChatColor.GRAY + randomore.getName() + " I");
														lore.addAll(oldlore);
													}
													im.setLore(lore);
													item.setItemMeta(im);
													e.setCurrentItem(item);
												} else {
													e.setCancelled(true);
												}
											} else if(e.getCursor().getEnchantmentLevel(randomore) == 3) {
												if(e.getCurrentItem().getEnchantmentLevel(randomore) == 2 || e.getCurrentItem().getEnchantmentLevel(randomore) == 1) {
													int level = 3;
													e.setCancelled(true);
													e.setCursor(null);
												
													ItemStack item = e.getCurrentItem();
													item.removeEnchantment(randomore);
													item.addUnsafeEnchantment(randomore, level);
												
													ItemMeta im = item.getItemMeta();
													ArrayList<String> lore = new ArrayList<String>();
													
														lore.add(ChatColor.GRAY + randomore.getName() + " III");
												
													if(im.getLore() != null) {
														List<String> oldlore = new ArrayList<String>();
														oldlore = im.getLore();
														oldlore.remove(ChatColor.GRAY + randomore.getName() + " I");
														oldlore.remove(ChatColor.GRAY + randomore.getName() + " II");
														lore.addAll(oldlore);
													}
													im.setLore(lore);
													item.setItemMeta(im);
													e.setCurrentItem(item);
												
												} else {
													e.setCancelled(true);
												}
											} else {
												e.setCancelled(true);
											}
								} 
						}
					}
					} else if(e.getCursor().containsEnchantment(multiblock)) {
						for(Material mat : pickaxe) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(multiblock)) {
								e.setCancelled(true);
								e.setCursor(null);
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(multiblock, 1);
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								lore.add(ChatColor.GRAY + multiblock.getName() + " I");
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
								} else {
									e.setCancelled(true);
								}
							}
						}
					} else if(e.getCursor().containsEnchantment(autosmelt)) {
						for(Material mat : pickaxe) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(autosmelt)) {
								e.setCancelled(true);
								e.setCursor(null);
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(autosmelt, 1);
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								lore.add(ChatColor.GRAY + autosmelt.getName() + " I");
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
								} else {
									e.setCancelled(true);
								}
							}
						}
					} else if(e.getCursor().containsEnchantment(lumberjack)) {
						for(Material mat : axe) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(lumberjack)) {
								e.setCancelled(true);
								e.setCursor(null);
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(lumberjack, 1);
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								lore.add(ChatColor.GRAY + lumberjack.getName() + " I");
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
								} else {
									e.setCancelled(true);
								}
							}
						}
					} else if(e.getCursor().containsEnchantment(jellylegs)) {
						for(Material mat : leggings) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(jellylegs)) {
								int level = e.getCursor().getEnchantmentLevel(Enchantment.getByName(jellylegs.getName()));
							e.setCancelled(true);
							e.setCursor(null);
						
							ItemStack item = e.getCurrentItem();
							item.addUnsafeEnchantment(jellylegs, level);
						
							ItemMeta im = item.getItemMeta();
							ArrayList<String> lore = new ArrayList<String>();
							
							if(level == 1) {
							lore.add(ChatColor.GRAY + jellylegs.getName() + " I");
							} else if(level == 2) {
								lore.add(ChatColor.GRAY + jellylegs.getName() + " II");
							} else if(level == 3) {
								lore.add(ChatColor.GRAY + jellylegs.getName() + " III");
							} else if(level == 4) {
								lore.add(ChatColor.GRAY + jellylegs.getName() + " IV");
							}
							if(im.getLore() != null) {
								List<String> oldlore = new ArrayList<String>();
								oldlore = im.getLore();
								lore.addAll(oldlore);
							}
							im.setLore(lore);
							item.setItemMeta(im);
							e.setCurrentItem(item);
								} else {
									 if(e.getCursor().getEnchantmentLevel(jellylegs) == 1) {
											e.setCancelled(true);
										} else if(e.getCursor().getEnchantmentLevel(jellylegs) == 2) {
											if(e.getCurrentItem().getEnchantmentLevel(jellylegs) == 1) {
												int level = 2;
												e.setCancelled(true);
												e.setCursor(null);
											
												ItemStack item = e.getCurrentItem();
												item.removeEnchantment(jellylegs);
												item.addUnsafeEnchantment(jellylegs, level);
											
												ItemMeta im = item.getItemMeta();
												ArrayList<String> lore = new ArrayList<String>();
												
													lore.add(ChatColor.GRAY + jellylegs.getName() + " II");
											
												if(im.getLore() != null) {
													List<String> oldlore = new ArrayList<String>();
													oldlore = im.getLore();
													oldlore.remove(ChatColor.GRAY + jellylegs.getName() + " I");
													lore.addAll(oldlore);
												}
												im.setLore(lore);
												item.setItemMeta(im);
												e.setCurrentItem(item);
											} else {
												e.setCancelled(true);
											}
										} else if(e.getCursor().getEnchantmentLevel(jellylegs) == 3) {
											if(e.getCurrentItem().getEnchantmentLevel(jellylegs) == 2 || e.getCurrentItem().getEnchantmentLevel(jellylegs) == 1) {
												int level = 3;
												e.setCancelled(true);
												e.setCursor(null);
											
												ItemStack item = e.getCurrentItem();
												item.removeEnchantment(jellylegs);
												item.addUnsafeEnchantment(jellylegs, level);
											
												ItemMeta im = item.getItemMeta();
												ArrayList<String> lore = new ArrayList<String>();
												
													lore.add(ChatColor.GRAY + jellylegs.getName() + " III");
											
												if(im.getLore() != null) {
													List<String> oldlore = new ArrayList<String>();
													oldlore = im.getLore();
													oldlore.remove(ChatColor.GRAY + jellylegs.getName() + " I");
													oldlore.remove(ChatColor.GRAY + jellylegs.getName() + " II");
													lore.addAll(oldlore);
												}
												im.setLore(lore);
												item.setItemMeta(im);
												e.setCurrentItem(item);
											
											} else {
												e.setCancelled(true);
											}
										} else if(e.getCursor().getEnchantmentLevel(jellylegs) == 4) {
											if(e.getCurrentItem().getEnchantmentLevel(jellylegs) == 1 || e.getCurrentItem().getEnchantmentLevel(jellylegs) == 2 || e.getCurrentItem().getEnchantmentLevel(jellylegs) == 3) {
												int level = 4;
												e.setCancelled(true);
												e.setCursor(null);
											
												ItemStack item = e.getCurrentItem();
												item.removeEnchantment(jellylegs);
												item.addUnsafeEnchantment(jellylegs, level);
											
												ItemMeta im = item.getItemMeta();
												ArrayList<String> lore = new ArrayList<String>();
												
													lore.add(ChatColor.GRAY + jellylegs.getName() + " IV");
											
												if(im.getLore() != null) {
													List<String> oldlore = new ArrayList<String>();
													oldlore = im.getLore();
													oldlore.remove(ChatColor.GRAY + jellylegs.getName() + " I");
													oldlore.remove(ChatColor.GRAY + jellylegs.getName() + " II");
													oldlore.remove(ChatColor.GRAY + jellylegs.getName() + " III");
													lore.addAll(oldlore);
												}
												im.setLore(lore);
												item.setItemMeta(im);
												e.setCurrentItem(item);
											
											} else {
												e.setCancelled(true);
											}
										} else {
											e.setCancelled(true);
										}
									}
								
							} 
						}
					} else if(e.getCursor().containsEnchantment(fireresistance)) {
						for(Material mat : chestplate) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(fireresistance)) {
								e.setCancelled(true);
								e.setCursor(null);
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(fireresistance, 1);
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								lore.add(ChatColor.GRAY + fireresistance.getName() + " I");
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
							} else {
								e.setCancelled(true);
							}
							} 
						}
					} else if(e.getCursor().containsEnchantment(fullbright)) {
						for(Material mat : helmet) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(fullbright)) {
								e.setCancelled(true);
								e.setCursor(null);
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(fullbright, 1);
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								lore.add(ChatColor.GRAY + fullbright.getName() + " I");
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
							} else {
								e.setCancelled(true);
							}
							} 
						}
					} else if(e.getCursor().containsEnchantment(speed)) {
						for(Material mat : boots) {
							if(e.getCurrentItem().getType() == mat) {
								if(!e.getCurrentItem().containsEnchantment(speed)) {
								int level = e.getCursor().getEnchantmentLevel(Enchantment.getByName(speed.getName()));
							e.setCancelled(true);
							e.setCursor(null);
						
							ItemStack item = e.getCurrentItem();
							item.addUnsafeEnchantment(speed, level);
						
							ItemMeta im = item.getItemMeta();
							ArrayList<String> lore = new ArrayList<String>();
							
							if(level == 1) {
							lore.add(ChatColor.GRAY + speed.getName() + " I");
							} else if(level == 2) {
								lore.add(ChatColor.GRAY + speed.getName() + " II");
							}
							if(im.getLore() != null) {
								List<String> oldlore = new ArrayList<String>();
								oldlore = im.getLore();
								lore.addAll(oldlore);
							}
							im.setLore(lore);
							item.setItemMeta(im);
							e.setCurrentItem(item);
								} else {
									 if(e.getCursor().getEnchantmentLevel(speed) == 1) {
											e.setCancelled(true);
										} else if(e.getCursor().getEnchantmentLevel(speed) == 2) {
											if(e.getCurrentItem().getEnchantmentLevel(speed) == 1) {
												int level = 2;
												e.setCancelled(true);
												e.setCursor(null);
											
												ItemStack item = e.getCurrentItem();
												item.removeEnchantment(speed);
												item.addUnsafeEnchantment(speed, level);
											
												ItemMeta im = item.getItemMeta();
												ArrayList<String> lore = new ArrayList<String>();
												
													lore.add(ChatColor.GRAY + speed.getName() + " II");
											
												if(im.getLore() != null) {
													List<String> oldlore = new ArrayList<String>();
													oldlore = im.getLore();
													oldlore.remove(ChatColor.GRAY + speed.getName() + " I");
													lore.addAll(oldlore);
												}
												im.setLore(lore);
												item.setItemMeta(im);
												e.setCurrentItem(item);
											} else {
												e.setCancelled(true);
											}
										}
									}
								
							} 
						}
					} else if(e.getCursor().containsEnchantment(explosive)) {
						if(e.getCurrentItem().getType() == Material.BOW) {
						
									if(!e.getCurrentItem().containsEnchantment(explosive)) {
									int level = e.getCursor().getEnchantmentLevel(Enchantment.getByName(explosive.getName()));
								e.setCancelled(true);
								e.setCursor(null);
							
								ItemStack item = e.getCurrentItem();
								item.addUnsafeEnchantment(explosive, level);
							
								ItemMeta im = item.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								
								if(level == 1) {
								lore.add(ChatColor.GRAY + explosive.getName() + " I");
								} else if(level == 2) {
									lore.add(ChatColor.GRAY + explosive.getName() + " II");
								} else if(level == 3) {
									lore.add(ChatColor.GRAY + explosive.getName() + " III");
								} 
								if(im.getLore() != null) {
									List<String> oldlore = new ArrayList<String>();
									oldlore = im.getLore();
									lore.addAll(oldlore);
								}
								im.setLore(lore);
								item.setItemMeta(im);
								e.setCurrentItem(item);
									} else {
										 if(e.getCursor().getEnchantmentLevel(explosive) == 1) {
												e.setCancelled(true);
											} else if(e.getCursor().getEnchantmentLevel(explosive) == 2) {
												if(e.getCurrentItem().getEnchantmentLevel(explosive) == 1) {
													int level = 2;
													e.setCancelled(true);
													e.setCursor(null);
												
													ItemStack item = e.getCurrentItem();
													item.removeEnchantment(explosive);
													item.addUnsafeEnchantment(explosive, level);
												
													ItemMeta im = item.getItemMeta();
													ArrayList<String> lore = new ArrayList<String>();
													
														lore.add(ChatColor.GRAY + explosive.getName() + " II");
												
													if(im.getLore() != null) {
														List<String> oldlore = new ArrayList<String>();
														oldlore = im.getLore();
														oldlore.remove(ChatColor.GRAY + explosive.getName() + " I");
														lore.addAll(oldlore);
													}
													im.setLore(lore);
													item.setItemMeta(im);
													e.setCurrentItem(item);
												} else {
													e.setCancelled(true);
												}
											} else if(e.getCursor().getEnchantmentLevel(explosive) == 3) {
												if(e.getCurrentItem().getEnchantmentLevel(explosive) == 2 || e.getCurrentItem().getEnchantmentLevel(explosive) == 1) {
													int level = 3;
													e.setCancelled(true);
													e.setCursor(null);
												
													ItemStack item = e.getCurrentItem();
													item.removeEnchantment(explosive);
													item.addUnsafeEnchantment(explosive, level);
												
													ItemMeta im = item.getItemMeta();
													ArrayList<String> lore = new ArrayList<String>();
													
														lore.add(ChatColor.GRAY + explosive.getName() + " III");
												
													if(im.getLore() != null) {
														List<String> oldlore = new ArrayList<String>();
														oldlore = im.getLore();
														oldlore.remove(ChatColor.GRAY + explosive.getName() + " I");
														oldlore.remove(ChatColor.GRAY + explosive.getName() + " II");
														lore.addAll(oldlore);
													}
													im.setLore(lore);
													item.setItemMeta(im);
													e.setCurrentItem(item);
												
												} else {
													e.setCancelled(true);
												}
											} else {
												e.setCancelled(true);
											}
										
									
								} 
							
						
						
					}
					}
 						
				
			}
				
				}
			
			}
		}
		}
	}

}
