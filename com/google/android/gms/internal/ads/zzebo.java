package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzebo extends zzebs {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    zzebo(String str, String str2, Drawable drawable) {
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.zzb = str2;
        this.zzc = drawable;
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzebs) {
            zzebs zzebsVar = (zzebs) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzebsVar.zzb()) : zzebsVar.zzb() == null) {
                if (this.zzb.equals(zzebsVar.zzc()) && ((drawable = this.zzc) != null ? drawable.equals(zzebsVar.zza()) : zzebsVar.zza() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        return "OfflineAdAssets{advertiserName=" + this.zza + ", imageUrl=" + this.zzb + ", icon=" + String.valueOf(this.zzc) + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzebs
    final Drawable zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzebs
    final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzebs
    final String zzc() {
        return this.zzb;
    }

    public final int hashCode() {
        String str = this.zza;
        int hashCode = (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        return (hashCode * 1000003) ^ (drawable != null ? drawable.hashCode() : 0);
    }
}
