package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcgz {
    private String zza = null;
    private zzhcs zzb = null;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    zzcgz() {
    }

    public final zzhcs zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjl)).booleanValue() && !this.zzc.getAndSet(true) && WebViewFeature.isFeatureSupported("GET_VARIATIONS_HEADER")) {
            try {
                String variationsHeader = WebViewCompat.getVariationsHeader();
                if (variationsHeader.isEmpty()) {
                    return;
                }
                this.zza = variationsHeader;
                this.zzb = zzhcs.zzd(Base64.decode(variationsHeader, 0), zzgyr.zzb());
            } catch (zzgzw | IllegalArgumentException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "ChromeVariations");
            }
        }
    }
}
