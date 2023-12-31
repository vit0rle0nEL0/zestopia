package com.qualityplus.crafting.base.recipes;

import com.qualityplus.crafting.api.recipes.IRecipe;
import lombok.AllArgsConstructor;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public final class VanillaRecipe implements IRecipe {
    private final ItemStack result;

    @Override
    public ItemStack getResult() {
        return result;
    }
}
