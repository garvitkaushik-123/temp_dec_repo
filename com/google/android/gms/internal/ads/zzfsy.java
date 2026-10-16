package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfsy extends zzfua {
    private final int zza;
    private final String zzb;

    /* synthetic */ zzfsy(int i, String str, zzfsx zzfsxVar) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfua) {
            zzfua zzfuaVar = (zzfua) obj;
            if (this.zza == zzfuaVar.zza() && ((str = this.zzb) != null ? str.equals(zzfuaVar.zzb()) : zzfuaVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "OverlayDisplayState{statusCode=" + this.zza + ", sessionToken=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final String zzb() {
        return this.zzb;
    }
}
