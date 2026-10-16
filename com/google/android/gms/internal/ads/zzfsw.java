package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfsw extends zzftz {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfsw() {
    }

    @Override // com.google.android.gms.internal.ads.zzftz
    public final zzftz zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzftz
    public final zzftz zzb(int i) {
        this.zza = i;
        this.zzc = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzftz
    public final zzfua zzc() {
        if (this.zzc == 1) {
            return new zzfsy(this.zza, this.zzb, null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
