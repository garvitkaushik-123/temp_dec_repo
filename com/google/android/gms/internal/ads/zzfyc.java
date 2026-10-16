package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfyc extends zzfyf {
    zzfyc() {
        super(null);
    }

    static final zzfyf zzf(int i) {
        zzfyf zzfyfVar;
        zzfyf zzfyfVar2;
        zzfyf zzfyfVar3;
        if (i < 0) {
            zzfyfVar3 = zzfyf.zzb;
            return zzfyfVar3;
        }
        if (i > 0) {
            zzfyfVar2 = zzfyf.zzc;
            return zzfyfVar2;
        }
        zzfyfVar = zzfyf.zza;
        return zzfyfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zzb(int i, int i2) {
        return zzf(Integer.compare(i, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zzd(boolean z, boolean z2) {
        return zzf(Boolean.compare(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zze(boolean z, boolean z2) {
        return zzf(Boolean.compare(z2, z));
    }
}
