package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zzjf extends ContentObserver {
    final /* synthetic */ zzjh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjf(zzjh zzjhVar, Handler handler) {
        super(null);
        this.zza = zzjhVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.zza.zza;
        atomicBoolean.set(true);
    }
}
