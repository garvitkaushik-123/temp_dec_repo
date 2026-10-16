package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzety implements zzeub {
    private final Bundle zza;

    public zzety(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (bundle.isEmpty()) {
            return;
        }
        zzcvaVar.zzb.putBundle("shared_pref", bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (bundle.isEmpty()) {
            return;
        }
        zzcvaVar.zza.putBundle("shared_pref", bundle);
    }
}
