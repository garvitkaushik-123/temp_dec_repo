package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzglt {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzglp
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzglt.zzd((zzgjt) zzgfmVar);
            }
        }, zzgjt.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzglq
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzglt.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzglr
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzglt.zzc((zzgjo) zzgezVar, zzgfnVar);
            }
        }, zzgjo.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgls
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzglt.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzgjo zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
        try {
            zzgvl zzd2 = zzgvl.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzd2.zzg().zzd() == 32) {
                return zzgjo.zzc(zzgjt.zzd(zzf(zzgoxVar.zzc()), zzd2.zzf().zza()), zzgxf.zzb(zzd2.zzg().zzA(), zzgfnVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only 32 byte key size is accepted");
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing XAesGcmKey failed");
        }
    }

    public static /* synthetic */ zzgjt zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgvo zzd2 = zzgvo.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzd2.zza() == 0) {
                return zzgjt.zzd(zzf(zzgoyVar.zzc().zzg()), zzd2.zzf().zza());
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgjo zzgjoVar, zzgfn zzgfnVar) {
        zzgvj zzb2 = zzgvl.zzb();
        byte[] zzd2 = zzgjoVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        zzgvp zzb3 = zzgvr.zzb();
        zzb3.zza(zzgjoVar.zzd().zzb());
        zzb2.zzb((zzgvr) zzb3.zzbr());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzgvl) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzgjoVar.zzd().zzc()), zzgjoVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzgjt zzgjtVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzgvm zzb2 = zzgvo.zzb();
        zzgvp zzb3 = zzgvr.zzb();
        zzb3.zza(zzgjtVar.zzb());
        zzb2.zza((zzgvr) zzb3.zzbr());
        zza2.zzc(((zzgvo) zzb2.zzbr()).zzaN());
        zza2.zza(zzg(zzgjtVar.zzc()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgjs zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzgjs.zza;
        }
        if (ordinal == 3) {
            return zzgjs.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
    }

    private static zzgvf zzg(zzgjs zzgjsVar) throws GeneralSecurityException {
        if (Objects.equals(zzgjsVar, zzgjs.zza)) {
            return zzgvf.TINK;
        }
        if (Objects.equals(zzgjsVar, zzgjs.zzb)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgjsVar.toString()));
    }
}
