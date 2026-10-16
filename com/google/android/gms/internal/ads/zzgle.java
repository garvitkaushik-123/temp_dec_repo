package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgle {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgla
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgle.zzd((zzgid) zzgfmVar);
            }
        }, zzgid.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzglb
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgle.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzglc
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgle.zzc((zzghy) zzgezVar, zzgfnVar);
            }
        }, zzghy.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgld
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgle.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzghy zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgtk zzd2 = zzgtk.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() == 0) {
                return zzghy.zzc(zzf(zzgoxVar.zzc()), zzgxf.zzb(zzd2.zzf().zzA(), zzgfnVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgid zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgtn.zzc(zzgoyVar.zzc().zzh(), zzgyr.zza());
            return zzgid.zzc(zzf(zzgoyVar.zzc().zzg()));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzghy zzghyVar, zzgfn zzgfnVar) {
        zzgti zzb2 = zzgtk.zzb();
        byte[] zzd2 = zzghyVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgtk) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzghyVar.zzd().zzb()), zzghyVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzgid zzgidVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzgtn.zzb().zzaN());
        zza2.zza(zzg(zzgidVar.zzb()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgic zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzgic.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgic.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
            }
        }
        return zzgic.zzb;
    }

    private static zzgvf zzg(zzgic zzgicVar) throws GeneralSecurityException {
        if (zzgic.zza.equals(zzgicVar)) {
            return zzgvf.TINK;
        }
        if (zzgic.zzb.equals(zzgicVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzgic.zzc.equals(zzgicVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgicVar.toString()));
    }
}
