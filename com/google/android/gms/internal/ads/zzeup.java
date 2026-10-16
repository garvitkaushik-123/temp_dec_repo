package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.N6;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeup implements zzeub {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzeup(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
        this.zzf = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        zzfdk.zzf(bundle, N6.P0, this.zza, !TextUtils.isEmpty(r0));
        int i = this.zzb;
        zzfdk.zze(bundle, "cnt", i, i != -2);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle zza = zzfdk.zza(bundle, C3040d4.h.G);
        bundle.putBundle(C3040d4.h.G, zza);
        Bundle zza2 = zzfdk.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzf);
        zza2.putBoolean("active_network_metered", this.zze);
    }
}
