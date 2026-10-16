package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeyf implements zzeln {
    final /* synthetic */ zzeyg zza;

    zzeyf(zzeyg zzeygVar) {
        Objects.requireNonNull(zzeygVar);
        this.zza = zzeygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzeyg zzeygVar = this.zza;
        synchronized (zzeygVar) {
            zzeygVar.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzexy zzexyVar;
        zzexy zzexyVar2;
        zzdsj zzdsjVar;
        zzcom zzcomVar = (zzcom) obj;
        zzeyg zzeygVar = this.zza;
        synchronized (zzeygVar) {
            zzcom zzcomVar2 = zzeygVar.zza;
            if (zzcomVar2 != null) {
                zzcomVar2.zzb();
            }
            zzeygVar.zza = zzcomVar;
            zzcomVar.zzc(zzeygVar);
            zzexyVar = zzeygVar.zzg;
            zzexyVar2 = zzeygVar.zzg;
            zzdsjVar = zzeygVar.zzi;
            zzexyVar.zzk(new zzcon(zzcomVar, zzeygVar, zzexyVar2, zzdsjVar));
            zzcomVar.zzk();
        }
    }
}
