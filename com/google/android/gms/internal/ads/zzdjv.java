package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdjv {
    private final zzdsj zza;

    zzdjv(zzdsj zzdsjVar) {
        this.zza = zzdsjVar;
    }

    public final void zza(View view, zzfca zzfcaVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznn)).booleanValue() || view == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzac.zza(view) ? "0" : "1";
        zzdsi zza = this.zza.zza();
        zza.zzb("action", "hcp");
        zza.zzb("hcp", str);
        zza.zzc(zzfcaVar);
        zza.zzj();
    }
}
