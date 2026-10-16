package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcgm {
    private final zzcgn zza;
    private final zzcgl zzb;

    public zzcgm(zzcgn zzcgnVar, zzcgl zzcglVar) {
        this.zzb = zzcglVar;
        this.zza = zzcgnVar;
    }

    public static /* synthetic */ void zza(zzcgm zzcgmVar, String str) {
        Uri parse = Uri.parse(str);
        zzcfo zzaO = ((zzcgf) zzcgmVar.zzb.zza).zzaO();
        if (zzaO != null) {
            zzaO.zzn(parse);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        }
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        zzcgn zzcgnVar = this.zza;
        zzavu zzI = ((zzcgt) zzcgnVar).zzI();
        if (zzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzavp zzc = zzI.zzc();
        if (zzc == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcgnVar.getContext() != null) {
            return zzc.zze(zzcgnVar.getContext(), str, ((zzcgv) zzcgnVar).zzF(), zzcgnVar.zzi());
        }
        com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignals() {
        zzcgn zzcgnVar = this.zza;
        zzavu zzI = ((zzcgt) zzcgnVar).zzI();
        if (zzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzavp zzc = zzI.zzc();
        if (zzc == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcgnVar.getContext() != null) {
            return zzc.zzh(zzcgnVar.getContext(), ((zzcgv) zzcgnVar).zzF(), zzcgnVar.zzi());
        }
        com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgk
                @Override // java.lang.Runnable
                public final void run() {
                    zzcgm.zza(zzcgm.this, str);
                }
            });
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("URL is empty, ignoring message");
        }
    }
}
