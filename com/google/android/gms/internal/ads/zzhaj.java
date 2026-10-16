package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhaj implements zzhaq {
    private final zzhaq[] zza;

    zzhaj(zzhaq... zzhaqVarArr) {
        this.zza = zzhaqVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final zzhap zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzhaq zzhaqVar = this.zza[i];
            if (zzhaqVar.zzc(cls)) {
                return zzhaqVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
