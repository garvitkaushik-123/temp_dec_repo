package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgkx {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkt
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkx.zzd((zzghx) zzgfmVar);
            }
        }, zzghx.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgku
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkx.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgkv
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkx.zzc((zzghp) zzgezVar, zzgfnVar);
            }
        }, zzghp.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgkw
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkx.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzghp zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzgte zzd2 = zzgte.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzghu zzc2 = zzghx.zzc();
            zzc2.zza(zzd2.zzf().zzd());
            zzc2.zzb(zzf(zzgoxVar.zzc()));
            zzghx zzc3 = zzc2.zzc();
            zzghn zzc4 = zzghp.zzc();
            zzc4.zzc(zzc3);
            zzc4.zzb(zzgxf.zzb(zzd2.zzf().zzA(), zzgfnVar));
            zzc4.zza(zzgoxVar.zzf());
            return zzc4.zzd();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    public static /* synthetic */ zzghx zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgth zzf2 = zzgth.zzf(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzf2.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzghu zzc2 = zzghx.zzc();
            zzc2.zza(zzf2.zza());
            zzc2.zzb(zzf(zzgoyVar.zzc().zzg()));
            return zzc2.zzc();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzghp zzghpVar, zzgfn zzgfnVar) {
        zzgtc zzb2 = zzgte.zzb();
        byte[] zzd2 = zzghpVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgte) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzghpVar.zzd().zzd()), zzghpVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzghx zzghxVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgtf zzc2 = zzgth.zzc();
        zzc2.zza(zzghxVar.zzb());
        zza2.zzc(((zzgth) zzc2.zzbr()).zzaN());
        zza2.zza(zzg(zzghxVar.zzd()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzghv zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzghv.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghv.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
            }
        }
        return zzghv.zzb;
    }

    private static zzgvf zzg(zzghv zzghvVar) throws GeneralSecurityException {
        if (zzghv.zza.equals(zzghvVar)) {
            return zzgvf.TINK;
        }
        if (zzghv.zzb.equals(zzghvVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzghv.zzc.equals(zzghvVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghvVar))));
    }
}
