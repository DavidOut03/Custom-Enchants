package global.customenchants.Enchantments;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import global.customenchants.Core.Main;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Enchantment_Explosive extends Enchantment implements Listener {

	public Enchantment_Explosive(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onLand(ProjectileLaunchEvent e) {
		
		if(e.getEntity().getShooter() instanceof Player) {
			if(e.getEntity().getType() == EntityType.ARROW) {
				Arrow arrow = (Arrow) e.getEntity();
				Player p = (Player) e.getEntity().getShooter();
				
				if(p.getItemInHand().getType() == Material.BOW) {
				if(p.getItemInHand().containsEnchantment(this)) {
					 int size = p.getItemInHand().getEnchantmentLevel(this);
				BukkitTask run = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {

					@Override
					public void run() {
						if(arrow.isOnGround() || arrow.doesBounce() || arrow.isInsideVehicle() || arrow.isDead()) {
							arrow.getWorld().createExplosion(arrow.getLocation(), size, false);
							
							arrow.remove();
							Bukkit.getServer().getScheduler().cancelAllTasks();
						} else {
							PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true, (float) arrow.getLocation().getX(), (float)arrow.getLocation().getY(), (float)arrow.getLocation().getZ(), 0, 0, 0, 0, 0);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
						}
					}
						
					}, 0L, 0L);
					
				}
				}
			}
		}
	}
	
	@Override
	public int getId() {
		return 107;
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
		return 3;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Explosive";
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

}
