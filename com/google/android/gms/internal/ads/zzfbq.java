package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfbq implements zzeln {
    final /* synthetic */ zzfbr zza;

    zzfbq(zzfbr zzfbrVar) {
        Objects.requireNonNull(zzfbrVar);
        this.zza = zzfbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzfbr zzfbrVar = this.zza;
        synchronized (zzfbrVar) {
            zzfbrVar.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdon zzdonVar;
        zzfco zzfcoVar;
        zzfbr zzfbrVar = this.zza;
        zzdon zzdonVar2 = (zzdon) obj;
        synchronized (zzfbrVar) {
            zzfbrVar.zzi = zzdonVar2;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdP)).booleanValue()) {
                zzfcp zzd = zzdonVar2.zzd();
                zzfcoVar = zzfbrVar.zzd;
                zzd.zza = zzfcoVar;
            }
            zzdonVar = zzfbrVar.zzi;
            zzdonVar.zzk();
        }
    }
}
