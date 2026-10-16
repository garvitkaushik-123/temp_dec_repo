package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.WebView;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbeo;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzgdy;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzbu extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    zzbu(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        Objects.requireNonNull(taggingLibraryJsInterface);
        this.zzb = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        String str2;
        zzgdy zzgdyVar;
        zzj zzjVar;
        WebView webView;
        zzf zzfVar;
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            zzfVar = this.zzb.zzk;
            str2 = ",\"as\":".concat(zzfVar.zza().toString());
        } else {
            str2 = "";
        }
        String str3 = this.zza;
        Locale locale = Locale.getDefault();
        zzbeo zzbeoVar = zzbfj.zze;
        final String format = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", str3, str, Long.valueOf(((Boolean) zzbeoVar.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L), str2);
        if (((Boolean) zzbeoVar.zze()).booleanValue()) {
            try {
                zzgdyVar = this.zzb.zzh;
                zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbs
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebView webView2;
                        webView2 = zzbu.this.zzb.zzb;
                        webView2.evaluateJavascript(format, null);
                    }
                });
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            webView = this.zzb.zzb;
            webView.evaluateJavascript(format, null);
        }
        if (((Boolean) zzbfj.zzc.zze()).booleanValue() && ((Boolean) zzbfj.zzd.zze()).booleanValue()) {
            zzjVar = this.zzb.zzl;
            zzjVar.zzb();
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        final String format;
        zzf zzfVar;
        zzgdy zzgdyVar;
        zzj zzjVar;
        WebView webView;
        zzf zzfVar2;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                zzfVar2 = this.zzb.zzk;
                jSONObject.put("as", zzfVar2.zza());
            }
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L);
            jSONObject.put("signal", query);
            format = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                zzfVar = this.zzb.zzk;
                str = ",\"as\":".concat(zzfVar.zza().toString());
            } else {
                str = "";
            }
            format = String.format(Locale.getDefault(), "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", this.zza, queryInfo.getQuery(), Long.valueOf(((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L), str);
        }
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            try {
                zzgdyVar = this.zzb.zzh;
                zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbt
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebView webView2;
                        webView2 = zzbu.this.zzb.zzb;
                        webView2.evaluateJavascript(format, null);
                    }
                });
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            webView = this.zzb.zzb;
            webView.evaluateJavascript(format, null);
        }
        if (((Boolean) zzbfj.zzc.zze()).booleanValue() && ((Boolean) zzbfj.zzd.zze()).booleanValue()) {
            zzjVar = this.zzb.zzl;
            zzjVar.zzb();
        }
    }
}
