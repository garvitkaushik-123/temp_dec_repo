package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzd extends Thread {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;

    zzd(zzf zzfVar, Context context, String str) {
        this.zza = context;
        this.zzb = str;
        Objects.requireNonNull(zzfVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzu(this.zza, null).zza(this.zzb);
    }
}
