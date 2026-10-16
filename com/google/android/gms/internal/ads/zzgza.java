package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgza implements zzhaq {
    private static final zzgza zza = new zzgza();

    private zzgza() {
    }

    public static zzgza zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final zzhap zzb(Class cls) {
        if (!zzgzh.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzhap) zzgzh.zzbh(cls.asSubclass(zzgzh.class)).zzbO();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final boolean zzc(Class cls) {
        return zzgzh.class.isAssignableFrom(cls);
    }
}
