package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzddv;
import com.google.android.gms.internal.ads.zzdep;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbf implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzbf(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar4;
    }

    public static zzbf zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzbf(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdep zzdepVar = (zzw) this.zza.zzb();
        zzdep zzdepVar2 = (zzbm) this.zzb.zzb();
        zzgdy zzc = zzffu.zzc();
        if (((Integer) this.zzc.zzb()).intValue() == 2) {
            zzdepVar = zzdepVar2;
        }
        return new zzddv(zzdepVar, zzc);
    }
}
