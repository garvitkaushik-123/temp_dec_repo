package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzadj {
    private final Map zza = new LinkedHashMap();

    public final zzadi zza() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (zzadi zzadiVar : this.zza.values()) {
            arrayList.add(zzadiVar.zzb);
            arrayList2.add(zzadiVar.zzc);
            arrayList3.add(zzadiVar.zzd);
            arrayList4.add(zzadiVar.zze);
        }
        int[][] iArr = (int[][]) arrayList.toArray(new int[arrayList.size()][]);
        long j = 0;
        for (int[] iArr2 : iArr) {
            j += iArr2.length;
        }
        int i = (int) j;
        zzfvp.zzh(j == ((long) i), "the total number of elements (%s) in the arrays must fit in an int", j);
        int[] iArr3 = new int[i];
        int i2 = 0;
        for (int[] iArr4 : iArr) {
            int length = iArr4.length;
            System.arraycopy(iArr4, 0, iArr3, i2, length);
            i2 += length;
        }
        return new zzadi(iArr3, zzgbw.zza((long[][]) arrayList2.toArray(new long[arrayList2.size()][])), zzgbw.zza((long[][]) arrayList3.toArray(new long[arrayList3.size()][])), zzgbw.zza((long[][]) arrayList4.toArray(new long[arrayList4.size()][])));
    }

    public final void zzb(zzadi zzadiVar) {
        long[] jArr = zzadiVar.zze;
        if (jArr.length > 0) {
            Map map = this.zza;
            if (map.containsKey(Long.valueOf(jArr[0]))) {
                return;
            }
            map.put(Long.valueOf(jArr[0]), zzadiVar);
        }
    }
}
