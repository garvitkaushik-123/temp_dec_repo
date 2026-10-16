package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaoh implements zzaoa {
    final /* synthetic */ zzaoj zza;
    private final zzem zzb;

    public zzaoh(zzaoj zzaojVar) {
        Objects.requireNonNull(zzaojVar);
        this.zza = zzaojVar;
        this.zzb = new zzem(new byte[4], 4);
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zza(zzen zzenVar) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        int i;
        if (zzenVar.zzm() == 0 && (zzenVar.zzm() & 128) != 0) {
            zzenVar.zzM(6);
            int zza = zzenVar.zza() / 4;
            for (int i2 = 0; i2 < zza; i2++) {
                zzem zzemVar = this.zzb;
                zzenVar.zzG(zzemVar, 4);
                int zzd = zzemVar.zzd(16);
                zzemVar.zzn(3);
                if (zzd == 0) {
                    zzemVar.zzn(13);
                } else {
                    int zzd2 = zzemVar.zzd(13);
                    zzaoj zzaojVar = this.zza;
                    sparseArray2 = zzaojVar.zzg;
                    if (sparseArray2.get(zzd2) == null) {
                        sparseArray3 = zzaojVar.zzg;
                        sparseArray3.put(zzd2, new zzaob(new zzaoi(zzaojVar, zzd2)));
                        i = zzaojVar.zzm;
                        zzaojVar.zzm = i + 1;
                    }
                }
            }
            sparseArray = this.zza.zzg;
            sparseArray.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
    }
}
