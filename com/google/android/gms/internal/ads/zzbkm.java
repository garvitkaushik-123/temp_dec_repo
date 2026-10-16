package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import com.ironsource.C3040d4;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbkm implements zzbkf {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{n.g, "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbso zzc;
    private final zzbsv zzd;

    public zzbkm(com.google.android.gms.ads.internal.zzb zzbVar, zzbso zzbsoVar, zzbsv zzbsvVar) {
        this.zzb = zzbVar;
        this.zzc = zzbsoVar;
        this.zzd = zzbsvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        int intValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i = 6;
        if (intValue != 5) {
            if (intValue != 7) {
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzb;
                if (!zzbVar.zzc()) {
                    zzbVar.zzb(null);
                    return;
                }
                if (intValue == 1) {
                    this.zzc.zzc(map);
                    return;
                }
                if (intValue == 3) {
                    new zzbsr(zzcfgVar, map).zzb();
                    return;
                }
                if (intValue == 4) {
                    new zzbsl(zzcfgVar, map).zzc();
                    return;
                }
                if (intValue != 5) {
                    if (intValue == 6) {
                        this.zzc.zzb(true);
                        return;
                    } else if (intValue != 7) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean parseBoolean = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzcfgVar == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("AdWebView is null");
            return;
        }
        if (C3040d4.h.D.equalsIgnoreCase(str)) {
            i = 7;
        } else if (!C3040d4.h.C.equalsIgnoreCase(str)) {
            i = parseBoolean ? -1 : 14;
        }
        zzcfgVar.zzau(i);
    }
}
