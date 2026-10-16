package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzamg {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzamf
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compare;
            compare = Integer.compare(((zzamg) obj).zzb.zzb, ((zzamg) obj2).zzb.zzb);
            return compare;
        }
    };
    private final zzamh zzb;
    private final int zzc;

    /* synthetic */ zzamg(zzamh zzamhVar, int i, zzamk zzamkVar) {
        this.zzb = zzamhVar;
        this.zzc = i;
    }
}
