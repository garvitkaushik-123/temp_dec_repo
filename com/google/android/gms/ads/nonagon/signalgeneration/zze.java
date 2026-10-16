package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zze implements zzhgr {
    private final zzhha zza;

    private zze(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zze zza(zzhha zzhhaVar) {
        return new zze(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzd(((zzchl) this.zza).zza());
    }
}
