package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdyq implements zzcza {
    private final Context zza;
    private final zzbyo zzb;

    zzdyq(Context context, zzbyo zzbyoVar) {
        this.zza = context;
        this.zzb = zzbyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
        String str = zzfcnVar.zzb.zzb.zze;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzbyo zzbyoVar = this.zzb;
        Context context = this.zza;
        zzbyoVar.zzm(context, zzfcnVar.zza.zza.zzd);
        zzbyoVar.zzi(context, str);
    }
}
