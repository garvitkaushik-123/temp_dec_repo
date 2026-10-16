package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzghi {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzghf
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgwd.zzb((zzghe) zzgezVar);
        }
    }, zzghe.class, zzget.class);
    private static final zzgfa zzc = zzgmz.zzd("type.googleapis.com/google.crypto.tink.AesGcmKey", zzget.class, zzgtz.SYMMETRIC, zzgsy.zzg());
    private static final zzgnp zzd = new zzgnp() { // from class: com.google.android.gms.internal.ads.zzghg
    };
    private static final zzgnn zze = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzghh
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            zzghm zzghmVar = (zzghm) zzgfmVar;
            int i = zzghi.zza;
            if (zzghmVar.zzb() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzghc zzghcVar = new zzghc(null);
            zzghcVar.zzc(zzghmVar);
            zzghcVar.zza(num);
            zzghcVar.zzb(zzgxf.zzc(zzghmVar.zzb()));
            return zzghcVar.zzd();
        }
    };
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzgmg.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgkr.zza;
        zzgkr.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgnu zzb2 = zzgnu.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzgjn.zza);
        zzghj zzghjVar = new zzghj(null);
        zzghjVar.zza(12);
        zzghjVar.zzb(16);
        zzghjVar.zzc(16);
        zzghk zzghkVar = zzghk.zzc;
        zzghjVar.zzd(zzghkVar);
        hashMap.put("AES128_GCM_RAW", zzghjVar.zze());
        hashMap.put("AES256_GCM", zzgjn.zzb);
        zzghj zzghjVar2 = new zzghj(null);
        zzghjVar2.zza(12);
        zzghjVar2.zzb(32);
        zzghjVar2.zzc(16);
        zzghjVar2.zzd(zzghkVar);
        hashMap.put("AES256_GCM_RAW", zzghjVar2.zze());
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzgnq.zza().zzb(zzd, zzghm.class);
        zzgno.zzb().zzc(zze, zzghm.class);
        zzgmp.zzc().zzf(zzc, i, true);
    }
}
