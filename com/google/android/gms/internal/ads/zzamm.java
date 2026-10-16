package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzamm implements zzakt {
    private final zzen zza = new zzen();
    private final zzamc zzb = new zzamc();

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        ArrayList arrayList = new ArrayList();
        try {
            int zzc = zzenVar.zzc();
            String zzz = zzenVar.zzz(StandardCharsets.UTF_8);
            if (zzz == null || !zzz.startsWith("WEBVTT")) {
                zzenVar.zzL(zzc);
                throw zzaz.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzenVar.zzz(StandardCharsets.UTF_8))), null);
            }
            while (!TextUtils.isEmpty(zzenVar.zzz(StandardCharsets.UTF_8))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                char c = 65535;
                int i3 = 0;
                while (c == 65535) {
                    i3 = zzenVar.zzc();
                    String zzz2 = zzenVar.zzz(StandardCharsets.UTF_8);
                    c = zzz2 == null ? (char) 0 : "STYLE".equals(zzz2) ? (char) 2 : zzz2.startsWith("NOTE") ? (char) 1 : (char) 3;
                }
                zzenVar.zzL(i3);
                if (c == 0) {
                    zzakn.zza(new zzamp(arrayList2), zzaksVar, zzdnVar);
                    return;
                }
                if (c == 1) {
                    while (!TextUtils.isEmpty(zzenVar.zzz(StandardCharsets.UTF_8))) {
                    }
                } else if (c != 2) {
                    zzame zzc2 = zzaml.zzc(zzenVar, arrayList);
                    if (zzc2 != null) {
                        arrayList2.add(zzc2);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    zzenVar.zzz(StandardCharsets.UTF_8);
                    arrayList.addAll(this.zzb.zzb(zzenVar));
                }
            }
        } catch (zzaz e) {
            throw new IllegalArgumentException(e);
        }
    }
}
