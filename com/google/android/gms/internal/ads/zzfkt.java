package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import java.util.Locale;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfkt {
    private final String zza;
    private final AdFormat zzb;
    private final String zzc;

    /* synthetic */ zzfkt(zzfkr zzfkrVar, zzfks zzfksVar) {
        String str;
        AdFormat adFormat;
        String str2;
        str = zzfkrVar.zza;
        this.zza = str;
        adFormat = zzfkrVar.zzb;
        this.zzb = adFormat;
        str2 = zzfkrVar.zzc;
        this.zzc = str2;
    }

    public final boolean equals(Object obj) {
        AdFormat adFormat;
        AdFormat adFormat2;
        if (obj instanceof zzfkt) {
            zzfkt zzfktVar = (zzfkt) obj;
            if (this.zza.equals(zzfktVar.zza) && (adFormat = this.zzb) != null && (adFormat2 = zzfktVar.zzb) != null && adFormat.equals(adFormat2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String zza() {
        AdFormat adFormat = this.zzb;
        return adFormat == null ? "unknown" : adFormat.name().toLowerCase(Locale.ENGLISH);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }
}
