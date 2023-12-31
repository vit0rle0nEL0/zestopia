package com.qualityplus.dragon.base.game.structure;

import com.qualityplus.dragon.api.game.structure.type.DragonSpawn;
import com.qualityplus.assistant.lib.eu.okaeri.configs.OkaeriConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;

@Getter
@AllArgsConstructor
public final class DragonSpawnImpl extends OkaeriConfig implements DragonSpawn {
    private Location location;

    @Override
    public void removeStructure() {
        /**
         * TODO
         */
    }

    @Override
    public World getWorld() {
        return location.getWorld();
    }
}
