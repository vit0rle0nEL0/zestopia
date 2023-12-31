package com.qualityplus.minions.api;

import com.qualityplus.minions.api.config.ConfigFiles;
import com.qualityplus.minions.api.recipe.provider.RecipeProvider;
import com.qualityplus.minions.api.service.MinionsService;
import com.qualityplus.minions.api.service.UserService;
import com.qualityplus.minions.base.config.*;
import com.qualityplus.minions.base.config.upgrades.AutomatedShippingUpgrades;
import com.qualityplus.minions.base.config.upgrades.FuelUpgrades;
import com.qualityplus.minions.base.config.upgrades.NormalUpgrades;

public interface TheMinionsAPI {
    ConfigFiles<Config, Inventories, Messages, Commands, Skins, AutomatedShippingUpgrades, FuelUpgrades, NormalUpgrades> getConfigFiles();
    MinionsService getMinionsService();
    RecipeProvider getRecipeProvider();
    UserService getUserService();
}
