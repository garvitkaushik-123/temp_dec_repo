package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbiw implements zzbkf {
    private final zzbix zza;

    public zzbiw(zzbix zzbixVar) {
        this.zza = zzbixVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str != null) {
            this.zza.zzb(str, (String) map.get("info"));
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App event with no name parameter.");
        }
    }
}
