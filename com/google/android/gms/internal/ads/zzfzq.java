package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfzq extends zzfzu {
    final /* synthetic */ Comparator zza;

    zzfzq(Comparator comparator) {
        this.zza = comparator;
    }

    @Override // com.google.android.gms.internal.ads.zzfzu
    final Map zza() {
        return new TreeMap(this.zza);
    }
}
