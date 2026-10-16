package com.google.android.gms.internal.ads;

import android.os.Bundle;
import io.bidmachine.media3.exoplayer.upstream.CmcdConfiguration;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesq implements zzeub {
    private final String zza;
    private final Integer zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public zzesq(String str, Integer num, String str2, String str3, String str4, String str5) {
        this.zza = str;
        this.zzb = num;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcva) obj).zzb;
        zzfdk.zzc(bundle, "pn", this.zza);
        zzfdk.zzc(bundle, CmcdConfiguration.KEY_DEADLINE, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        zzfdk.zzc(bundle, "pn", this.zza);
        Integer num = this.zzb;
        if (num != null) {
            bundle.putInt("vc", num.intValue());
        }
        zzfdk.zzc(bundle, "vnm", this.zzc);
        zzfdk.zzc(bundle, CmcdConfiguration.KEY_DEADLINE, this.zzd);
        zzfdk.zzc(bundle, "ins_pn", this.zze);
        zzfdk.zzc(bundle, "ini_pn", this.zzf);
    }
}
