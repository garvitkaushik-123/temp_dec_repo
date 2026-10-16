package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzy implements zzhgr {
    private final zzhha zza;

    private zzy(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzy zza(zzhha zzhhaVar) {
        return new zzy(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzv((zzdso) this.zza.zzb());
    }
}
