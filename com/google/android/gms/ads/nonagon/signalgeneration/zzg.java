package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchz;
import com.google.android.gms.internal.ads.zzcko;
import com.google.android.gms.internal.ads.zzepn;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzg implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzg(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar4;
    }

    public static zzg zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzg(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzf(((zzchl) this.zza).zza(), zzcko.zza(), zzepn.zzc(), ((zzchz) this.zzb).zza());
    }
}
