package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdkh {
    private final zzdpj zza;
    private final zzdny zzb;
    private final zzcnx zzc;
    private final zzdjb zzd;

    public zzdkh(zzdpj zzdpjVar, zzdny zzdnyVar, zzcnx zzcnxVar, zzdjb zzdjbVar) {
        this.zza = zzdpjVar;
        this.zzb = zzdnyVar;
        this.zzc = zzcnxVar;
        this.zzd = zzdjbVar;
    }

    public static /* synthetic */ void zzb(zzdkh zzdkhVar, zzcfg zzcfgVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Hiding native ads overlay.");
        zzcfgVar.zzF().setVisibility(8);
        zzdkhVar.zzc.zze(false);
    }

    public static /* synthetic */ void zzd(zzdkh zzdkhVar, zzcfg zzcfgVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Showing native ads overlay.");
        zzcfgVar.zzF().setVisibility(0);
        zzdkhVar.zzc.zze(true);
    }

    public static /* synthetic */ void zze(zzdkh zzdkhVar, Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        zzdkhVar.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    public final View zza() throws zzcfs {
        zzcfg zza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        zza.zzF().setVisibility(8);
        zza.zzag("/sendMessageToSdk", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkb
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkh.this.zzb.zzj("sendMessageToNativeJs", map);
            }
        });
        zza.zzag("/adMuted", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkc
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkh.this.zzd.zzi();
            }
        });
        WeakReference weakReference = new WeakReference(zza);
        zzbkf zzbkfVar = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkd
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, final Map map) {
                zzcfg zzcfgVar = (zzcfg) obj;
                zzcgy zzN = zzcfgVar.zzN();
                final zzdkh zzdkhVar = zzdkh.this;
                zzN.zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdkg
                    @Override // com.google.android.gms.internal.ads.zzcgw
                    public final void zza(boolean z, int i, String str, String str2) {
                        zzdkh.zze(zzdkh.this, map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcfgVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcfgVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        };
        zzdny zzdnyVar = this.zzb;
        zzdnyVar.zzm(weakReference, "/loadHtml", zzbkfVar);
        zzdnyVar.zzm(new WeakReference(zza), "/showOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdke
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkh.zzd(zzdkh.this, (zzcfg) obj, map);
            }
        });
        zzdnyVar.zzm(new WeakReference(zza), "/hideOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkf
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkh.zzb(zzdkh.this, (zzcfg) obj, map);
            }
        });
        return zza.zzF();
    }
}
