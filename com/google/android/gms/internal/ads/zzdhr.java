package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdhr implements zzhgr {
    private final zzdhp zza;

    private zzdhr(zzdhp zzdhpVar) {
        this.zza = zzdhpVar;
    }

    public static zzdhr zza(zzdhp zzdhpVar) {
        return new zzdhr(zzdhpVar);
    }

    public static JSONObject zzc(zzdhp zzdhpVar) {
        JSONObject zzd = zzdhpVar.zzd();
        zzhgz.zzb(zzd);
        return zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }

    public final JSONObject zzd() {
        return zzc(this.zza);
    }
}
