package com.qualityplus.enchanting.base.config.impl;

import com.qualityplus.enchanting.api.config.ConfigFiles;
import com.qualityplus.enchanting.base.config.Commands;
import com.qualityplus.enchanting.base.config.Config;
import com.qualityplus.enchanting.base.config.Inventories;
import com.qualityplus.enchanting.base.config.Messages;

import eu.okaeri.platform.core.annotation.Component;

@Component
public final class EnchantingFiles implements ConfigFiles<Config, Inventories, Messages, Commands> {
    private @Inject Inventories inventories;
    private @Inject Messages messages;
    private @Inject Commands commands;
    private @Inject Config config;

    @Override
    public Config config() {
        return config;
    }

    @Override
    public Inventories inventories() {
        return inventories;
    }

    @Override
    public Messages messages() {
        return messages;
    }

    @Override
    public Commands commands() {
        return commands;
    }

    @Override
    public void reloadFiles() {
        config.load();
        //recipes.load();
        messages.load();
        inventories.load();
        commands.load();
    }
}
