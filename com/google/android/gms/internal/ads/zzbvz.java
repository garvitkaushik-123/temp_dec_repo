package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbvz extends zzbwb {
    private final String zza;
    private final int zzb;

    public zzbvz(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbvz)) {
            return false;
        }
        zzbvz zzbvzVar = (zzbvz) obj;
        if (Objects.equal(this.zza, zzbvzVar.zza)) {
            if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbvzVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final String zzc() {
        return this.zza;
    }
}
