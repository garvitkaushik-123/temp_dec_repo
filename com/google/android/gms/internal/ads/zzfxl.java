package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzfxl implements zzfzo {
    private transient Set zza;
    private transient Collection zzb;
    private transient Map zzc;

    zzfxl() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfzo) {
            return zzs().equals(((zzfzo) obj).zzs());
        }
        return false;
    }

    public final int hashCode() {
        return zzs().hashCode();
    }

    public final String toString() {
        return zzs().toString();
    }

    abstract Collection zzf();

    Iterator zzg() {
        throw null;
    }

    abstract Map zzj();

    abstract Set zzl();

    @Override // com.google.android.gms.internal.ads.zzfzo
    public boolean zzq(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final Collection zzr() {
        Collection collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final Map zzs() {
        Map map = this.zzc;
        if (map != null) {
            return map;
        }
        Map zzj = zzj();
        this.zzc = zzj;
        return zzj;
    }

    public final Set zzt() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzl = zzl();
        this.zza = zzl;
        return zzl;
    }
}
