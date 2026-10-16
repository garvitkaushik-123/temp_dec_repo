package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzsr extends Handler {
    final /* synthetic */ zzst zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzsr(zzst zzstVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zzstVar);
        this.zza = zzstVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzst.zza(this.zza, message);
    }
}
