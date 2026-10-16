package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
@Deprecated
/* loaded from: classes5.dex */
final class zzgb extends zzjx {
    private final ListenerHolder zza;

    public zzgb(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjy
    public final void zzb(zzkw zzkwVar) {
        this.zza.notifyListener(new zzga(this, zzkwVar));
    }
}
