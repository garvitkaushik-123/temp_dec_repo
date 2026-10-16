package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeqi implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeqi(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeqi zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqi(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfyv zzn;
        zzerg zzb = ((zzeri) this.zza).zzb();
        Context zza = ((zzchl) this.zzb).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlO)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzr();
            if (com.google.android.gms.ads.internal.util.zzs.zzC(zza)) {
                zzn = zzfyv.zzo(zzb);
                zzhgz.zzb(zzn);
                return zzn;
            }
        }
        zzn = zzfyv.zzn();
        zzhgz.zzb(zzn);
        return zzn;
    }
}
