package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzev extends zzdm {
    private zzev() {
        throw null;
    }

    /* synthetic */ zzev(zzex zzexVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void zze(zze zzeVar) {
        OnAdInspectorClosedListener onAdInspectorClosedListener;
        onAdInspectorClosedListener = zzey.zzf().zzm;
        if (onAdInspectorClosedListener != null) {
            onAdInspectorClosedListener.onAdInspectorClosed(zzeVar == null ? null : new AdInspectorError(zzeVar.zza, zzeVar.zzb, zzeVar.zzc));
        }
    }
}
