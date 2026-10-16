package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfbv implements zzeln {
    final /* synthetic */ zzfbx zza;

    zzfbv(zzfbx zzfbxVar) {
        Objects.requireNonNull(zzfbxVar);
        this.zza = zzfbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzfbx zzfbxVar = this.zza;
        synchronized (zzfbxVar) {
            zzfbxVar.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdon zzdonVar;
        zzfco zzfcoVar;
        zzfbx zzfbxVar = this.zza;
        zzdon zzdonVar2 = (zzdon) obj;
        synchronized (zzfbxVar) {
            zzfbxVar.zzd = zzdonVar2;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdP)).booleanValue()) {
                zzfcp zzd = zzdonVar2.zzd();
                zzfcoVar = zzfbxVar.zzc;
                zzd.zza = zzfcoVar;
            }
            zzdonVar = zzfbxVar.zzd;
            zzdonVar.zzk();
        }
    }
}
