package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgrm {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgml zzc;
    private static final zzgml zzd;
    private static final zzgoh zze;
    private static final zzgod zzf;
    private static final zzgmx zzg;
    private static final zzgmt zzh;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzb2;
        zzgmj zza2 = zzgml.zza();
        zza2.zza(zzgvf.RAW, zzgqj.zzd);
        zza2.zza(zzgvf.TINK, zzgqj.zza);
        zza2.zza(zzgvf.LEGACY, zzgqj.zzc);
        zza2.zza(zzgvf.CRUNCHY, zzgqj.zzb);
        zzc = zza2.zzb();
        zzgmj zza3 = zzgml.zza();
        zza3.zza(zzgto.SHA1, zzgqi.zza);
        zza3.zza(zzgto.SHA224, zzgqi.zzb);
        zza3.zza(zzgto.SHA256, zzgqi.zzc);
        zza3.zza(zzgto.SHA384, zzgqi.zzd);
        zza3.zza(zzgto.SHA512, zzgqi.zze);
        zzd = zza3.zzb();
        zze = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgri
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgrm.zzb((zzgql) zzgfmVar);
            }
        }, zzgql.class, zzgoy.class);
        zzf = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgrj
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgrm.zzd((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zzg = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgrk
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgrm.zza((zzgqb) zzgezVar, zzgfnVar);
            }
        }, zzgqb.class, zzgox.class);
        zzh = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgrl
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgrm.zzc((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgqb zzgqbVar, zzgfn zzgfnVar) {
        zzgtp zzb2 = zzgtr.zzb();
        zzb2.zzb(zzf(zzgqbVar.zzc()));
        byte[] zzd2 = zzgqbVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgtr) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, (zzgvf) zzc.zzb(zzgqbVar.zzc().zzg()), zzgqbVar.zzf());
    }

    public static /* synthetic */ zzgoy zzb(zzgql zzgqlVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgts zzc2 = zzgtu.zzc();
        zzc2.zzb(zzf(zzgqlVar));
        zzc2.zza(zzgqlVar.zzc());
        zza2.zzc(((zzgtu) zzc2.zzbr()).zzaN());
        zza2.zza((zzgvf) zzc.zzb(zzgqlVar.zzg()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static /* synthetic */ zzgqb zzc(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgtr zzf2 = zzgtr.zzf(zzgoxVar.zze(), zzgyr.zza());
            if (zzf2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgqh zze2 = zzgql.zze();
            zze2.zzb(zzf2.zzh().zzd());
            zze2.zzc(zzf2.zzg().zza());
            zze2.zza((zzgqi) zzd.zzc(zzf2.zzg().zzb()));
            zze2.zzd((zzgqj) zzc.zzc(zzgoxVar.zzc()));
            zzgql zze3 = zze2.zze();
            zzgpz zzb2 = zzgqb.zzb();
            zzb2.zzc(zze3);
            zzb2.zzb(zzgxf.zzb(zzf2.zzh().zzA(), zzgfnVar));
            zzb2.zza(zzgoxVar.zzf());
            return zzb2.zzd();
        } catch (zzgzw | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzgql zzd(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgtu zzg2 = zzgtu.zzg(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzg2.zzb() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzg2.zzb());
            }
            zzgqh zze2 = zzgql.zze();
            zze2.zzb(zzg2.zza());
            zze2.zzc(zzg2.zzh().zza());
            zze2.zza((zzgqi) zzd.zzc(zzg2.zzh().zzb()));
            zze2.zzd((zzgqj) zzc.zzc(zzgoyVar.zzc().zzg()));
            return zze2.zze();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zze);
        zzgnyVar.zzh(zzf);
        zzgnyVar.zzg(zzg);
        zzgnyVar.zzf(zzh);
    }

    private static zzgtx zzf(zzgql zzgqlVar) throws GeneralSecurityException {
        zzgtv zzc2 = zzgtx.zzc();
        zzc2.zzb(zzgqlVar.zzb());
        zzc2.zza((zzgto) zzd.zzb(zzgqlVar.zzf()));
        return (zzgtx) zzc2.zzbr();
    }
}
