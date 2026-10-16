package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcmd implements zzhgr {
    private final zzhha zza;

    private zzcmd(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcmd zza(zzhha zzhhaVar) {
        return new zzcmd(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcmc((Context) this.zza.zzb());
    }
}
