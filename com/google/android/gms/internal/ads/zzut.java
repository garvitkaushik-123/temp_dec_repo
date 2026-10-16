package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzut {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzgi zzc;

    public zzut(zzaea zzaeaVar, zzakr zzakrVar) {
    }

    public final void zza(zzgi zzgiVar) {
        if (zzgiVar != this.zzc) {
            this.zzc = zzgiVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
