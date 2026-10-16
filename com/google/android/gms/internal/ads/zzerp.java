package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerp implements zzeub {
    private final Boolean zza;

    public zzerp(Boolean bool) {
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Boolean bool = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (bool != null) {
            zzcvaVar.zza.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
