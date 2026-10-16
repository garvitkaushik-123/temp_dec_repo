package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfsv extends zzfty {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* synthetic */ zzfsv(IBinder iBinder, String str, int i, float f, int i2, int i3, String str2, int i4, String str3, String str4, String str5, zzfsu zzfsuVar) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i4;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfty) {
            zzfty zzftyVar = (zzfty) obj;
            if (this.zza.equals(zzftyVar.zzf()) && ((str = this.zzb) != null ? str.equals(zzftyVar.zzh()) : zzftyVar.zzh() == null) && this.zzc == zzftyVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzftyVar.zza())) {
                zzftyVar.zzb();
                zzftyVar.zzd();
                zzftyVar.zzj();
                if (this.zze == zzftyVar.zze()) {
                    zzftyVar.zzi();
                    String str2 = this.zzf;
                    if (str2 != null ? str2.equals(zzftyVar.zzg()) : zzftyVar.zzg() == null) {
                        zzftyVar.zzk();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int hashCode2 = (((((hashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i = this.zze;
        String str2 = this.zzf;
        return ((((hashCode2 * 1525764945) ^ i) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        return "OverlayDisplayShowRequest{windowToken=" + this.zza.toString() + ", appId=" + this.zzb + ", layoutGravity=" + this.zzc + ", layoutVerticalMargin=" + this.zzd + ", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=" + this.zze + ", deeplinkUrl=null, adFieldEnifd=" + this.zzf + ", thirdPartyAuthCallerId=null}";
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final float zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final IBinder zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzk() {
        return null;
    }
}
