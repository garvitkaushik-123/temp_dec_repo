package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzggm {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzggj
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgwg.zzb((zzggi) zzgezVar);
        }
    }, zzggi.class, zzget.class);
    private static final zzgfa zzc = zzgmz.zzd("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzget.class, zzgtz.SYMMETRIC, zzgsa.zzh());
    private static final zzgnp zzd = new zzgnp() { // from class: com.google.android.gms.internal.ads.zzggk
    };
    private static final zzgnn zze = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzggl
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            zzggr zzggrVar = (zzggr) zzgfmVar;
            int i = zzggm.zza;
            if (zzggrVar.zzb() != 16 && zzggrVar.zzb() != 32) {
                throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
            }
            zzggg zzgggVar = new zzggg(null);
            zzgggVar.zzd(zzggrVar);
            zzgggVar.zzc(num);
            zzgggVar.zza(zzgxf.zzc(zzggrVar.zzb()));
            zzgggVar.zzb(zzgxf.zzc(zzggrVar.zzc()));
            return zzgggVar.zze();
        }
    };
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzgmg.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgkf.zza;
        zzgkf.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgnu zzb2 = zzgnu.zzb();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzgjn.zze);
        zzggn zzggnVar = new zzggn(null);
        zzggnVar.zza(16);
        zzggnVar.zzc(32);
        zzggnVar.zze(16);
        zzggnVar.zzd(16);
        zzggo zzggoVar = zzggo.zzc;
        zzggnVar.zzb(zzggoVar);
        zzggp zzggpVar = zzggp.zzc;
        zzggnVar.zzf(zzggpVar);
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzggnVar.zzg());
        hashMap.put("AES256_CTR_HMAC_SHA256", zzgjn.zzf);
        zzggn zzggnVar2 = new zzggn(null);
        zzggnVar2.zza(32);
        zzggnVar2.zzc(32);
        zzggnVar2.zze(32);
        zzggnVar2.zzd(16);
        zzggnVar2.zzb(zzggoVar);
        zzggnVar2.zzf(zzggpVar);
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzggnVar2.zzg());
        zzb2.zzd(Collections.unmodifiableMap(hashMap));
        zzgnq.zza().zzb(zzd, zzggr.class);
        zzgno.zzb().zzc(zze, zzggr.class);
        zzgmp.zzc().zzf(zzc, i, true);
    }
}
