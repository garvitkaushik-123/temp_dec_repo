package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzha implements Iterator {
    final /* synthetic */ zzhd zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzha(zzhd zzhdVar, zzhc zzhcVar) {
        Objects.requireNonNull(zzhdVar);
        this.zza = zzhdVar;
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
        zzhd zzhdVar = this.zza;
        i = zzhdVar.zzb;
        if (i2 < i) {
            return true;
        }
        map = zzhdVar.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i;
        Object[] objArr;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzhd zzhdVar = this.zza;
        i = zzhdVar.zzb;
        if (i2 >= i) {
            return (Map.Entry) zza().next();
        }
        objArr = zzhdVar.zza;
        return (zzgz) objArr[i2];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhd zzhdVar = this.zza;
        zzhdVar.zzo();
        int i2 = this.zzb;
        i = zzhdVar.zzb;
        if (i2 >= i) {
            zza().remove();
        } else {
            this.zzb = i2 - 1;
            zzhdVar.zzm(i2);
        }
    }
}
