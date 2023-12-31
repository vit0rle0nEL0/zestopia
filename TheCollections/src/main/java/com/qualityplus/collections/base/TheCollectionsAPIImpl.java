package com.qualityplus.collections.base;

import com.qualityplus.assistant.lib.eu.okaeri.injector.annotation.Inject;
import com.qualityplus.collections.api.TheCollectionsAPI;
import com.qualityplus.collections.api.service.CollectionsService;

import com.qualityplus.assistant.lib.eu.okaeri.platform.core.annotation.Component;
import lombok.Getter;
import org.bukkit.plugin.Plugin;

@Component
public final class TheCollectionsAPIImpl implements TheCollectionsAPI {
    private @Getter @Inject CollectionsService collectionsService;
    private @Getter @Inject Plugin plugin;
}
