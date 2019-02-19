package com.nisovin.yapp.menu;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

import com.nisovin.yapp.PermissionContainer;

public class RemovePermission extends MenuPrompt {

	public String getPromptText(ConversationContext context) {
		return Menu.TEXT_COLOR + "Please type the permission node you want to remove:";
	}

	@Override
	public Prompt accept(ConversationContext context, String input) {
		PermissionContainer obj = getObject(context);
		String world = getWorld(context);
		input = input.trim();
		obj.removePermission(world, input);
		String msg = Menu.TEXT_COLOR + "Removed permission " + Menu.HIGHLIGHT_COLOR + input + Menu.TEXT_COLOR + " from " + getType(context) + Menu.HIGHLIGHT_COLOR + " " + obj.getName();
		if (world != null) {
			msg += "\n" + Menu.TEXT_COLOR + "for world " + Menu.HIGHLIGHT_COLOR + world;
		}
		return showMessage(context, msg, Menu.MODIFY_OPTIONS);
	}

	@Override
	public Prompt getPreviousPrompt(ConversationContext context) {
		return Menu.MODIFY_OPTIONS;
	}

}
