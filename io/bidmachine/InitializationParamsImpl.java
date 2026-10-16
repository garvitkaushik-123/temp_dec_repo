package io.bidmachine;

import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.TargetingInfo;

/* loaded from: classes7.dex */
class InitializationParamsImpl implements InitializationParams {
    private final DataRestrictions dataRestrictions;
    private final TargetingInfo targetingInfo;

    InitializationParamsImpl(TargetingParams targetingParams, DataRestrictions dataRestrictions) {
        this.targetingInfo = new TargetingInfoImpl(dataRestrictions, targetingParams);
        this.dataRestrictions = dataRestrictions;
    }

    @Override // io.bidmachine.GeneralParams
    public TargetingInfo getTargetingInfo() {
        return this.targetingInfo;
    }

    @Override // io.bidmachine.GeneralParams
    public DataRestrictions getDataRestrictions() {
        return this.dataRestrictions;
    }

    @Override // io.bidmachine.GeneralParams
    public boolean isTestMode() {
        return BidMachineImpl.get().isTestMode();
    }
}
