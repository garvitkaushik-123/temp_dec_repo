package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhgp implements zzhgr {
    private zzhha zza;

    public static void zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        zzhgp zzhgpVar = (zzhgp) zzhhaVar;
        if (zzhgpVar.zza != null) {
            throw new IllegalStateException();
        }
        zzhgpVar.zza = zzhhaVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzhha zzhhaVar = this.zza;
        if (zzhhaVar != null) {
            return zzhhaVar.zzb();
        }
        throw new IllegalStateException();
    }
}
