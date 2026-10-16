package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzakn {
    public static void zza(zzako zzakoVar, zzaks zzaksVar, zzdn zzdnVar) {
        for (int i = 0; i < zzakoVar.zza(); i++) {
            long zzb = zzakoVar.zzb(i);
            List zzc = zzakoVar.zzc(zzb);
            if (!zzc.isEmpty()) {
                if (i == zzakoVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long zzb2 = zzakoVar.zzb(i + 1) - zzakoVar.zzb(i);
                if (zzb2 > 0) {
                    zzdnVar.zza(new zzakl(zzc, zzb, zzb2));
                }
            }
        }
    }
}
