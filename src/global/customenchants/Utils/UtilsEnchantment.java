package global.customenchants.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
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
import net.md_5.bungee.api.ChatColor;

public class UtilsEnchantment {

	static List<ItemStack> enchantments = new ArrayList<ItemStack>();
	
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
	
	private void setCommonEnchantments() {
		enchantments.clear();
		ItemStack asm = new ItemStack(Material.ENCHANTED_BOOK);
		asm.addUnsafeEnchantment(autosmelt, 1);
		ItemMeta asmim = asm.getItemMeta();
		ArrayList<String> asmlore = new ArrayList<String>();
		asmlore.add(ChatColor.GRAY + autosmelt.getName() + " I");
		asmlore.add("");
		asmlore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		asmlore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		asmim.setLore(asmlore);
		asm.setItemMeta(asmim);
		enchantments.add(asm);
		
		ItemStack c4 = new ItemStack(Material.ENCHANTED_BOOK);
		c4.addUnsafeEnchantment(explosive, 1);
		ItemMeta c4m = c4.getItemMeta();
		ArrayList<String> c4lore = new ArrayList<String>();
		c4lore.add(ChatColor.GRAY + explosive.getName() + " I");
		c4lore.add("");
		c4lore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		c4lore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		c4m.setLore(c4lore);
		c4.setItemMeta(c4m);
		enchantments.add(c4);
		
		
		ItemStack jelly = new ItemStack(Material.ENCHANTED_BOOK);
		jelly.addUnsafeEnchantment(jellylegs, 1);
		ItemMeta jellym = jelly.getItemMeta();
		ArrayList<String> jellylore = new ArrayList<String>();
		jellylore.add(ChatColor.GRAY + jellylegs.getName() + " I");
		jellylore.add("");
		jellylore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		jellylore.add(AlternateCodes.format("&7Enchantable items: &dLeggings"));
		jellym.setLore(jellylore);
		jelly.setItemMeta(jellym);
		enchantments.add(jelly);
		
		ItemStack bright = new ItemStack(Material.ENCHANTED_BOOK);
		bright.addUnsafeEnchantment(fullbright, 1);
		ItemMeta bm = bright.getItemMeta();
		ArrayList<String> blore = new ArrayList<String>();
		blore.add(ChatColor.GRAY + fullbright.getName() + " I");
		blore.add("");
		blore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		blore.add(AlternateCodes.format("&7Enchantable items: &Helmet"));
		bm.setLore(blore);
		bright.setItemMeta(bm);
		enchantments.add(bright);
		
		ItemStack fress = new ItemStack(Material.ENCHANTED_BOOK);
		fress.addUnsafeEnchantment(fireresistance, 1);
		ItemMeta fressm = fress.getItemMeta();
		ArrayList<String> fresslore = new ArrayList<String>();
		fresslore.add(ChatColor.GRAY + fireresistance.getName() + " I");
		fresslore.add("");
		fresslore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		fresslore.add(AlternateCodes.format("&7Enchantable items: &dChestplates"));
		fressm.setLore(fresslore);
		fress.setItemMeta(fressm);
		enchantments.add(fress);
		
		ItemStack rdo = new ItemStack(Material.ENCHANTED_BOOK);
		rdo.addUnsafeEnchantment(randomore, 1);
		ItemMeta rdom = rdo.getItemMeta();
		ArrayList<String> rdolore = new ArrayList<String>();
		rdolore.add(ChatColor.GRAY + randomore.getName() + " I");
		rdolore.add("");
		rdolore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		rdolore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		rdom.setLore(rdolore);
		rdo.setItemMeta(rdom);
		enchantments.add(rdo);
		
		ItemStack tp = new ItemStack(Material.ENCHANTED_BOOK);
		tp.addUnsafeEnchantment(telepathy, 1);
		ItemMeta tpm = tp.getItemMeta();
		ArrayList<String> tplore = new ArrayList<String>();
		tplore.add(ChatColor.GRAY + telepathy.getName() + " I");
		tplore.add("");
		tplore.add(AlternateCodes.format("&7Rarity: &aCommon"));
		tplore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		tpm.setLore(tplore);
		tp.setItemMeta(tpm);
		enchantments.add(tp);
	
	}
	public void sendCommonEnchantment(Player p) {
		setCommonEnchantments();
		Random r = new Random();
		int choice = r.nextInt(enchantments.size());
		ItemStack chosen = enchantments.get(choice);
		p.getInventory().addItem(chosen);
	}
	
