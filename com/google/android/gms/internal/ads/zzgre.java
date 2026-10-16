package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgre {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzb2;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgra
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgre.zzb((zzgpu) zzgfmVar);
            }
        }, zzgpu.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgrb
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgre.zzd((zzgoy) zzgpbVar);
            }
        }, zzb2, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgrc
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgre.zza((zzgpm) zzgezVar, zzgfnVar);
            }
        }, zzgpm.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgrd
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgre.zzc((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzb2, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgpm zzgpmVar, zzgfn zzgfnVar) {
        zzgrp zzb2 = zzgrr.zzb();
        zzb2.zzb(zzg(zzgpmVar.zzc()));
        byte[] zzd2 = zzgpmVar.zze().zzd(zzgfnVar);
        zzb2.zza(zzgxz.zzv(zzd2, 0, zzd2.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgrr) zzb2.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzh(zzgpmVar.zzc().zzf()), zzgpmVar.zzf());
    }

    public static /* synthetic */ zzgoy zzb(zzgpu zzgpuVar) {
        zzgud zza2 = zzguf.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgrs zzb2 = zzgru.zzb();
        zzb2.zzb(zzg(zzgpuVar));
        zzb2.zza(zzgpuVar.zzc());
        zza2.zzc(((zzgru) zzb2.zzbr()).zzaN());
        zza2.zza(zzh(zzgpuVar.zzf()));
        return zzgoy.zzb((zzguf) zza2.zzbr());
    }

    public static /* synthetic */ zzgpm zzc(zzgox zzgoxVar, zzgfn zzgfnVar) {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzgrr zzd2 = zzgrr.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzd2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgpr zze2 = zzgpu.zze();
            zze2.zza(zzd2.zzg().zzd());
            zze2.zzb(zzd2.zzf().zza());
            zze2.zzc(zzf(zzgoxVar.zzc()));
            zzgpu zzd3 = zze2.zzd();
            zzgpk zzb2 = zzgpm.zzb();
            zzb2.zzc(zzd3);
            zzb2.zza(zzgxf.zzb(zzd2.zzg().zzA(), zzgfnVar));
            zzb2.zzb(zzgoxVar.zzf());
            return zzb2.zzd();
        } catch (zzgzw | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static /* synthetic */ zzgpu zzd(zzgoy zzgoyVar) {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgru zzd2 = zzgru.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza());
            zzgpr zze2 = zzgpu.zze();
            zze2.zza(zzd2.zza());
            zze2.zzb(zzd2.zzf().zza());
            zze2.zzc(zzf(zzgoyVar.zzc().zzg()));
            return zze2.zzd();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    public static void zze(zzgny zzgnyVar) throws GeneralSecurityException {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgps zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int ordinal = zzgvfVar.ordinal();
        if (ordinal == 1) {
            return zzgps.zza;
        }
        if (ordinal == 2) {
            return zzgps.zzc;
        }
        if (ordinal == 3) {
            return zzgps.zzd;
        }
        if (ordinal == 4) {
            return zzgps.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvfVar.zza());
    }

    private static zzgrx zzg(zzgpu zzgpuVar) {
        zzgrv zzb2 = zzgrx.zzb();
        zzb2.zza(zzgpuVar.zzb());
        return (zzgrx) zzb2.zzbr();
    }

    private static zzgvf zzh(zzgps zzgpsVar) throws GeneralSecurityException {
        if (zzgps.zza.equals(zzgpsVar)) {
            return zzgvf.TINK;
        }
        if (zzgps.zzb.equals(zzgpsVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzgps.zzd.equals(zzgpsVar)) {
            return zzgvf.RAW;
        }
        if (zzgps.zzc.equals(zzgpsVar)) {
            return zzgvf.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgpsVar))));
    }
}
