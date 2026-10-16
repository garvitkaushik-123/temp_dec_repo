package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzcb extends zzbt {
    final /* synthetic */ zzcc zza;

    zzcb(zzcc zzccVar) {
        Objects.requireNonNull(zzccVar);
        this.zza = zzccVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        zzcc zzccVar = this.zza;
        i2 = zzccVar.zzc;
        zzbg.zza(i, i2, FirebaseAnalytics.Param.INDEX);
        objArr = zzccVar.zzb;
        int i3 = i + i;
        Object requireNonNull = Objects.requireNonNull(objArr[i3]);
        objArr2 = zzccVar.zzb;
        return new AbstractMap.SimpleImmutableEntry(requireNonNull, Objects.requireNonNull(objArr2[i3 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return true;
    }
}
