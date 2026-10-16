package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfkw implements Comparator {
    final /* synthetic */ zzfld zza;

    zzfkw(zzfld zzfldVar) {
        Objects.requireNonNull(zzfldVar);
        this.zza = zzfldVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzfku zzfkuVar = (zzfku) obj;
        zzfku zzfkuVar2 = (zzfku) obj2;
        Object zzc = zzfkuVar2.zzc();
        zzfld zzfldVar = this.zza;
        int compare = Double.compare(zzfld.zzc(zzfldVar, zzfldVar.zza(zzc)), zzfld.zzc(zzfldVar, zzfldVar.zza(zzfkuVar.zzc())));
        return compare == 0 ? Long.compare(zzfkuVar.zzb(), zzfkuVar2.zzb()) : compare;
    }
}
