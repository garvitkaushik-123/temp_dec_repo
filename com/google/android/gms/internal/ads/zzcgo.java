package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzcgo extends zzcfo {
    public zzcgo(zzcfg zzcfgVar, zzbcc zzbccVar, boolean z, zzecl zzeclVar) {
        super(zzcfgVar, zzbccVar, z, new zzbst(zzcfgVar, zzcfgVar.zzE(), new zzbcm(zzcfgVar.getContext())), null, zzeclVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse zzY(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcfg)) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcfg zzcfgVar = (zzcfg) webView;
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            zzbyaVar.zze(str, map, 1);
        }
        zzfqs.zza();
        zzfqy zzfqyVar = zzfqy.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcfgVar.zzN() != null) {
            zzcfgVar.zzN().zzI();
        }
        if (zzcfgVar.zzO().zzi()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaf);
        } else if (zzcfgVar.zzaF()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzae);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzad);
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        return com.google.android.gms.ads.internal.util.zzs.zzy(zzcfgVar.getContext(), zzcfgVar.zzm().afmaVersion, str2);
    }
}
