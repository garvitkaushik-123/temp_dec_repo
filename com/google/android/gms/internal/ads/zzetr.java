package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzetr implements zzeub {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;

    zzetr(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3, String str2) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = i;
        this.zzf = i2;
        this.zzg = i3;
        this.zzh = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcva) obj).zzb;
        bundle.putString("js", this.zzc);
        bundle.putInt("target_api", this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdZ));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt("lv", this.zzg);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgi)).booleanValue()) {
            String str = this.zzh;
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("ev", str);
            }
        }
        Bundle zza = zzfdk.zza(bundle, "sdk_env");
        zza.putBoolean("mf", ((Boolean) zzbfe.zzc.zze()).booleanValue());
        zza.putBoolean("instant_app", this.zza);
        zza.putBoolean("lite", this.zzb);
        zza.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", zza);
        Bundle zza2 = zzfdk.zza(zza, "build_meta");
        zza2.putString("cl", "785558560");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
