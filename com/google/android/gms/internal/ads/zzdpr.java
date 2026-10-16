package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdpr implements zzcwt {
    private final zzcfg zza;

    zzdpr(zzcfg zzcfgVar) {
        this.zza = zzcfgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdj(Context context) {
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            zzcfgVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdl(Context context) {
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            zzcfgVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdm(Context context) {
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            zzcfgVar.onResume();
        }
    }
}
