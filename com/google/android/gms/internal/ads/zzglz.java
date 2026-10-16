package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzglz {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzglv
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzglz.zzd((zzgka) zzgfmVar);
            }
        }, zzgka.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzglw
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzglz.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzglx
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzglz.zzc((zzgju) zzgezVar, zzgfnVar);
            }
        }, zzgju.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgly
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzglz.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzgju zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgvu zzd2 = zzgvu.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() == 0) {
                return zzgju.zzc(zzf(zzgoxVar.zzc()), zzgxf.zzb(zzd2.zzf().zzA(), zzgfnVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgka zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            if (zzgvx.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza()).zza() == 0) {
                return zzgka.zzc(zzf(zzgoyVar.zzc().zzg()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgju zzgjuVar, zzgfn zzgfnVar) {
        zzgvs zzb2 = zzgvu.zzb();
        byte[] zzd2 = zzgjuVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgvu) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzgjuVar.zzd().zzb()), zzgjuVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzgka zzgkaVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzgvx.zzc().zzaN());
        zza2.zza(zzg(zzgkaVar.zzb()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgjz zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzgjz.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgjz.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
            }
        }
        return zzgjz.zzb;
    }

    private static zzgvf zzg(zzgjz zzgjzVar) throws GeneralSecurityException {
        if (zzgjz.zza.equals(zzgjzVar)) {
            return zzgvf.TINK;
        }
        if (zzgjz.zzb.equals(zzgjzVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzgjz.zzc.equals(zzgjzVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgjzVar.toString()));
    }
}
