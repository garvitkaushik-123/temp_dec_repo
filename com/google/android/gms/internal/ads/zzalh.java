package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzalh implements zzakt {
    private final zzen zza = new zzen();
    private final zzen zzb = new zzen();
    private final zzalg zzc = new zzalg();
    private Inflater zzd;

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzen zzenVar2 = this.zzb;
        if (zzex.zzO(zzenVar, zzenVar2, this.zzd)) {
            zzenVar.zzJ(zzenVar2.zzN(), zzenVar2.zzd());
        }
        zzalg zzalgVar = this.zzc;
        zzalgVar.zze();
        ArrayList arrayList = new ArrayList();
        while (zzenVar.zza() >= 3) {
            int zzd = zzenVar.zzd();
            int zzm = zzenVar.zzm();
            int zzq = zzenVar.zzq();
            int zzc = zzenVar.zzc() + zzq;
            zzcu zzcuVar = null;
            if (zzc > zzd) {
                zzenVar.zzL(zzd);
            } else {
                if (zzm != 128) {
                    switch (zzm) {
                        case 20:
                            zzalg.zzd(zzalgVar, zzenVar, zzq);
                            break;
                        case 21:
                            zzalg.zzb(zzalgVar, zzenVar, zzq);
                            break;
                        case 22:
                            zzalg.zzc(zzalgVar, zzenVar, zzq);
                            break;
                    }
                } else {
                    zzcu zza = zzalgVar.zza();
                    zzalgVar.zze();
                    zzcuVar = zza;
                }
                zzenVar.zzL(zzc);
            }
            if (zzcuVar != null) {
                arrayList.add(zzcuVar);
            }
        }
        zzdnVar.zza(new zzakl(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
