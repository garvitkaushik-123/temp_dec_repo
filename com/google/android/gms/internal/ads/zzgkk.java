package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgkk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkg
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkk.zzd((zzghb) zzgfmVar);
            }
        }, zzghb.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgkh
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkk.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgki
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkk.zzc((zzggu) zzgezVar, zzgfnVar);
            }
        }, zzggu.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgkj
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkk.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzggu zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzgsp zzd2 = zzgsp.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggy zzd3 = zzghb.zzd();
            zzd3.zzb(zzd2.zzg().zzd());
            zzd3.zza(zzd2.zzf().zza());
            zzd3.zzc(16);
            zzd3.zzd(zzf(zzgoxVar.zzc()));
            zzghb zze2 = zzd3.zze();
            zzggs zzc2 = zzggu.zzc();
            zzc2.zzc(zze2);
            zzc2.zzb(zzgxf.zzb(zzd2.zzg().zzA(), zzgfnVar));
            zzc2.zza(zzgoxVar.zzf());
            return zzc2.zzd();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    public static /* synthetic */ zzghb zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgss zzd2 = zzgss.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza());
            zzggy zzd3 = zzghb.zzd();
            zzd3.zzb(zzd2.zza());
            zzd3.zza(zzd2.zzf().zza());
            zzd3.zzc(16);
            zzd3.zzd(zzf(zzgoyVar.zzc().zzg()));
            return zzd3.zze();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzggu zzgguVar, zzgfn zzgfnVar) {
        zzgsn zzb2 = zzgsp.zzb();
        zzb2.zzb(zzg(zzgguVar.zzd()));
        byte[] zzd2 = zzgguVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgsp) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzh(zzgguVar.zzd().zze()), zzgguVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzghb zzghbVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgsq zzb2 = zzgss.zzb();
        zzb2.zzb(zzg(zzghbVar));
        zzb2.zza(zzghbVar.zzc());
        zza2.zzc(((zzgss) zzb2.zzbr()).zzaN());
        zza2.zza(zzh(zzghbVar.zze()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzggz zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzggz.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzggz.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
            }
        }
        return zzggz.zzb;
    }

    private static zzgsv zzg(zzghb zzghbVar) throws GeneralSecurityException {
        zzgst zzb2 = zzgsv.zzb();
        zzb2.zza(zzghbVar.zzb());
        return (zzgsv) zzb2.zzbr();
    }

    private static zzgvf zzh(zzggz zzggzVar) throws GeneralSecurityException {
        if (zzggz.zza.equals(zzggzVar)) {
            return zzgvf.TINK;
        }
        if (zzggz.zzb.equals(zzggzVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzggz.zzc.equals(zzggzVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzggzVar))));
    }
}
