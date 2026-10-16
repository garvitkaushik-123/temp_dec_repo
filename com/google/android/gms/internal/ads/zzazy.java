package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzazy implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbac zzb;

    zzazy(zzbac zzbacVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzbacVar);
        this.zzb = zzbacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
