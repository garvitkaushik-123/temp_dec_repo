package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfwl {
    public static zzfwh zza(zzfwh zzfwhVar) {
        return ((zzfwhVar instanceof zzfwk) || (zzfwhVar instanceof zzfwi)) ? zzfwhVar : zzfwhVar instanceof Serializable ? new zzfwi(zzfwhVar) : new zzfwk(zzfwhVar);
    }
}
