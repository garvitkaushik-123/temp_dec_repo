package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzelb implements zzcyk {
    private final AtomicReference zza = new AtomicReference();

    public final void zza(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zza.set(zzdtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcyk
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzezf.zza(this.zza, new zzeze() { // from class: com.google.android.gms.internal.ads.zzela
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdt) obj).zze(com.google.android.gms.ads.internal.client.zzt.this);
            }
        });
    }
}
