package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzhgm {
    final LinkedHashMap zza;

    zzhgm(int i) {
        this.zza = zzhgo.zzb(i);
    }

    final zzhgm zza(Object obj, zzhha zzhhaVar) {
        zzhgz.zza(obj, C3040d4.h.W);
        zzhgz.zza(zzhhaVar, IronSourceConstants.EVENTS_PROVIDER);
        this.zza.put(obj, zzhhaVar);
        return this;
    }
}
