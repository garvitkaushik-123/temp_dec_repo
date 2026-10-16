package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzael {
    private final zzen zza = new zzen(10);

    public final zzav zza(zzadw zzadwVar, zzahc zzahcVar) throws IOException {
        zzav zzavVar = null;
        int i = 0;
        while (true) {
            try {
                zzen zzenVar = this.zza;
                zzadwVar.zzh(zzenVar.zzN(), 0, 10);
                zzenVar.zzL(0);
                if (zzenVar.zzo() != 4801587) {
                    break;
                }
                zzenVar.zzM(3);
                int zzl = zzenVar.zzl();
                int i2 = zzl + 10;
                if (zzavVar == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(zzenVar.zzN(), 0, bArr, 0, 10);
                    zzadwVar.zzh(bArr, 10, zzl);
                    zzavVar = zzahe.zza(bArr, i2, zzahcVar, new zzagq());
                } else {
                    zzadwVar.zzg(zzl);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzadwVar.zzj();
        zzadwVar.zzg(i);
        return zzavVar;
    }
}
