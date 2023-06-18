package com.qualityplus.alchemist.base.commands;

import com.qualityplus.alchemist.api.box.Box;
import com.qualityplus.alchemist.base.config.Messages;
import com.qualityplus.assistant.TheAssistantPlugin;
import com.qualityplus.assistant.api.commands.command.AssistantCommand;
import eu.okaeri.commons.bukkit.time.MinecraftTimeEquivalent;

import eu.okaeri.platform.bukkit.annotation.Delayed;
import eu.okaeri.platform.core.annotation.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

/**
 * Command to get all commands usages
 */
@Component
public final class HelpCommand extends AssistantCommand {
    private @Inject Box box;

    @Override
    public boolean execute(final CommandSender sender, final String[] args) {
        final Messages.PluginMessages msg = this.box.getFiles().messages().getPluginMessages();

        this.sendHelpCommands(
                sender,
                args,
                TheAssistantPlugin.getAPI().getCommandProvider(),
                msg.getHelpHeader(),
                msg.getHelpMessage(),
                msg.getHelpfooter(),
                msg.getNextPage(),
                msg.getPreviousPage(),
                msg.getHelpPageHoverMessage()
        );

        return true;
    }

    @Override
    public List<String> onTabComplete(final CommandSender commandSender, final Command command, final String label, final String[] args) {
        return Collections.emptyList();
    }

    /**
     * Register command
     *
     * @param box {@link Box}
     */
    @Delayed(time = MinecraftTimeEquivalent.SECOND)
    public void register(@Inject final Box box) {
        TheAssistantPlugin.getAPI()
                .getCommandProvider()
                .registerCommand(this, e -> e.getCommand().setDetails(box.getFiles().commands().getHelpCommand()));
    }
}
