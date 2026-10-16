package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes5.dex */
public final class zzbdr {
    private final Map zza = new HashMap();
    private final zzbdt zzb;

    public zzbdr(zzbdt zzbdtVar) {
        this.zzb = zzbdtVar;
    }

    public final zzbdt zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbdq zzbdqVar) {
        this.zza.put(str, zzbdqVar);
    }

    public final void zzc(String str, String str2, long j) {
        Map map = this.zza;
        zzbdq zzbdqVar = (zzbdq) map.get(str2);
        String[] strArr = {str};
        if (zzbdqVar != null) {
            this.zzb.zze(zzbdqVar, j, strArr);
        }
        map.put(str, new zzbdq(j, null, null));
    }
}
