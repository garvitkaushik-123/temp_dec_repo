package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgkf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkb
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkf.zzd((zzggr) zzgfmVar);
            }
        }, zzggr.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgkc
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkf.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgkd
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkf.zzc((zzggi) zzgezVar, zzgfnVar);
            }
        }, zzggi.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgke
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkf.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzggi zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzgsa zzd2 = zzgsa.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzd2.zzf().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzd2.zzg().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzggn zzf2 = zzggr.zzf();
            zzf2.zza(zzd2.zzf().zzg().zzd());
            zzf2.zzc(zzd2.zzg().zzh().zzd());
            zzf2.zzd(zzd2.zzf().zzf().zza());
            zzf2.zze(zzd2.zzg().zzg().zza());
            zzf2.zzb(zzf(zzd2.zzg().zzg().zzb()));
            zzf2.zzf(zzg(zzgoxVar.zzc()));
            zzggr zzg = zzf2.zzg();
            zzggg zzc2 = zzggi.zzc();
            zzc2.zzd(zzg);
            zzc2.zza(zzgxf.zzb(zzd2.zzf().zzg().zzA(), zzgfnVar));
            zzc2.zzb(zzgxf.zzb(zzd2.zzg().zzh().zzA(), zzgfnVar));
            zzc2.zzc(zzgoxVar.zzf());
            return zzc2.zze();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    public static /* synthetic */ zzggr zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgsd zzc2 = zzgsd.zzc(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzc2.zzf().zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggn zzf2 = zzggr.zzf();
            zzf2.zza(zzc2.zzd().zza());
            zzf2.zzc(zzc2.zzf().zza());
            zzf2.zzd(zzc2.zzd().zzf().zza());
            zzf2.zze(zzc2.zzf().zzh().zza());
            zzf2.zzb(zzf(zzc2.zzf().zzh().zzb()));
            zzf2.zzf(zzg(zzgoyVar.zzc().zzg()));
            return zzf2.zzg();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzggi zzggiVar, zzgfn zzgfnVar) {
        zzgry zzb2 = zzgsa.zzb();
        zzgse zzb3 = zzgsg.zzb();
        zzgsk zzb4 = zzgsm.zzb();
        zzb4.zza(zzggiVar.zzd().zzd());
        zzb3.zzb((zzgsm) zzb4.zzbr());
        byte[] zzd2 = zzggiVar.zze().zzd(zzgfnVar);
        zzb3.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        zzb2.zza((zzgsg) zzb3.zzbr());
        zzgtp zzb5 = zzgtr.zzb();
        zzb5.zzb(zzh(zzggiVar.zzd()));
        byte[] zzd3 = zzggiVar.zzf().zzd(zzgfnVar);
        zzb5.zza(zzgxz.zzv(zzd3, 0, zzd3.length));
        zzb2.zzb((zzgtr) zzb5.zzbr());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgsa) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzi(zzggiVar.zzd().zzh()), zzggiVar.zzg());
    }

    public static /* synthetic */ zzgoy zzd(zzggr zzggrVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgsb zza3 = zzgsd.zza();
        zzgsh zzb2 = zzgsj.zzb();
        zzgsk zzb3 = zzgsm.zzb();
        zzb3.zza(zzggrVar.zzd());
        zzb2.zzb((zzgsm) zzb3.zzbr());
        zzb2.zza(zzggrVar.zzb());
        zza3.zza((zzgsj) zzb2.zzbr());
        zzgts zzc2 = zzgtu.zzc();
        zzc2.zzb(zzh(zzggrVar));
        zzc2.zza(zzggrVar.zzc());
        zza3.zzb((zzgtu) zzc2.zzbr());
        zza2.zzc(((zzgsd) zza3.zzbr()).zzaN());
        zza2.zza(zzi(zzggrVar.zzh()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzggo zzf(zzgto zzgtoVar) throws GeneralSecurityException {
        int ordinal = zzgtoVar.ordinal();
        if (ordinal == 1) {
            return zzggo.zza;
        }
        if (ordinal == 2) {
            return zzggo.zzd;
        }
        if (ordinal == 3) {
            return zzggo.zzc;
        }
        if (ordinal == 4) {
            return zzggo.zze;
        }
        if (ordinal == 5) {
            return zzggo.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzgtoVar.zza());
    }

    private static zzggp zzg(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzggp.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzggp.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
            }
        }
        return zzggp.zzb;
    }

    private static zzgtx zzh(zzggr zzggrVar) throws GeneralSecurityException {
        zzgto zzgtoVar;
        zzgtv zzc2 = zzgtx.zzc();
        zzc2.zzb(zzggrVar.zze());
        zzggo zzg = zzggrVar.zzg();
        if (zzggo.zza.equals(zzg)) {
            zzgtoVar = zzgto.SHA1;
        } else if (zzggo.zzb.equals(zzg)) {
            zzgtoVar = zzgto.SHA224;
        } else if (zzggo.zzc.equals(zzg)) {
            zzgtoVar = zzgto.SHA256;
        } else if (zzggo.zzd.equals(zzg)) {
            zzgtoVar = zzgto.SHA384;
        } else {
            if (!zzggo.zze.equals(zzg)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(String.valueOf(zzg))));
            }
            zzgtoVar = zzgto.SHA512;
        }
        zzc2.zza(zzgtoVar);
        return (zzgtx) zzc2.zzbr();
    }

    private static zzgvf zzi(zzggp zzggpVar) throws GeneralSecurityException {
        if (zzggp.zza.equals(zzggpVar)) {
            return zzgvf.TINK;
        }
        if (zzggp.zzb.equals(zzggpVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzggp.zzc.equals(zzggpVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzggpVar))));
    }
}
