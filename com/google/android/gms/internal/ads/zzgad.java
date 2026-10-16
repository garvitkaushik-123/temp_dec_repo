package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgad extends zzfyq {
    final /* synthetic */ zzgae zza;

    zzgad(zzgae zzgaeVar) {
        Objects.requireNonNull(zzgaeVar);
        this.zza = zzgaeVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        zzgae zzgaeVar = this.zza;
        i2 = zzgaeVar.zzc;
        zzfvp.zza(i, i2, FirebaseAnalytics.Param.INDEX);
        objArr = zzgaeVar.zzb;
        int i3 = i + i;
        Object requireNonNull = Objects.requireNonNull(objArr[i3]);
        objArr2 = zzgaeVar.zzb;
        return new AbstractMap.SimpleImmutableEntry(requireNonNull, Objects.requireNonNull(objArr2[i3 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final boolean zzf() {
        return true;
    }
}
