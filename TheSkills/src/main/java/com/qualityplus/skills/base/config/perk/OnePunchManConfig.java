package com.qualityplus.skills.base.config.perk;

import com.qualityplus.assistant.lib.com.cryptomorin.xseries.XMaterial;
import com.qualityplus.skills.base.perk.Perk;
import com.qualityplus.skills.base.perk.perks.OnePunchManPerk;
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

@Getter
@Setter
@Configuration(path = "perks/one_punch_man_perk.yml")
@Header("================================")
@Header("       One Punch Man Perk      ")
@Header("================================")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public final class OnePunchManConfig extends OkaeriConfig implements PerkFile {
    public String id = "one_punch_man";
    public boolean enabled = true;
    public String displayName = "One Punch Man";
    public List<String> description = Arrays.asList("  &a%percent%% &7chance to kill mobs of", "  &7one hit.");
    public int maxLevel = 50;
    public GUIOptions guiOptions = GUIOptions.builder()
            .slot(23)
            .page(1)
            .item(XMaterial.PLAYER_HEAD)
            .texture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmUyMmM2N2MwOTI3OWE4YzczMzQ4MzgzNzI4MjE5ZGEwZDEwYjU5MzI3NGYxYWIzOGNhODU3NDg3ZTMyMWU3NSJ9fX0=")
            .mainMenuLore(Collections.singletonList("%skill_one_punch_man_description%"))
            .build();
    public Perk getPerk(){
        return OnePunchManPerk.builder()
                .id(id)
                .displayName(displayName)
                .description(description)
                .enabled(enabled)
                .skillGUIOptions(guiOptions)
                .chancePerLevel(0.1)
                .initialAmount(0)
                .canBeUsedWithPlayers(false)
                .build();
    }
}
