package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zar {
    final /* synthetic */ BasePendingResult zaa;

    /* synthetic */ zar(BasePendingResult basePendingResult, zas zasVar) {
        this.zaa = basePendingResult;
    }

    protected final void finalize() throws Throwable {
        Result result;
        result = this.zaa.zaj;
        BasePendingResult.zal(result);
        super.finalize();
    }
}
