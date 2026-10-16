package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfyx extends zzfwq {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfvq zzb;

    zzfyx(Iterator it, zzfvq zzfvqVar) {
        this.zza = it;
        this.zzb = zzfvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwq
    protected final Object zza() {
        zzfvq zzfvqVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzfvqVar = this.zzb;
            next = it.next();
        } while (!zzfvqVar.zza(next));
        return next;
    }
}
