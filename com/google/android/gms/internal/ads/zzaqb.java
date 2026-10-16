package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaqb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaqd zzc;

    zzaqb(zzaqd zzaqdVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        Objects.requireNonNull(zzaqdVar);
        this.zzc = zzaqdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaqo zzaqoVar;
        zzaqo zzaqoVar2;
        zzaqd zzaqdVar = this.zzc;
        zzaqoVar = zzaqdVar.zza;
        zzaqoVar.zza(this.zza, this.zzb);
        zzaqoVar2 = zzaqdVar.zza;
        zzaqoVar2.zzb(zzaqdVar.toString());
    }
}
