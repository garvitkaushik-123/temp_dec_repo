package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhgz;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbb implements zzhgr {
    private final zzaz zza;

    private zzbb(zzaz zzazVar) {
        this.zza = zzazVar;
    }

    public static zzbb zza(zzaz zzazVar) {
        return new zzbb(zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        String zzc = this.zza.zzc();
        zzhgz.zzb(zzc);
        return zzc;
    }
}
