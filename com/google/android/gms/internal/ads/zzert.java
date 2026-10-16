package com.google.android.gms.internal.ads;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzert implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzert(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzert zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzert(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzerr zzb() {
        return new zzerr(((zzchl) this.zza).zza(), (Intent) this.zzb.zzb());
    }
}
