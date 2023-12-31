package com.qualityplus.minions.base.minions.entity.handler;

import com.qualityplus.minions.api.handler.*;
import com.qualityplus.minions.api.minion.MinionEntity;
import com.qualityplus.minions.base.handler.*;
import com.qualityplus.minions.base.minions.minion.Minion;
import lombok.Getter;

@Getter
public final class MinionHandlersImpl implements MinionHandlers {
    private final AnimationHandler animationHandler;
    private final StorageHandler storageHandler;
    private final LayoutHandler layoutHandler;
    private final SellHandler sellHandler;
    private final FuelHandler fuelHandler;

    public MinionHandlersImpl(MinionEntity entity, Minion minion) {
        this.animationHandler = new AnimationHandlerImpl(entity.getMinionUniqueId(), minion);
        this.layoutHandler = new LayoutHandlerImpl(entity, minion);
        this.fuelHandler = new FuelHandlerImpl(entity.getMinionUniqueId());
        this.sellHandler = new SellHandlerImpl(entity, minion);
        this.storageHandler = new StorageHandlerImpl(entity, minion);
    }
}
