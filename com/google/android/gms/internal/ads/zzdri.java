package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbcj;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdri implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzdri(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar4;
    }

    public static zzdri zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzdri(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set emptySet;
        final String zzc = ((zzewn) this.zza).zzc();
        Context zza = ((zzchl) this.zzb).zza();
        zzgdy zzc2 = zzffu.zzc();
        Map zzb = ((zzhgv) this.zzc).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzft)).booleanValue()) {
            zzbcc zzbccVar = new zzbcc(new zzbci(zza));
            zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdrj
                @Override // com.google.android.gms.internal.ads.zzbcb
                public final void zza(zzbcj.zzt.zza zzaVar) {
                    zzaVar.zzO(zzc);
                }
            });
            emptySet = Collections.singleton(new zzddv(new zzdrl(zzbccVar, zzb), zzc2));
        } else {
            emptySet = Collections.emptySet();
        }
        zzhgz.zzb(emptySet);
        return emptySet;
    }
}
