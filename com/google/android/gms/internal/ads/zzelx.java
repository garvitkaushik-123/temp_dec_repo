package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzelx implements zzeub {
    private final boolean zza;

    public zzelx(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcva) obj).zza.putString("adid_p", true != this.zza ? "0" : "1");
    }
}
