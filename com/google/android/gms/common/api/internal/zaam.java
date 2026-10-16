package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaam extends zabe {
    final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zaam(zaan zaanVar, zabd zabdVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabdVar);
        this.zaa = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.zabe
    public final void zaa() {
        this.zaa.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
