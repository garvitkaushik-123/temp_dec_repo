package com.google.android.gms.internal.games_v2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzhb extends zzhd {
    private final transient zzhd zza;

    zzhb(zzhd zzhdVar) {
        this.zza = zzhdVar;
    }

    private final int zzm(int i) {
        return (this.zza.size() - 1) - i;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzhd zzhdVar = this.zza;
        zzfu.zzb(i, zzhdVar.size(), FirebaseAnalytics.Param.INDEX);
        return zzhdVar.get(zzm(i));
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    public final int indexOf(Object obj) {
        int lastIndexOf = this.zza.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return zzm(lastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    public final int lastIndexOf(Object obj) {
        int indexOf = this.zza.indexOf(obj);
        if (indexOf >= 0) {
            return zzm(indexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd
    public final zzhd zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd
    /* renamed from: zzg */
    public final zzhd subList(int i, int i2) {
        zzhd zzhdVar = this.zza;
        zzfu.zzd(i, i2, zzhdVar.size());
        return zzhdVar.subList(zzhdVar.size() - i2, zzhdVar.size() - i).zzf();
    }
}