	private void setEpicEnchantments() {
		enchantments.clear();
		ItemStack fb = new ItemStack(Material.ENCHANTED_BOOK);
		fb.addUnsafeEnchantment(fastbow, 1);
		ItemMeta fbm = fb.getItemMeta();
		ArrayList<String> fblore = new ArrayList<String>();
		fblore.add(ChatColor.GRAY + fastbow.getName() + " I");
		fblore.add("");
		fblore.add(AlternateCodes.format("&7Rarity: &bEpic"));
		fblore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		fbm.setLore(fblore);
		fb.setItemMeta(fbm);
		enchantments.add(fb);
		

		ItemStack sp = new ItemStack(Material.ENCHANTED_BOOK);
		sp.addUnsafeEnchantment(speed, 1);
		ItemMeta spm = sp.getItemMeta();
		ArrayList<String> splore = new ArrayList<String>();
		splore.add(ChatColor.GRAY + speed.getName() + " I");
		splore.add("");
		splore.add(AlternateCodes.format("&7Rarity: &bEpic"));
		splore.add(AlternateCodes.format("&7Enchantable items: &dBoots"));
		spm.setLore(splore);
		sp.setItemMeta(spm);
		enchantments.add(sp);
		
		ItemStack lj = new ItemStack(Material.ENCHANTED_BOOK);
		lj.addUnsafeEnchantment(lumberjack, 1);
		ItemMeta lbm = lj.getItemMeta();
		ArrayList<String> ljlore = new ArrayList<String>();
		ljlore.add(ChatColor.GRAY + lumberjack.getName() + " I");
		ljlore.add("");
		ljlore.add(AlternateCodes.format("&7Rarity: &bEpic"));
		ljlore.add(AlternateCodes.format("&7Enchantable items: &dAxes"));
		lbm.setLore(ljlore);
		lj.setItemMeta(lbm);
		enchantments.add(lj);
		
		ItemStack c4 = new ItemStack(Material.ENCHANTED_BOOK);
		c4.addUnsafeEnchantment(explosive, 2);
		ItemMeta c4m = c4.getItemMeta();
		ArrayList<String> c4lore = new ArrayList<String>();
		c4lore.add(ChatColor.GRAY + explosive.getName() + " II");
		c4lore.add("");
		c4lore.add(AlternateCodes.format("&7Rarity: &bEpic"));
		c4lore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		c4m.setLore(c4lore);
		c4.setItemMeta(c4m);
		enchantments.add(c4);
		
		ItemStack jelly = new ItemStack(Material.ENCHANTED_BOOK);
		jelly.addUnsafeEnchantment(jellylegs, 2);
		ItemMeta jellym = jelly.getItemMeta();
		ArrayList<String> jellylore = new ArrayList<String>();
		jellylore.add(ChatColor.GRAY + jellylegs.getName() + " II");
		jellylore.add("");
		jellylore.add(AlternateCodes.format("&7Rarity: &bEpic"));
		jellylore.add(AlternateCodes.format("&7Enchantable items: &dLeggings"));
		jellym.setLore(jellylore);
		jelly.setItemMeta(jellym);
		enchantments.add(jelly);
		
		ItemStack jelly1 = new ItemStack(Material.ENCHANTED_BOOK);
		jelly1.addUnsafeEnchantment(jellylegs, 3);
		ItemMeta jellym1 = jelly1.getItemMeta();
		ArrayList<String> jellylore1 = new ArrayList<String>();
		jellylore1.add(ChatColor.GRAY + jellylegs.getName() + " III");
		jellylore1.add("");
		jellylore1.add(AlternateCodes.format("&7Rarity: &bEpic"));
		jellylore1.add(AlternateCodes.format("&7Enchantable items: &dLeggings"));
		jellym1.setLore(jellylore1);
		jelly1.setItemMeta(jellym1);
		enchantments.add(jelly1);
		
		ItemStack rdo = new ItemStack(Material.ENCHANTED_BOOK);
		rdo.addUnsafeEnchantment(randomore, 2);
		ItemMeta rdom = rdo.getItemMeta();
		ArrayList<String> rdolore = new ArrayList<String>();
		rdolore.add(ChatColor.GRAY + randomore.getName() + " II");
		rdolore.add("");
		rdolore.add(AlternateCodes.format("&7Rarity: &bEpic"));
		rdolore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		rdom.setLore(rdolore);
		rdo.setItemMeta(rdom);
		enchantments.add(rdo);
	
	}
	public void sendEpicEnchantment(Player p) {
		setEpicEnchantments();
		Random r = new Random();
		int choice = r.nextInt(enchantments.size());
		ItemStack chosen = enchantments.get(choice);
		p.getInventory().addItem(chosen);
	}
	
