package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerh implements zzeub {
    private final Integer zza;

    public zzerh(Integer num) {
        this.zza = num;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (num != null) {
            zzcvaVar.zza.putInt("dspct", Math.min(num.intValue(), 20));
        }
    }
}
