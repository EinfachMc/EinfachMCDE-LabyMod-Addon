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
		System.out.println(prefix+" EinfachMC Addon enabled.");
		instance = this;
		
		getApi().getEventManager().registerOnJoin(serverData -> {
            ip = serverData.getIp();
        });       


		
		getApi().getEventManager().register(new MessageSendEvent(){
			public boolean onSend(String message){
				message = message.toLowerCase();
				if(ip.equalsIgnoreCase("einfachmc.de")){
					switch(message){
						case "/hub":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
							return true;
						case "/l":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
							return true;
						case "/lobby":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
							return true;
						case "/coins":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger coins set 1");
							return true;
						case "/gm 0":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 0");
							return true;
						case "/gm 1":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 1");
							return true;
						case "/gm 2":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 2");
							return true;
						case "/gm 3":
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/gamemode 3");
							return true;
					}
					
				}		
				return false;
			}
		});
	}
}
