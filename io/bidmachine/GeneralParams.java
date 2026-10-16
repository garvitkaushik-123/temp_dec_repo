package io.bidmachine;

import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.TargetingInfo;

/* loaded from: classes7.dex */
public interface GeneralParams {
    DataRestrictions getDataRestrictions();

    TargetingInfo getTargetingInfo();

    boolean isTestMode();
}
