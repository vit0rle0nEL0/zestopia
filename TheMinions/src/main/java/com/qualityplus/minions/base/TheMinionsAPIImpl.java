package com.qualityplus.minions.base;

import com.qualityplus.assistant.lib.eu.okaeri.injector.annotation.Inject;
import com.qualityplus.minions.api.TheMinionsAPI;
import com.qualityplus.minions.api.config.ConfigFiles;
import com.qualityplus.minions.api.recipe.provider.RecipeProvider;
import com.qualityplus.minions.api.service.MinionsService;
import com.qualityplus.minions.api.service.UserService;
import com.qualityplus.minions.base.config.*;
import com.qualityplus.minions.base.config.upgrades.AutomatedShippingUpgrades;
import com.qualityplus.minions.base.config.upgrades.FuelUpgrades;
import com.qualityplus.minions.base.config.upgrades.NormalUpgrades;

import com.qualityplus.assistant.lib.eu.okaeri.platform.core.annotation.Component;
import lombok.Getter;

@Component
@Getter
public final class TheMinionsAPIImpl implements TheMinionsAPI {
    private @Inject ConfigFiles<Config, Inventories, Messages, Commands, Skins, AutomatedShippingUpgrades, FuelUpgrades, NormalUpgrades> configFiles;
    private @Inject MinionsService minionsService;
    private @Inject RecipeProvider recipeProvider;
    private @Inject UserService userService;
}
