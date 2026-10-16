package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfmo implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    zzfmo(zzfmp zzfmpVar, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
        Objects.requireNonNull(zzfmpVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfmp.zzk(this.zza, this.zzb);
    }
}
