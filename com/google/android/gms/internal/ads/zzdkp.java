package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdkp {
    private final zzdpj zza;
    private final zzdny zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdkp(zzdpj zzdpjVar, zzdny zzdnyVar) {
        this.zza = zzdpjVar;
        this.zzb = zzdnyVar;
    }

    public static /* synthetic */ void zzb(zzdkp zzdkpVar, WindowManager windowManager, View view, zzcfg zzcfgVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Hide native ad policy validator overlay.");
        zzcfgVar.zzF().setVisibility(8);
        if (zzcfgVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcfgVar.zzF());
        }
        zzcfgVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (zzdkpVar.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(zzdkpVar.zzc);
    }

    public static /* synthetic */ void zzc(final zzdkp zzdkpVar, final View view, final WindowManager windowManager, zzcfg zzcfgVar, final Map map) {
        final zzcfg zzcfgVar2;
        zzcfgVar.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdkn
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str, String str2) {
                zzdkp.zzd(zzdkp.this, map, z, i, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziw)).intValue());
        int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzix)).intValue());
        int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcfgVar.zzaj(zzchd.zzb(zzf, zzf2));
        try {
            zzcfgVar.zzG().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziy)).booleanValue());
            zzcfgVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziz)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams zzb = com.google.android.gms.ads.internal.util.zzbv.zzb();
        zzb.x = zzf3;
        zzb.y = zzf4;
        windowManager.updateViewLayout(zzcfgVar.zzF(), zzb);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i = (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - zzf4;
            zzcfgVar2 = zzcfgVar;
            zzdkpVar.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdko
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcfg zzcfgVar3 = zzcfgVar2;
                        if (zzcfgVar3.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i2 = i;
                        WindowManager.LayoutParams layoutParams = zzb;
                        String str2 = str;
                        if ("1".equals(str2) || "2".equals(str2)) {
                            layoutParams.y = rect2.bottom - i2;
                        } else {
                            layoutParams.y = rect2.top - i2;
                        }
                        windowManager.updateViewLayout(zzcfgVar3.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(zzdkpVar.zzc);
            }
        } else {
            zzcfgVar2 = zzcfgVar;
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzcfgVar2.loadUrl(str2);
    }

    public static /* synthetic */ void zzd(zzdkp zzdkpVar, Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        zzdkpVar.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
    }

    public final View zza(final View view, final WindowManager windowManager) throws zzcfs {
        zzcfg zza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        zza.zzF().setVisibility(4);
        zza.zzF().setContentDescription("policy_validator");
        zza.zzag("/sendMessageToSdk", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkj
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkp.this.zzb.zzj("sendMessageToNativeJs", map);
            }
        });
        zza.zzag("/hideValidatorOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkk
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkp.zzb(zzdkp.this, windowManager, view, (zzcfg) obj, map);
            }
        });
        zza.zzag("/open", new zzbkr(null, null, null, null, null));
        WeakReference weakReference = new WeakReference(zza);
        zzbkf zzbkfVar = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkl
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkp.zzc(zzdkp.this, view, windowManager, (zzcfg) obj, map);
            }
        };
        zzdny zzdnyVar = this.zzb;
        zzdnyVar.zzm(weakReference, "/loadNativeAdPolicyViolations", zzbkfVar);
        zzdnyVar.zzm(new WeakReference(zza), "/showValidatorOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkm
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Show native ad policy validator overlay.");
                ((zzcfg) obj).zzF().setVisibility(0);
            }
        });
        return zza.zzF();
    }
}
