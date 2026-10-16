package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgfc {
    public static final zzgfm zza(zzgfm zzgfmVar) throws GeneralSecurityException {
        return zzgfmVar != null ? zzgfmVar : zzgfo.zza(zzb(null).zzaV());
    }

    static final zzguf zzb(zzgfm zzgfmVar) {
        try {
            return ((zzgoy) zzgny.zzc().zze(null, zzgoy.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgpi("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
