package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdil implements zzazd {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdio zzb;

    zzdil(zzdio zzdioVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdioVar);
        this.zzb = zzdioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        zzdkr zzdkrVar;
        Map map;
        zzdkr zzdkrVar2;
        zzdkr zzdkrVar3;
        zzdkr zzdkrVar4;
        zzdkr zzdkrVar5;
        zzdkr zzdkrVar6;
        Map map2;
        zzdkr zzdkrVar7;
        zzdkr zzdkrVar8;
        zzdkr zzdkrVar9;
        zzdkr zzdkrVar10;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbV)).booleanValue()) {
            synchronized (this) {
                if (zzazcVar.zzj) {
                    zzdio zzdioVar = this.zzb;
                    zzdkrVar6 = zzdioVar.zzo;
                    if (zzdkrVar6 != null) {
                        map2 = zzdioVar.zzz;
                        map2.put(this.zza, true);
                        zzdkrVar7 = zzdioVar.zzo;
                        if (zzdkrVar7 == null) {
                            return;
                        }
                        zzdkrVar8 = zzdioVar.zzo;
                        View zzf = zzdkrVar8.zzf();
                        zzdkrVar9 = zzdioVar.zzo;
                        Map zzl = zzdkrVar9.zzl();
                        zzdkrVar10 = zzdioVar.zzo;
                        zzdioVar.zzC(zzf, zzl, zzdkrVar10.zzm(), true);
                    }
                }
                return;
            }
        }
        if (zzazcVar.zzj) {
            zzdio zzdioVar2 = this.zzb;
            zzdkrVar = zzdioVar2.zzo;
            if (zzdkrVar != null) {
                map = zzdioVar2.zzz;
                map.put(this.zza, true);
                zzdkrVar2 = zzdioVar2.zzo;
                if (zzdkrVar2 == null) {
                    return;
                }
                zzdkrVar3 = zzdioVar2.zzo;
                View zzf2 = zzdkrVar3.zzf();
                zzdkrVar4 = zzdioVar2.zzo;
                Map zzl2 = zzdkrVar4.zzl();
                zzdkrVar5 = zzdioVar2.zzo;
                zzdioVar2.zzC(zzf2, zzl2, zzdkrVar5.zzm(), true);
            }
        }
    }
}
