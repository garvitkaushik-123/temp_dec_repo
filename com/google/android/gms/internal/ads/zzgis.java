package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgis {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgio
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgis.zzd((zzgin) zzgfmVar);
            }
        }, zzgin.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgip
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgis.zzb((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgiq
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgis.zzc((zzgil) zzgezVar, zzgfnVar);
            }
        }, zzgil.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgir
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgis.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzgil zza(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzguv zzd2 = zzguv.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() == 0) {
                return zzgil.zzc(zzgin.zzc(zzd2.zzf().zzf(), zzf(zzgoxVar.zzc())), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zzd2));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzgin zzb(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            return zzgin.zzc(zzguy.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza()).zzf(), zzf(zzgoyVar.zzc().zzg()));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgil zzgilVar, zzgfn zzgfnVar) {
        zzgut zzb2 = zzguv.zzb();
        zzguw zza2 = zzguy.zza();
        zza2.zza(zzgilVar.zzd().zzd());
        zzb2.zza((zzguy) zza2.zzbr());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzguv) zzb2.zzbr()).zzaN(), zzgtz.REMOTE, zzg(zzgilVar.zzd().zzb()), zzgilVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgin zzginVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzguw zza3 = zzguy.zza();
        zza3.zza(zzginVar.zzd());
        zza2.zzc(((zzguy) zza3.zzbr()).zzaN());
        zza2.zza(zzg(zzginVar.zzb()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgim zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzgim.zza;
        }
        if (ordinal == 3) {
            return zzgim.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
    }

    private static zzgvf zzg(zzgim zzgimVar) throws GeneralSecurityException {
        if (zzgim.zza.equals(zzgimVar)) {
            return zzgvf.TINK;
        }
        if (zzgim.zzb.equals(zzgimVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgimVar.toString()));
    }
}
