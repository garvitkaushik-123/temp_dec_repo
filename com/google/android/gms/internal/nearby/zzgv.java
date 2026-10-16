package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzgv extends zzki {
    private final BaseImplementation.ResultHolder zza;

    zzgv(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkj
    public final void zzb(int i) {
        Status zzG;
        zzG = zzgy.zzG(i);
        if (zzG.isSuccess()) {
            this.zza.setResult(zzG);
        } else {
            this.zza.setFailedResult(zzG);
        }
    }
}
