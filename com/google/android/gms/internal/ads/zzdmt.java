package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import com.ironsource.C3061e8;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdmt {
    private final Executor zza;
    private final zzcnx zzb;
    private final zzddx zzc;
    private final zzcmq zzd;

    zzdmt(Executor executor, zzcnx zzcnxVar, zzddx zzddxVar, zzcmq zzcmqVar) {
        this.zza = executor;
        this.zzc = zzddxVar;
        this.zzb = zzcnxVar;
        this.zzd = zzcmqVar;
    }

    public final void zzc(final zzcfg zzcfgVar) {
        if (zzcfgVar == null) {
            return;
        }
        zzddx zzddxVar = this.zzc;
        zzddxVar.zza(zzcfgVar.zzF());
        zzazd zzazdVar = new zzazd() { // from class: com.google.android.gms.internal.ads.zzdmp
            @Override // com.google.android.gms.internal.ads.zzazd
            public final void zzdr(zzazc zzazcVar) {
                zzcgy zzN = zzcfg.this.zzN();
                Rect rect = zzazcVar.zzd;
                zzN.zzr(rect.left, rect.top, false);
            }
        };
        Executor executor = this.zza;
        zzddxVar.zzo(zzazdVar, executor);
        zzddxVar.zzo(new zzazd() { // from class: com.google.android.gms.internal.ads.zzdmq
            @Override // com.google.android.gms.internal.ads.zzazd
            public final void zzdr(zzazc zzazcVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C3061e8.k, true != zzazcVar.zzj ? "0" : "1");
                zzcfg.this.zzd("onAdVisibilityChanged", hashMap);
            }
        }, executor);
        zzcnx zzcnxVar = this.zzb;
        zzddxVar.zzo(zzcnxVar, executor);
        zzcnxVar.zzf(zzcfgVar);
        zzcgy zzN = zzcfgVar.zzN();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkC)).booleanValue() && zzN != null) {
            zzcmq zzcmqVar = this.zzd;
            zzN.zzN(zzcmqVar);
            zzN.zzO(zzcmqVar, null, null);
        }
        zzcfgVar.zzag("/trackActiveViewUnit", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdmr
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdmt.this.zzb.zzd();
            }
        });
        zzcfgVar.zzag("/untrackActiveViewUnit", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdms
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdmt.this.zzb.zzb();
            }
        });
    }
}
