package de.einfachalex.einfachmc;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.core.LabyModCore;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.Gui;

import java.util.List;

public class EinfachMCAddon extends LabyModAddon {

	private static EinfachMCAddon instance;
	
	
	@Override
	protected void fillSettings(List<SettingsElement> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadConfig() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void onEnable() {
		System.out.println("EinfachMC Addon enabled.");
		instance = this;
				
		getApi().getEventManager().register(new MessageSendEvent(){
			public boolean onSend(String message){
				message = message.toLowerCase();
				if ((message.startsWith("/hub")) || (message.startsWith("/l")) || (message.startsWith("/lobby"))){
					LabyModCore.getMinecraft().getPlayer().sendChatMessage("/trigger hub set 1");
					return true;
				}
				return false;
			}
		});
		
		getApi().getEventManager().register(new MessageSendEvent(){
			public boolean onSend(String message){
				message = message.toLowerCase();
				
				switch(message){
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
				return false;
			}
		});
	}	
}