package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzekd implements zzeln {
    final /* synthetic */ zzeke zza;

    zzekd(zzeke zzekeVar) {
        Objects.requireNonNull(zzekeVar);
        this.zza = zzekeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzeke zzekeVar = this.zza;
        synchronized (zzekeVar) {
            zzekeVar.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcos zzcosVar;
        zzcos zzcosVar2;
        zzcos zzcosVar3;
        zzcos zzcosVar4;
        zzcos zzcosVar5;
        zzeke zzekeVar = this.zza;
        zzcos zzcosVar6 = (zzcos) obj;
        synchronized (zzekeVar) {
            zzcosVar = zzekeVar.zzi;
            if (zzcosVar != null) {
                if (zzcosVar6.zzl() != null) {
                    zzcosVar4 = zzekeVar.zzi;
                    if (zzcosVar4.zzl() != null) {
                        zzcuu zzl = zzcosVar6.zzl();
                        zzcosVar5 = zzekeVar.zzi;
                        zzl.zzb(zzcosVar5.zzl().zza());
                    }
                }
                zzcosVar3 = zzekeVar.zzi;
                zzcosVar3.zzb();
            }
            zzekeVar.zzi = zzcosVar6;
            zzcosVar2 = zzekeVar.zzi;
            zzcosVar2.zzk();
        }
    }
}
