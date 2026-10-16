package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaqw {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    static zzaqw zza(zzaqx zzaqxVar) throws IOException {
        if (zzaqz.zze(zzaqxVar) != 538247942) {
            throw new IOException();
        }
        String zzh = zzaqz.zzh(zzaqxVar);
        String zzh2 = zzaqz.zzh(zzaqxVar);
        long zzf = zzaqz.zzf(zzaqxVar);
        long zzf2 = zzaqz.zzf(zzaqxVar);
        long zzf3 = zzaqz.zzf(zzaqxVar);
        long zzf4 = zzaqz.zzf(zzaqxVar);
        int zze = zzaqz.zze(zzaqxVar);
        if (zze < 0) {
            throw new IOException("readHeaderList size=" + zze);
        }
        List emptyList = zze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < zze; i++) {
            emptyList.add(new zzapv(zzaqz.zzh(zzaqxVar).intern(), zzaqz.zzh(zzaqxVar).intern()));
        }
        return new zzaqw(zzh, zzh2, zzf, zzf2, zzf3, zzf4, emptyList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    zzaqw(String str, zzapm zzapmVar) {
        this(str, r2, r3, r5, r7, r9, r0);
        String str2 = zzapmVar.zzb;
        long j = zzapmVar.zzc;
        long j2 = zzapmVar.zzd;
        long j3 = zzapmVar.zze;
        long j4 = zzapmVar.zzf;
        List list = zzapmVar.zzh;
        if (list == null) {
            Map map = zzapmVar.zzg;
            list = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                list.add(new zzapv((String) entry.getKey(), (String) entry.getValue()));
            }
        }
    }

    private zzaqw(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
