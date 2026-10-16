package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfdz implements zzhgr {
    private zzfdz(zzfdy zzfdyVar) {
    }

    public static zzfdz zza(zzfdy zzfdyVar) {
        return new zzfdz(zzfdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        Clock defaultClock = DefaultClock.getInstance();
        zzhgz.zzb(defaultClock);
        return defaultClock;
    }
}
