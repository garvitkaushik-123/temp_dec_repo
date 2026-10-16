package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzflw {
    private final zzfly zza;
    private final WebView zzb;
    private zzfnz zzc;
    private final HashMap zzd;
    private final zzfmm zze;

    private zzflw(zzfly zzflyVar, WebView webView, boolean z) {
        HashMap hashMap = new HashMap();
        this.zzd = hashMap;
        this.zze = new zzfmm();
        zzfni.zza();
        this.zza = zzflyVar;
        this.zzb = webView;
        if (zza() != webView) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((zzfll) it.next()).zzd(webView);
            }
            this.zzc = new zzfnz(webView);
        }
        if (!WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
        }
        zzh();
        WebViewCompat.addWebMessageListener(this.zzb, "omidJsSessionService", new HashSet(Arrays.asList("*")), new zzflv(this));
    }

    public static zzflw zzb(zzfly zzflyVar, WebView webView, boolean z) {
        return new zzflw(zzflyVar, webView, true);
    }

    static /* bridge */ /* synthetic */ void zzc(zzflw zzflwVar, String str) {
        HashMap hashMap = zzflwVar.zzd;
        zzfll zzfllVar = (zzfll) hashMap.get(str);
        if (zzfllVar != null) {
            zzfllVar.zzc();
            hashMap.remove(str);
        }
    }

    static /* bridge */ /* synthetic */ void zze(zzflw zzflwVar, String str) {
        zzflq zzflqVar = zzflq.DEFINED_BY_JAVASCRIPT;
        zzflt zzfltVar = zzflt.DEFINED_BY_JAVASCRIPT;
        zzflx zzflxVar = zzflx.JAVASCRIPT;
        zzflp zzflpVar = new zzflp(zzflm.zza(zzflqVar, zzfltVar, zzflxVar, zzflxVar, false), zzfln.zzb(zzflwVar.zza, zzflwVar.zzb, null, null), str);
        zzflwVar.zzd.put(str, zzflpVar);
        zzflpVar.zzd(zzflwVar.zza());
        for (zzfml zzfmlVar : zzflwVar.zze.zza()) {
            zzflpVar.zzb((View) zzfmlVar.zzb().get(), zzfmlVar.zza(), zzfmlVar.zzc());
        }
        zzflpVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh() {
        WebViewCompat.removeWebMessageListener(this.zzb, "omidJsSessionService");
    }

    final View zza() {
        zzfnz zzfnzVar = this.zzc;
        if (zzfnzVar == null) {
            return null;
        }
        return (View) zzfnzVar.get();
    }

    public final void zzf(View view, zzfls zzflsVar, String str) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfll) it.next()).zzb(view, zzflsVar, "Ad overlay");
        }
        this.zze.zzb(view, zzflsVar, "Ad overlay");
    }

    public final void zzg(zzcfx zzcfxVar) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfll) it.next()).zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzflu(this, zzcfxVar, timer), 1000L);
    }
}
