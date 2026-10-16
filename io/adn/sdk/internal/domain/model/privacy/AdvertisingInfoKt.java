package io.adn.sdk.internal.domain.model.privacy;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdvertisingInfo.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"authorizationStatus", "", "Lio/adn/sdk/internal/domain/model/privacy/AdvertisingInfo;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdvertisingInfoKt {
    public static final String authorizationStatus(AdvertisingInfo advertisingInfo) {
        Boolean limitAdTrackingEnabled = advertisingInfo != null ? advertisingInfo.getLimitAdTrackingEnabled() : null;
        if (Intrinsics.areEqual((Object) limitAdTrackingEnabled, (Object) true)) {
            return "Denied";
        }
        if (Intrinsics.areEqual((Object) limitAdTrackingEnabled, (Object) false)) {
            return "Authorized";
        }
        if (limitAdTrackingEnabled != null) {
            throw new NoWhenBranchMatchedException();
        }
        return "NotDetermined";
    }
}
