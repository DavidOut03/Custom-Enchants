package global.customenchants.Utils;

import net.md_5.bungee.api.ChatColor;

public class AlternateCodes {

	public static String format(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
