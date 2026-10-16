package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzgx extends zzkl {
    private final BaseImplementation.ResultHolder zza;

    zzgx(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkm
    public final void zzb(zzlm zzlmVar) {
        Status zzG;
        zzG = zzgy.zzG(zzlmVar.zza());
        if (zzG.isSuccess()) {
            this.zza.setResult(new zzgw(zzG, zzlmVar.zzb()));
        } else {
            this.zza.setFailedResult(zzG);
        }
    }
}
