package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbq implements Iterator {
    final /* synthetic */ zzhbt zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzhbq(zzhbt zzhbtVar, zzhbs zzhbsVar) {
        Objects.requireNonNull(zzhbtVar);
        this.zza = zzhbtVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        Map map;
        int i2 = this.zzb + 1;
        zzhbt zzhbtVar = this.zza;
        i = zzhbtVar.zzb;
        if (i2 < i) {
            return true;
        }
        map = zzhbtVar.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i;
        Object[] objArr;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzhbt zzhbtVar = this.zza;
        i = zzhbtVar.zzb;
        if (i2 >= i) {
            return (Map.Entry) zza().next();
        }
        objArr = zzhbtVar.zza;
        return (zzhbp) objArr[i2];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhbt zzhbtVar = this.zza;
        zzhbtVar.zzo();
        int i2 = this.zzb;
        i = zzhbtVar.zzb;
        if (i2 >= i) {
            zza().remove();
        } else {
            this.zzb = i2 - 1;
            zzhbtVar.zzm(i2);
        }
    }
}
