package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zzjl extends ContentObserver {
    final /* synthetic */ zzjm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjl(zzjm zzjmVar, Handler handler) {
        super(null);
        this.zza = zzjmVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzf();
    }
}
