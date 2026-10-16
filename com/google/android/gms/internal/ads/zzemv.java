package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzemv implements zzeuc {
    private final Set zza;

    zzemv(Set set) {
        this.zza = set;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return zzgdn.zzh(new zzemt(arrayList, null));
    }
}
