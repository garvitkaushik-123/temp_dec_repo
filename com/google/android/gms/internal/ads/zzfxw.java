package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfxw extends zzfxj {
    final /* synthetic */ zzfxz zza;
    private final Object zzb;
    private int zzc;

    zzfxw(zzfxz zzfxzVar, int i) {
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
        this.zzb = zzfxz.zzg(zzfxzVar, i);
        this.zzc = i;
    }

    private final void zza() {
        int zzw;
        int i = this.zzc;
        if (i != -1) {
            zzfxz zzfxzVar = this.zza;
            if (i < zzfxzVar.size() && zzfvm.zza(this.zzb, zzfxz.zzg(zzfxzVar, this.zzc))) {
                return;
            }
        }
        zzw = this.zza.zzw(this.zzb);
        this.zzc = zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzfxj, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxj, java.util.Map.Entry
    public final Object getValue() {
        zzfxz zzfxzVar = this.zza;
        Map zzl = zzfxzVar.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfxz.zzj(zzfxzVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzfxz zzfxzVar = this.zza;
        Map zzl = zzfxzVar.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            zzfxzVar.put(this.zzb, obj);
            return null;
        }
        Object zzj = zzfxz.zzj(zzfxzVar, i);
        zzfxz.zzn(zzfxzVar, this.zzc, obj);
        return zzj;
    }
}