	private void setLegendaryEnchantments() {
		enchantments.clear();
		ItemStack mb = new ItemStack(Material.ENCHANTED_BOOK);
		mb.addUnsafeEnchantment(multiblock, 1);
		ItemMeta mbm = mb.getItemMeta();
		ArrayList<String> mblore = new ArrayList<String>();
		mblore.add(ChatColor.GRAY + multiblock.getName() + " I");
		mblore.add("");
		mblore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
		mblore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		mbm.setLore(mblore);
		mb.setItemMeta(mbm);
		enchantments.add(mb);
		
		ItemStack c4 = new ItemStack(Material.ENCHANTED_BOOK);
		c4.addUnsafeEnchantment(explosive, 3);
		ItemMeta c4m = c4.getItemMeta();
		ArrayList<String> c4lore = new ArrayList<String>();
		c4lore.add(ChatColor.GRAY + explosive.getName() + " III");
		c4lore.add("");
		c4lore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
		c4lore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		c4m.setLore(c4lore);
		c4.setItemMeta(c4m);
		enchantments.add(c4);
		
		ItemStack jelly = new ItemStack(Material.ENCHANTED_BOOK);
		jelly.addUnsafeEnchantment(jellylegs, 4);
		ItemMeta jellym = jelly.getItemMeta();
		ArrayList<String> jellylore = new ArrayList<String>();
		jellylore.add(ChatColor.GRAY + jellylegs.getName() + " IV");
		jellylore.add("");
		jellylore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
		jellylore.add(AlternateCodes.format("&7Enchantable items: &dLeggings"));
		jellym.setLore(jellylore);
		jelly.setItemMeta(jellym);
		enchantments.add(jelly);
		
		ItemStack sp = new ItemStack(Material.ENCHANTED_BOOK);
		sp.addUnsafeEnchantment(speed, 2);
		ItemMeta spm = sp.getItemMeta();
		ArrayList<String> splore = new ArrayList<String>();
		splore.add(ChatColor.GRAY + speed.getName() + " II");
		splore.add("");
		splore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
		splore.add(AlternateCodes.format("&7Enchantable items: &dBoots"));
		spm.setLore(splore);
		sp.setItemMeta(spm);
		enchantments.add(sp);
		
		ItemStack rdo = new ItemStack(Material.ENCHANTED_BOOK);
		rdo.addUnsafeEnchantment(randomore, 3);
		ItemMeta rdom = rdo.getItemMeta();
		ArrayList<String> rdolore = new ArrayList<String>();
		rdolore.add(ChatColor.GRAY + randomore.getName() + " III");
		rdolore.add("");
		rdolore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
		rdolore.add(AlternateCodes.format("&7Enchantable items: &dPickaxes"));
		rdom.setLore(rdolore);
		rdo.setItemMeta(rdom);
		enchantments.add(rdo);
		
		ItemStack fb = new ItemStack(Material.ENCHANTED_BOOK);
		fb.addUnsafeEnchantment(fastbow, 1);
		ItemMeta fbm = fb.getItemMeta();
		ArrayList<String> fblore = new ArrayList<String>();
		fblore.add(ChatColor.GRAY + fastbow.getName() + " I");
		fblore.add("");
		fblore.add(AlternateCodes.format("&7Rarity: &5Legendary"));
		fblore.add(AlternateCodes.format("&7Enchantable items: &dBow"));
		fbm.setLore(fblore);
		fb.setItemMeta(fbm);
		enchantments.add(fb);
	
	}
	public void sendLegendaryEnchantment(Player p) {
		setLegendaryEnchantments();
		Random r = new Random();
		int choice = r.nextInt(enchantments.size());
		ItemStack chosen = enchantments.get(choice);
		p.getInventory().addItem(chosen);
	}
	
	
}
