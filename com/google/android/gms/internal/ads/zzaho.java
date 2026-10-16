package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaho implements zzau {
    public final List zza;

    public zzaho(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzahn) list.get(0)).zzb;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (((zzahn) list.get(i)).zza < j) {
                    z = true;
                    break;
                } else {
                    j = ((zzahn) list.get(i)).zzb;
                    i++;
                }
            }
        }
        zzdd.zzd(!z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzaho) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
