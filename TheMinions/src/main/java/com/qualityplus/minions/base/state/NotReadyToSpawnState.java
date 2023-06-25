package com.qualityplus.minions.base.state;

import com.qualityplus.minions.api.state.MinionState;

public final class NotReadyToSpawnState implements MinionState {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean canPerformAction() {
        return false;
    }
}
