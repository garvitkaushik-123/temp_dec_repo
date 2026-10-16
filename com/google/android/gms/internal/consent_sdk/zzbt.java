package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzbt extends WebViewClient {
    final /* synthetic */ zzbv zza;

    /* synthetic */ zzbt(zzbv zzbvVar, zzbu zzbuVar) {
        this.zza = zzbvVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        zzcb zzcbVar;
        zzbv zzbvVar = this.zza;
        if (zzbv.zzf(zzbvVar, str)) {
            zzcbVar = zzbvVar.zzb;
            zzcbVar.zze(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        boolean z;
        zzbv zzbvVar = this.zza;
        z = zzbvVar.zzc;
        if (z) {
            return;
        }
        Log.d("UserMessagingPlatform", "Wall html loaded.");
        zzbvVar.zzc = true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zzcb zzcbVar;
        zzcbVar = this.zza.zzb;
        zzcbVar.zzf(i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        zzcb zzcbVar;
        String uri = webResourceRequest.getUrl().toString();
        zzbv zzbvVar = this.zza;
        if (!zzbv.zzf(zzbvVar, uri)) {
            return false;
        }
        zzcbVar = zzbvVar.zzb;
        zzcbVar.zze(uri);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzcb zzcbVar;
        zzbv zzbvVar = this.zza;
        if (!zzbv.zzf(zzbvVar, str)) {
            return false;
        }
        zzcbVar = zzbvVar.zzb;
        zzcbVar.zze(str);
        return true;
    }
}
