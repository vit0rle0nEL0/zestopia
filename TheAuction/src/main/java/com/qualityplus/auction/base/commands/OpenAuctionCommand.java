package com.qualityplus.auction.base.commands;

import com.qualityplus.assistant.TheAssistantPlugin;
import com.qualityplus.assistant.api.commands.command.AssistantCommand;
import com.qualityplus.assistant.util.StringUtils;
import com.qualityplus.auction.api.box.Box;
import com.qualityplus.auction.base.gui.main.MainAuctionGUI;
import com.qualityplus.auction.util.AuctionFilterUtil;
import eu.okaeri.commons.bukkit.time.MinecraftTimeEquivalent;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.bukkit.annotation.Delayed;
import eu.okaeri.platform.core.annotation.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

@Component
public final class OpenAuctionCommand extends AssistantCommand {
    private @Inject Box box;

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        String syntaxMsg = StringUtils.color(box.files().messages().pluginMessages.useSyntax.replace("%usage%", syntax));
        String mustBeAPlayer = StringUtils.color(box.files().messages().pluginMessages.mustBeAPlayer.replace("%usage%", syntax));
        String invalidPlayer = StringUtils.color(box.files().messages().pluginMessages.invalidPlayer.replace("%usage%", syntax));

        Player player = (Player) sender;

        return openInventory(args, sender, new MainAuctionGUI(box, AuctionFilterUtil.getSearcher(box), player.getUniqueId()), syntaxMsg, mustBeAPlayer, invalidPlayer);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {
        return args.length == 2 ? null : Collections.emptyList();
    }

    @Delayed(time = MinecraftTimeEquivalent.SECOND)
    public void register(@Inject Box box){
        TheAssistantPlugin.getAPI().getCommandProvider().registerCommand(this, e -> e.getCommand().setDetails(box.files().commands().openCommand));
    }
}