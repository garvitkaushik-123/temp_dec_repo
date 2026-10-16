package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgp implements zzgi {
    private final Context zza;
    private final zzgi zzb;

    public zzgp(Context context) {
        zzgr zzgrVar = new zzgr();
        this.zza = context.getApplicationContext();
        this.zzb = zzgrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final /* bridge */ /* synthetic */ zzgj zza() {
        return new zzgq(this.zza, this.zzb.zza());
    }
}
