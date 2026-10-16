package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzfzm extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    zzfzm() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzb = zzb();
        this.zza = zzb;
        return zzb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        Set zze = zze();
        this.zzb = zze;
        return zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzfzl zzfzlVar = new zzfzl(this);
        this.zzc = zzfzlVar;
        return zzfzlVar;
    }

    abstract Set zzb();

    Set zze() {
        return new zzfzk(this);
    }
}
