package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcta implements com.google.android.gms.ads.internal.client.zza {
    private final zzcte zza;
    private final zzfcw zzb;

    zzcta(zzcte zzcteVar, zzfcw zzfcwVar) {
        this.zza = zzcteVar;
        this.zzb = zzfcwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
