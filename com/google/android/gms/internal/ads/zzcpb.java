package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcpb implements zzhgr {
    private final zzcoz zza;

    private zzcpb(zzcoz zzcozVar) {
        this.zza = zzcozVar;
    }

    public static View zzc(zzcoz zzcozVar) {
        View zza = zzcozVar.zza();
        zzhgz.zzb(zza);
        return zza;
    }

    public static zzcpb zzd(zzcoz zzcozVar) {
        return new zzcpb(zzcozVar);
    }

    public final View zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
