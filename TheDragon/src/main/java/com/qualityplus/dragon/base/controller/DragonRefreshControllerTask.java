package com.qualityplus.dragon.base.controller;

import com.qualityplus.dragon.base.event.DragonRefreshEvent;
import com.qualityplus.dragon.base.event.DragonRefreshEvent.RefreshType;

import eu.okaeri.platform.bukkit.annotation.Scheduled;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

@Scheduled(rate = 1, delay = 20)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DragonRefreshControllerTask implements Runnable{
    private @Inject Plugin plugin;

    @Override
    public void run() {
        Arrays.stream(RefreshType.values())
                .filter(RefreshType::elapsed)
                .forEach(this::callEvent);
    }

    private void callEvent(RefreshType type){
        plugin.getServer().getPluginManager().callEvent(new DragonRefreshEvent(type));
    }
}
