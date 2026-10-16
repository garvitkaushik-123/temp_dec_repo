package com.moloco.sdk.publisher;

import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"createAdErrorInfo", "Lcom/moloco/sdk/publisher/MolocoAdError;", "adUnitId", "", "errorType", "Lcom/moloco/sdk/publisher/MolocoAdError$ErrorType;", "moloco-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoAdErrorKt {
    public static final MolocoAdError createAdErrorInfo(String adUnitId, MolocoAdError.ErrorType errorType) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        return new MolocoAdError("Moloco", adUnitId, errorType, null, 8, null);
    }
}
