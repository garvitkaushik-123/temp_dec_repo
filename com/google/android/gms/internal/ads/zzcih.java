package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcih implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcih(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcih zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcih(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbvk zzb() {
        Context zza = ((zzchl) this.zza).zza();
        zzfhx zzfhxVar = (zzfhx) this.zzb.zzb();
        zzbow zzb = com.google.android.gms.ads.internal.zzv.zzg().zzb(zza, VersionInfoParcel.forPackage(), zzfhxVar);
        zzboq zzboqVar = zzbot.zza;
        zzb.zza("google.afma.request.getAdDictionary", zzboqVar, zzboqVar);
        return new zzbvm(zza, com.google.android.gms.ads.internal.zzv.zzg().zzb(zza, VersionInfoParcel.forPackage(), zzfhxVar).zza("google.afma.sdkConstants.getSdkConstants", zzboqVar, zzboqVar), VersionInfoParcel.forPackage());
    }
}
