package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdiq {
    private zzbgm zza;

    public zzdiq(zzdib zzdibVar) {
        this.zza = zzdibVar;
    }

    public final synchronized zzbgm zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbgm zzbgmVar) {
        this.zza = zzbgmVar;
    }
}
