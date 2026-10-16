package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgcv extends zzgcx {
    zzgcv(zzfyl zzfylVar, boolean z) {
        super(zzfylVar, z);
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzgcx
    public final /* bridge */ /* synthetic */ Object zzD(List list) {
        ArrayList zzb = zzfzg.zzb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgcw zzgcwVar = (zzgcw) it.next();
            zzb.add(zzgcwVar != null ? zzgcwVar.zza : null);
        }
        return Collections.unmodifiableList(zzb);
    }
}
