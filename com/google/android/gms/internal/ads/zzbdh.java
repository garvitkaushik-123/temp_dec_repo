package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.mbridge.msdk.MBridgeConstans;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbdh {
    private final String zza = (String) zzbey.zza.zze();
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbdh(Context context, String str) {
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put(N6.F, Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzv.zzr();
        linkedHashMap.put(C3040d4.h.G, com.google.android.gms.ads.internal.util.zzs.zzs());
        linkedHashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        com.google.android.gms.ads.internal.zzv.zzr();
        linkedHashMap.put("is_lite_sdk", true != com.google.android.gms.ads.internal.util.zzs.zzF(context) ? "0" : "1");
        Future zzb = com.google.android.gms.ads.internal.zzv.zzn().zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbvu) zzb.get()).zzj));
            linkedHashMap.put("network_fine", Integer.toString(((zzbvu) zzb.get()).zzk));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlM)).booleanValue()) {
            Map map = this.zzb;
            com.google.android.gms.ads.internal.zzv.zzr();
            map.put("is_bstar", true == com.google.android.gms.ads.internal.util.zzs.zzC(context) ? "1" : "0");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjQ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcC)).booleanValue() || zzfwg.zzd(com.google.android.gms.ads.internal.zzv.zzp().zzn())) {
                return;
            }
            this.zzb.put(N6.L, com.google.android.gms.ads.internal.zzv.zzp().zzn());
        }
    }

    final Context zza() {
        return this.zzc;
    }

    final String zzb() {
        return this.zzd;
    }

    final String zzc() {
        return this.zza;
    }

    final Map zzd() {
        return this.zzb;
    }
}
