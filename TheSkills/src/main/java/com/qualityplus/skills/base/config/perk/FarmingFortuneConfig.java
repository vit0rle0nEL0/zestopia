package com.qualityplus.skills.base.config.perk;

import com.qualityplus.assistant.lib.com.cryptomorin.xseries.XMaterial;
import com.qualityplus.skills.base.perk.Perk;
import com.qualityplus.skills.base.perk.perks.FarmingFortunePerk;
import com.qualityplus.skills.base.skill.gui.GUIOptions;
import com.qualityplus.assistant.lib.eu.okaeri.configs.OkaeriConfig;
import com.qualityplus.assistant.lib.eu.okaeri.configs.annotation.Header;
import com.qualityplus.assistant.lib.eu.okaeri.configs.annotation.NameModifier;
import com.qualityplus.assistant.lib.eu.okaeri.configs.annotation.NameStrategy;
import com.qualityplus.assistant.lib.eu.okaeri.configs.annotation.Names;
import com.qualityplus.assistant.lib.eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for farming fortune config
 */
@Getter
@Setter
@Configuration(path = "perks/farming_fortune_perk.yml")
@Header("================================")
@Header("       Farming Fortune Perk      ")
@Header("================================")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public final class FarmingFortuneConfig extends OkaeriConfig implements PerkFile {
    private String id = "farming_fortune";
    private boolean enabled = true;
    private String displayName = "Farming Fortune";
    private List<String> description = Arrays.asList("  &a%percent%% &7chance to get &a%multiplier%x &7drops", "  &7when break crops.");
    private int maxLevel = 50;
    private GUIOptions guiOptions = GUIOptions.builder()
            .slot(13)
            .page(1)
            .item(XMaterial.PLAYER_HEAD)
            .texture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2F" +
                    "hNTk2NmExNDcyNDQ1MDRjYzU2ZWY2ZWZkMmQyZjQ0NzM4YjhmMDNkOTNhNjE3NjZhZjNmYzQ0ODdmOTgwYiJ9fX0=")
            .mainMenuLore(Collections.singletonList("%skill_farming_fortune_description%"))
            .build();

    /**
     * Adds a perk
     *
     * @return {@link FarmingFortunePerk}
     */
    public Perk getPerk() {
        return FarmingFortunePerk.builder()
                .id(this.id)
                .displayName(this.displayName)
                .description(this.description)
                .enabled(this.enabled)
                .skillGUIOptions(this.guiOptions)
                .chancePerLevel(0.1)
                .initialAmount(0)
                .allowedMaterials(Arrays.asList(
                        XMaterial.WHEAT,
                        XMaterial.CARROTS,
                        XMaterial.POTATOES))
                .build();
    }
}
