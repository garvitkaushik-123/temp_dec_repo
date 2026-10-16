package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfsq extends zzftc {
    private String zza;
    private String zzb;

    zzfsq() {
    }

    @Override // com.google.android.gms.internal.ads.zzftc
    public final zzftc zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzftc
    public final zzftc zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzftc
    public final zzftd zzc() {
        return new zzfss(this.zza, this.zzb, null);
    }
}
