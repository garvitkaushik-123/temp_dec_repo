package com.inmobi.media;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class W6 implements GoogleApiClient.ConnectionCallbacks {
    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Intrinsics.checkNotNullExpressionValue(X6.e, "access$getTAG$p(...)");
        X6.f = true;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        X6.f = false;
        Intrinsics.checkNotNullExpressionValue(X6.e, "access$getTAG$p(...)");
    }
}
