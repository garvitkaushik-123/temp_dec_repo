package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcgd implements zzbkf {
    final /* synthetic */ zzcgf zza;

    zzcgd(zzcgf zzcgfVar) {
        Objects.requireNonNull(zzcgfVar);
        this.zza = zzcgfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                zzcgf zzcgfVar = this.zza;
                synchronized (zzcgfVar) {
                    i = zzcgfVar.zzI;
                    if (i != parseInt) {
                        zzcgfVar.zzI = parseInt;
                        zzcgfVar.requestLayout();
                    }
                }
            } catch (Exception e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Exception occurred while getting webview content height", e);
            }
        }
    }
}
