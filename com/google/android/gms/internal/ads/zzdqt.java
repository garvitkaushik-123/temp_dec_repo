package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdqt implements zzhgr {
    private final zzhha zza;

    private zzdqt(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzdqt zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdqt(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgdy zzc = zzffu.zzc();
        Set singleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzft)).booleanValue() ? Collections.singleton(new zzddv(((zzdrm) this.zza).zzb(), zzc)) : Collections.emptySet();
        zzhgz.zzb(singleton);
        return singleton;
    }
}
