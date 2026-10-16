package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.ironsource.C3040d4;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesa implements zzeub {
    public final Bundle zza;

    public zzesa(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        Bundle zza = zzfdk.zza(bundle, C3040d4.h.G);
        zza.putBundle("android_mem_info", this.zza);
        bundle.putBundle(C3040d4.h.G, zza);
    }
}
