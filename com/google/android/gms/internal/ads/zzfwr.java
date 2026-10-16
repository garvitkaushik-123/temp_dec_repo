package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzfwr extends zzfxi implements zzfzb {
    protected zzfwr(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    final Collection zzb(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    final Collection zzc(Object obj, Collection collection) {
        return zzh(obj, (List) collection, null);
    }
}
