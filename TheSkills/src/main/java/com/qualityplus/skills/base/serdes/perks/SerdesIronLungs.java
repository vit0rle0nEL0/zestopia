package com.qualityplus.skills.base.serdes.perks;

import com.qualityplus.skills.base.perk.perks.IronLungsPerk;
import com.qualityplus.skills.base.serdes.SerdesPerk;
import com.qualityplus.skills.base.serdes.perks.common.SerdesPotionPerk;
import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;

public final class SerdesIronLungs implements ObjectSerializer<IronLungsPerk> {
    private static final SerdesPerk SERDES_PERK = new SerdesPerk();
    private static final SerdesPotionPerk SERDES_POTION_PERK = new SerdesPotionPerk();

    @Override
    public boolean supports(@NonNull Class<? super IronLungsPerk> type) {
        return IronLungsPerk.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NonNull IronLungsPerk object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
        SERDES_PERK.serialize(object, data, generics);
        SERDES_POTION_PERK.serialize(object, data, generics);

        data.add("initialAmount", object.getInitialAmount(), Double.class);
        data.add("chancePerLevel", object.getChancePerLevel(), Double.class);
    }

    @Override
    public IronLungsPerk deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
        IronLungsPerk alchemySkill = new IronLungsPerk();

        SERDES_PERK.deserialize(alchemySkill, data, generics);
        SERDES_POTION_PERK.deserialize(alchemySkill, data, generics);

        alchemySkill.setChancePerLevel(data.get("chancePerLevel", Double.class));
        alchemySkill.setInitialAmount(data.get("initialAmount", Double.class));

        return alchemySkill;
    }
}