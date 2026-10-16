package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzftb extends zzfud {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzftb(String str, String str2, zzfta zzftaVar) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfud) {
            zzfud zzfudVar = (zzfud) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfudVar.zzb()) : zzfudVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfudVar.zza()) : zzfudVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        return "OverlayDisplayUpdateRequest{sessionToken=" + this.zza + ", appId=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfud
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfud
    public final String zzb() {
        return this.zza;
    }

    public final int hashCode() {
        String str = this.zza;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        return ((hashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }
}
