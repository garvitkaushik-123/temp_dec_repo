package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdbz implements zzhgr {
    private final zzdbw zza;

    private zzdbz(zzdbw zzdbwVar) {
        this.zza = zzdbwVar;
    }

    public static zzdbz zza(zzdbw zzdbwVar) {
        return new zzdbz(zzdbwVar);
    }

    public static Set zzc(zzdbw zzdbwVar) {
        Set emptySet = Collections.emptySet();
        zzhgz.zzb(emptySet);
        return emptySet;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
