package global.customenchants.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
import global.customenchants.Enchantments.Enchantment_Telepathy;
import global.customenchants.Enchantments.Enchantment_Speed;
import global.customenchants.GUI.GUI_Enchant;
import global.customenchants.Utils.AlternateCodes;
import global.customenchants.Utils.Message;
import net.md_5.bungee.api.ChatColor;

public class Command_CustomEnchant implements CommandExecutor {

	Material[] pickaxe = {Material.DIAMOND_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.STONE_PICKAXE, Material.WOOD_PICKAXE};
	Material[] axe = {Material.DIAMOND_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.STONE_AXE, Material.WOOD_AXE};
	Material[] shovel = {Material.DIAMOND_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.STONE_SPADE, Material.WOOD_SPADE};
	Material[] hoe = {Material.DIAMOND_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.STONE_HOE, Material.WOOD_HOE};
	Material[] leggings = {Material.DIAMOND_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.LEATHER_LEGGINGS};
	Material[] boots = {Material.DIAMOND_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.LEATHER_BOOTS};
	Material[] helmet = {Material.DIAMOND_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.CHAINMAIL_HELMET, Material.LEATHER_HELMET};
	Material[] chestplate = {Material.DIAMOND_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_CHESTPLATE};
	
	public Enchantment multiblock = new Enchantment_Multiblock(101);
	public Enchantment autosmelt = new Enchantment_AutoSmelt(102);
	public Enchantment jellylegs = new Enchantment_JellyLegs(103);
	public Enchantment fireresistance = new Enchantment_FireResistance(104);
	public Enchantment speed = new Enchantment_Speed(105);
	public Enchantment fastbow = new Enchantment_FastBow(106);
	public Enchantment explosive = new Enchantment_Explosive(107);
	public Enchantment randomore = new Enchantment_RandomOre(108);
	public Enchantment telepathy = new Enchantment_Telepathy(109);
	public Enchantment lumberjack = new Enchantment_Lumberjack(110);
	public Enchantment fullbright = new Enchantment_Fullbright(111);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("customenchant") || cmd.getName().equalsIgnoreCase("ce")) {
			if(sender instanceof Player) {
			if(sender.hasPermission("customenchants.enchant")) {
				Player p = (Player) sender;
				if(args.length == 0) {
					sendHelp(p);
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("enchant")) {
						GUI_Enchant.sendGUI(p);
					} else {
						sendHelp(p);
					}
				} else if(args.length == 2) {
					sendHelp(p);
				} else if(args.length == 3) {
					if(args[0].equalsIgnoreCase("enchant")) {
						int level = 0;
						try {
							level = Integer.parseInt(args[2]);
						} catch (NumberFormatException ex) {
							p.sendMessage(AlternateCodes.format("&c" + args[2] + " is not a number."));
							return false;
						}
						if(args[1].equals("autosmelt")) {
							if(level == 1) {
								for(Material mat : pickaxe) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + autosmelt.getName() + " &7level &a" + level + "&7."));
										}
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for autosmelt."));
							}
						} else if(args[1].equals("fullbright")) {
								if(level == 1) {
									for(Material mat : helmet) {
										if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
											if(p.getItemInHand().getType() == mat) {
												ItemStack item = p.getItemInHand();
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
												p.getInventory().setItemInHand(item);
												p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + fullbright.getName() + " &7level &a" + level + "&7."));
											}
										} else {
											p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
										}
									}
								} else {
									p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for autosmelt."));
								}
						} else if(args[1].equals("lumberjack")) {
							if(level == 1) {
								for(Material mat : axe) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + lumberjack.getName() + " &7level &a" + level + "&7."));
										}
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for autosmelt."));
							}
						} else if(args[1].equalsIgnoreCase("telepathy")) {
							if(level == 1) {
							
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										
											

													
													
														ItemStack item = p.getItemInHand();
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
														p.getInventory().setItemInHand(item);
														p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + telepathy.getName() + " &7level &a" + level + "&7."));
													
													
														
											
										
											
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for telepathy."));
							}
						} else if(args[1].equals("explosive")) {
							if(level == 1 || level == 2 || level == 3) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == Material.BOW) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + explosive.getName() + " &7level &a" + level + "&7."));
										} 
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 3 is the max level for explosive."));
							}
						} else if(args[1].equals("fastbow")) {
							if(level == 1) {
					
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == Material.BOW) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + fastbow.getName() + " &7level &a" + level + "&7."));
										} 
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for fastbow."));
							}
						} else if(args[1].equals("fireresistance")) {
							if(level == 1) {
								for(Material mat : leggings) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + fireresistance.getName() + " &7level &a" + level + "&7."));
										}
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for fireresistance."));
							}
						} else if(args[1].equals("jellylegs")) {
							if(level == 1 || level == 2 || level == 3 || level == 4) {
								for(Material mat : leggings) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + jellylegs.getName() + " &7level &a" + level + "&7."));
										} 
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 4 is the max level for jellylegs."));
							}
						} else if(args[1].equals("multiblock")) {
							if(level == 1) {
								for(Material mat : pickaxe) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + multiblock.getName() + " &7level &a" + level + "&7."));
										} 
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for multiblock."));
							}
						} else if(args[1].equals("speed")) {
							if(level == 1 || level == 2) {
								for(Material mat : boots) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + speed.getName() + " &7level &a" + level + "&7."));
										} 
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								}
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 2 is the max level for speed."));
							}
						} else if(args[1].equals("randomore")) {
							if(level == 1 || level == 2 || level == 3) {
									if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR) {
										
										for(Material mat : pickaxe) {
											if(p.getItemInHand().getType() == mat) {
											ItemStack item = p.getItemInHand();
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
											p.getInventory().setItemInHand(item);
											p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + randomore.getName() + " &7level &a" + level + "&7."));
										} 
									}
									} else {
										p.sendMessage(AlternateCodes.format("&cYou have to hold an item in your hand."));
									}
								
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 3 is the max level for randomore."));
							}
						} else {
							p.sendMessage(AlternateCodes.format("&c"+args[1] + " is not a enchantment."));
						}
					} else if(args[0].equalsIgnoreCase("give")) {
						int level;
						try {
							level = Integer.parseInt(args[2]);
						} catch (NumberFormatException ex) {
							p.sendMessage(AlternateCodes.format( "&c" + args[2] + " is not a number."));
							return false;
						}
						if(args[1].equals("autosmelt")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(autosmelt, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + autosmelt.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
								im.setLore(lore);

								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + autosmelt.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for autosmelt."));
							}
						} else if(args[1].equals("fullbright")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(fullbright, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + fullbright.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
								im.setLore(lore);

								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + fullbright.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for autosmelt."));
							}
						} else if(args[1].equals("lumberjack")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(lumberjack, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + lumberjack.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dAxes"));
								im.setLore(lore);

								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + lumberjack.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for autosmelt."));
							}
						} else if(args[1].equals("explosive")) {
							if(level == 1 || level == 2 || level == 3) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(explosive, level);
								ItemMeta im = enchant.getItemMeta();	
								ArrayList<String> lore = new ArrayList<String>();
								if(level == 1) {
									lore.add(ChatColor.GRAY + explosive.getName() + " I");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								} else if(level == 2) {
									lore.add(ChatColor.GRAY + explosive.getName() + " II");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								} else if(level == 3) {
									lore.add(ChatColor.GRAY + explosive.getName() + " III");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
								}
								
								lore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + explosive.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 3 is the max level for explosive."));
							}
						} else if(args[1].equals("randomore")) {
							if(level == 1 || level == 2 || level == 3) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(randomore, level);
								ItemMeta im = enchant.getItemMeta();	
								ArrayList<String> lore = new ArrayList<String>();
								if(level == 1) {
									lore.add(ChatColor.GRAY + randomore.getName() + " I");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								} else if(level == 2) {
									lore.add(ChatColor.GRAY + randomore.getName() + " II");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								} else if(level == 3) {
									lore.add(ChatColor.GRAY + randomore.getName() + " III");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
								}
								
								lore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + randomore.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 3 is the max level for randomore."));
							}
						} else if(args[1].equals("fastbow")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(fastbow, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + fastbow.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + fastbow.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for fastbow."));
							}
						} else if(args[1].equals("fireresistance")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(fireresistance, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + fireresistance.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dChestplates"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + fireresistance.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for fireresistance."));
							}
						} else if(args[1].equals("telepathy")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(telepathy, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + telepathy.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dTools"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + telepathy.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for telepathy."));
							}
						} else if(args[1].equals("jellylegs")) {
							if(level == 1 || level == 2 || level == 3 || level == 4) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(jellylegs, level);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								if(level == 1) {
									lore.add(ChatColor.GRAY + jellylegs.getName() + " I");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
								} else if(level == 2) {
									lore.add(ChatColor.GRAY + jellylegs.getName() + " II");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								} else if(level == 3) {
									lore.add(ChatColor.GRAY + jellylegs.getName() + " III");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								} else if(level == 4) {
									lore.add(ChatColor.GRAY + jellylegs.getName() + " IV");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
								}
								lore.add(AlternateCodes.format("&7Enchantable items: &dLeggings"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + jellylegs.getName() + " &7level &a" + level + "&7."));
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 4 is the max level for jellylegs."));
							}
						} else if(args[1].equals("multiblock")) {
							if(level == 1) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(multiblock, 1);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								lore.add(ChatColor.GRAY + multiblock.getName() + " I");
								lore.add("");
								lore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
								lore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + multiblock.getName() + " &7level &a" + level + "&7."));
								
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 1 is the max level for multiblock."));
							}
						} else if(args[1].equals("speed")) {
							if(level == 1 || level == 2) {
								ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK);
								enchant.addUnsafeEnchantment(speed, level);
								ItemMeta im = enchant.getItemMeta();
								ArrayList<String> lore = new ArrayList<String>();
								if(level == 1) {
									lore.add(ChatColor.GRAY + speed.getName() + " I");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
								} else if(level == 2) {	
									lore.add(ChatColor.GRAY + speed.getName() + " II");
									lore.add("");
									lore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
								}
								lore.add(AlternateCodes.format("&7Enchantable items: &dBoots"));
								im.setLore(lore);
								enchant.setItemMeta(im);
								p.getInventory().addItem(enchant);
								p.sendMessage(AlternateCodes.format(Message.prefix + "&7Gave you the enchantment &6" + speed.getName() + " &7level &a" + level + "&7."));
								
							} else {
								p.sendMessage(AlternateCodes.format("&cLevel 2 is the max level for speed."));
							}
						} else {
							p.sendMessage(AlternateCodes.format("&c" + args[1] + " is not a enchant."));
						}
					}
				
					
 				} else if(args.length == 4) {
 					
 					
 				}
			} else {
				GUI_Enchant.sendGUI((Player) sender);
			}
			} else {
				sender.sendMessage(AlternateCodes.format(Message.console));
			}
		
			}
		return false;
	}
	
	public static void sendHelp(Player p) {
		p.sendMessage(AlternateCodes.format("&8————————————————————————————————————————————————————————————————————————————"));
		p.sendMessage(AlternateCodes.format("&6/customenchant help&7: Shows the help."));
		p.sendMessage(AlternateCodes.format("&6/customenchant enchant [enchantment] [level]&7: Shows the help."));
		p.sendMessage(AlternateCodes.format("&6/customenchant give [enchantment] [level]&7: Give a player an enchant."));
		p.sendMessage(AlternateCodes.format("&6/customenchant list&7: See the custom enchants."));
		p.sendMessage(AlternateCodes.format("&8————————————————————————————————————————————————————————————————————————————"));
	}

}
