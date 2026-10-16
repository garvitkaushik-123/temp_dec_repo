package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcvb;
import com.google.android.gms.internal.ads.zzcvc;
import com.google.android.gms.internal.ads.zzcvp;
import com.google.android.gms.internal.ads.zzdes;
import com.google.android.gms.internal.ads.zzdrr;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfha;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhgz;
import com.google.android.gms.internal.ads.zzhha;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbg implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;
    private final zzhha zzg;
    private final zzhha zzh;
    private final zzhha zzi;

    private zzbg(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
        this.zzg = zzhhaVar7;
        this.zzh = zzhhaVar8;
        this.zzi = zzhhaVar9;
    }

    public static zzbg zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9) {
        return new zzbg(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        ListenableFuture zza;
        zzau zzauVar = (zzau) this.zza.zzb();
        zzfha zzfhaVar = (zzfha) this.zzb.zzb();
        zzbi zzb = ((zzbj) this.zzc).zzb();
        zzcvb zzb2 = ((zzcvc) this.zzd).zzb();
        zzdes zzdesVar = (zzdes) this.zze.zzb();
        zzb zzbVar = (zzb) this.zzf.zzb();
        zzbze zzbzeVar = (zzbze) this.zzg.zzb();
        int intValue = ((Integer) this.zzh.zzb()).intValue();
        Bundle bundle = ((zzcvp) this.zzi).zzc().zzs;
        zzbk zzbkVar = null;
        if (intValue == 1 && zzbzeVar != null) {
            bundle.putLong(zzdrr.READ_FROM_DISK_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
            zzbkVar = zzbVar.zza(zzbzeVar, zzauVar, bundle);
            bundle.putLong(zzdrr.READ_FROM_DISK_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        if (zzbkVar != null) {
            zzdesVar.zza(zzbkVar);
            zza = zzgdn.zzh(zzbkVar);
        } else {
            zza = zzfhaVar.zzb(zzfgu.GENERATE_SIGNALS, zzb2.zzc()).zzf(zzb).zzi(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS).zza();
            zzgdn.zzr(zza, new zzaw(zzdesVar), zzcaf.zza);
        }
        zzhgz.zzb(zza);
        return zza;
    }
}
