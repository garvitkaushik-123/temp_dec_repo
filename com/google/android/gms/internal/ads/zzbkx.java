package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbkx implements zzbkf {
    private final zzbkw zza;

    public zzbkx(zzbkw zzbkwVar) {
        this.zza = zzbkwVar;
    }

    public static void zzb(zzcfg zzcfgVar, zzbkw zzbkwVar) {
        zzcfgVar.zzag("/reward", new zzbkx(zzbkwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zza.zzc();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zza.zzb();
                    return;
                }
                return;
            }
        }
        zzbwo zzbwoVar = null;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzbwoVar = new zzbwo(str2, parseInt);
            }
        } catch (NumberFormatException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to parse reward amount.", e);
        }
        this.zza.zza(zzbwoVar);
    }
}
