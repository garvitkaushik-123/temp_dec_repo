package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzftv extends zzfso {
    final /* synthetic */ zzftw zza;
    private final zzfub zzb;

    zzftv(zzftw zzftwVar, zzfub zzfubVar) {
        Objects.requireNonNull(zzftwVar);
        this.zza = zzftwVar;
        this.zzb = zzfubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsp
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzftz zzc = zzfua.zzc();
        zzc.zzb(i);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i == 8157) {
            this.zza.zzd();
        }
    }
}
