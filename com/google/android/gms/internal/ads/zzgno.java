package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgno {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnn zzb = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgnm
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            int i = zzgno.zza;
            zzguf zzc2 = ((zzgne) zzgfmVar).zzb().zzc();
            zzgfa zzb2 = zzgmp.zzc().zzb(zzc2.zzi());
            if (!zzgmp.zzc().zze(zzc2.zzi())) {
                throw new GeneralSecurityException("Creating new keys is not allowed.");
            }
            zzgub zza2 = zzb2.zza(zzc2.zzh());
            return new zzgnd(zzgox.zza(zza2.zzg(), zza2.zzf(), zza2.zzb(), zzc2.zzg(), num), zzgey.zza());
        }
    };
    private static final zzgno zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgno zzb() {
        return zzc;
    }

    private final synchronized zzgez zzd(zzgfm zzgfmVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgnn zzgnnVar;
        zzgnnVar = (zzgnn) this.zzd.get(zzgfmVar.getClass());
        if (zzgnnVar == null) {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + zzgfmVar.toString() + ": no key creator for this class was registered.");
        }
        return zzgnnVar.zza(zzgfmVar, num);
    }

    private static zzgno zze() {
        zzgno zzgnoVar = new zzgno();
        try {
            zzgnoVar.zzc(zzb, zzgne.class);
            return zzgnoVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final zzgez zza(zzgfm zzgfmVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzd(zzgfmVar, num);
    }

    public final synchronized void zzc(zzgnn zzgnnVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzd;
        zzgnn zzgnnVar2 = (zzgnn) map.get(cls);
        if (zzgnnVar2 != null && !zzgnnVar2.equals(zzgnnVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class " + cls.toString() + " already inserted");
        }
        map.put(cls, zzgnnVar);
    }
}
