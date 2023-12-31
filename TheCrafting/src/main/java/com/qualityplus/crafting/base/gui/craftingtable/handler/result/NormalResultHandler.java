package com.qualityplus.crafting.base.gui.craftingtable.handler.result;

import com.qualityplus.assistant.api.util.BukkitItemUtil;
import com.qualityplus.assistant.util.inventory.InventoryUtils;
import com.qualityplus.crafting.api.box.Box;
import com.qualityplus.crafting.api.recipes.IRecipe;
import com.qualityplus.crafting.base.gui.craftingtable.handler.CommonHandler;
import com.qualityplus.crafting.base.recipes.CustomRecipe;
import com.qualityplus.crafting.base.recipes.VanillaRecipe;
import com.qualityplus.crafting.util.CraftingFinderUtil;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@AllArgsConstructor
public final class NormalResultHandler implements CommonHandler {
    //Fake Slot | Special Slot
    private final Map<Integer, Integer> tableRelationSlots;
    private final TableClickHandler clickHandler;
    private final Inventory inventory;
    private final InventoryView view;
    private final Box box;

    public void handle(Player player, InventoryClickEvent event, IRecipe automatic, boolean isAuto){
        if(!event.isLeftClick()) return;

        ItemStack itemStack = event.getCurrentItem();

        ItemStack cursor = event.getCursor();

        if(BukkitItemUtil.isNull(itemStack)) return;

        if(isEmptyCrafting(itemStack)) return;

        if(isAuto && automatic == null) return;

        IRecipe recipe = isAuto ? automatic : CraftingFinderUtil.getCraftingRecipe(inventory, view, tableRelationSlots);

        if(recipe == null) return;

        if(box.files().blockedCraftings().isBlocked(recipe)) return;

        ItemStack result = recipe.getResult().clone();

        if(BukkitItemUtil.isNull(cursor)) {
            player.setItemOnCursor(result);
        }else if(cursor.isSimilar(result)) {
            player.setItemOnCursor(BukkitItemUtil.getItemWithAdd(cursor, result.getAmount()));
        } else
            return;


        if(isAuto){
            removeItemsFromInventory(player, (CustomRecipe) recipe);
        }else{
            if(recipe instanceof VanillaRecipe)
                removeItemsOneByOne(inventory, tableRelationSlots);
            else
                removeOneByOneRecipe((CustomRecipe) recipe, inventory, tableRelationSlots);
        }

        clickHandler.handleClick(player);
    }

    private void removeItemsFromInventory(Player player, CustomRecipe recipe){
        recipe.getIngredients().values()
                .stream()
                .filter(item -> !BukkitItemUtil.isNull(item))
                .forEach(item -> InventoryUtils.removeItems(player.getInventory(), item, item.getAmount()));
    }
}
