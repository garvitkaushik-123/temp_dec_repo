package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbaf implements Comparator {
    zzbaf(zzbah zzbahVar) {
        Objects.requireNonNull(zzbahVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbal zzbalVar = (zzbal) obj;
        zzbal zzbalVar2 = (zzbal) obj2;
        int i = zzbalVar.zzc - zzbalVar2.zzc;
        return i != 0 ? i : Long.compare(zzbalVar.zza, zzbalVar2.zza);
    }
}
