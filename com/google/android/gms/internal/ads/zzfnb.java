package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfnb implements Runnable {
    final /* synthetic */ zzfnc zza;
    private final WebView zzb;

    zzfnb(zzfnc zzfncVar) {
        WebView webView;
        Objects.requireNonNull(zzfncVar);
        this.zza = zzfncVar;
        webView = zzfncVar.zza;
        this.zzb = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
