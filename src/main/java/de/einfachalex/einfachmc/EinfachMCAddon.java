package de.einfachalex.einfachmc;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.util.List;

public class EinfachMCAddon extends LabyModAddon {

	private static String prefix = "[EMC-Addon]";
	private String ip = "";
	private static EinfachMCAddon instance;
	
	
	@Override
	protected void fillSettings(List<SettingsElement> arg0) {		
	}

	@Override
	public void loadConfig() {
	}

	@Override
	public void onDisable() {
		System.out.println(prefix + " diabled.");
	}

	@Override
	public void onEnable() {
		System.out.println("EinfachMC Addon enabled.");
		instance = this;
		
		getApi().getEventManager().registerOnJoin(serverData -> {
            ip = serverData.getIp();
            System.out.println(ip);
        });
		
		getApi().getEventManager().register(new MessageSendEvent(){
			public boolean onSend(String message){
				message = message.toLowerCase();
				System.out.println(ip);
				System.out.println("FETTI");
				if(ip.equalsIgnoreCase("einfachmc.de")){
					System.out.println("HALLO ES GEHT");
					switch(message){
						case "/hub":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
							break;
						case "/l":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
							break;
						case "/lobby":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
							break;
						case "/coins":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger coins set 1");
							break;
						case "/gm 0":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 0");
							break;
						case "/gm 1":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 1");
							break;
						case "/gm 2":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 2");
							break;
						case "/gm 3":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 3");
							break;
					}
					return true;
				}		
				System.out.println("KACK ADDON");
				return false;
			}
		});
	}
}