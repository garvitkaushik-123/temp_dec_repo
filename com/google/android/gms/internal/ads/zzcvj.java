package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcvj implements zzhgr {
    private final zzcvh zza;
    private final zzhha zzb;

    private zzcvj(zzcvh zzcvhVar, zzhha zzhhaVar) {
        this.zza = zzcvhVar;
        this.zzb = zzhhaVar;
    }

    public static zzcvj zza(zzcvh zzcvhVar, zzhha zzhhaVar) {
        return new zzcvj(zzcvhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zzb = this.zza.zzb(((zzchl) this.zzb).zza());
        zzhgz.zzb(zzb);
        return zzb;
    }
}
