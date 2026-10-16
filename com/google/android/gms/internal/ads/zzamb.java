package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzamb implements zzakt {
    private final zzen zza = new zzen();

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzcu zzq;
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        ArrayList arrayList = new ArrayList();
        while (zzenVar.zza() > 0) {
            zzdd.zze(zzenVar.zza() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int zzg = zzenVar.zzg() - 8;
            if (zzenVar.zzg() == 1987343459) {
                CharSequence charSequence = null;
                zzcs zzcsVar = null;
                while (zzg > 0) {
                    zzdd.zze(zzg >= 8, "Incomplete vtt cue box header found.");
                    int zzg2 = zzenVar.zzg();
                    int zzg3 = zzenVar.zzg();
                    int i3 = zzg - 8;
                    int i4 = zzg2 - 8;
                    String zzC = zzex.zzC(zzenVar.zzN(), zzenVar.zzc(), i4);
                    zzenVar.zzM(i4);
                    if (zzg3 == 1937011815) {
                        zzcsVar = zzaml.zzb(zzC);
                    } else if (zzg3 == 1885436268) {
                        charSequence = zzaml.zza(null, zzC.trim(), Collections.emptyList());
                    }
                    zzg = i3 - i4;
                }
                if (charSequence == null) {
                    charSequence = "";
                }
                if (zzcsVar != null) {
                    zzcsVar.zzl(charSequence);
                    zzq = zzcsVar.zzq();
                } else {
                    Pattern pattern = zzaml.zza;
                    zzamj zzamjVar = new zzamj();
                    zzamjVar.zzc = charSequence;
                    zzq = zzamjVar.zza().zzq();
                }
                arrayList.add(zzq);
            } else {
                zzenVar.zzM(zzg);
            }
        }
        zzdnVar.zza(new zzakl(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
