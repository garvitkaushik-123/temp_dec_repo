package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzccz implements zzbkf {
    private final zzdma zza;

    public zzccz(zzdma zzdmaVar) {
        this.zza = zzdmaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from video GMSG.");
            return;
        }
        if (str.equals("src")) {
            String str2 = (String) map.get("src");
            if (str2 == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("src missing from video GMSG.");
            } else {
                zzdma zzdmaVar = this.zza;
                Bundle bundle = new Bundle();
                bundle.putString("mediaUrl", str2);
                zzdmaVar.zza.zzc(bundle);
            }
        }
    }
}
