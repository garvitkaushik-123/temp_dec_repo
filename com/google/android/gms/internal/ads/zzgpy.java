package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgpy implements zzgow {
    private static final zzgpy zza = new zzgpy();

    private zzgpy() {
    }

    static void zzc() throws GeneralSecurityException {
        zzgnv.zza().zzd(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zza() {
        return zzgpv.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zzb() {
        return zzgpv.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final /* bridge */ /* synthetic */ Object zze(zzgmy zzgmyVar, zzgnh zzgnhVar, zzgor zzgorVar) throws GeneralSecurityException {
        zzgxe zzc;
        zzgfi zzgfiVar = (zzgfi) zzgmyVar;
        zzgfg zzc2 = zzgfiVar.zzc();
        zzgoj zzgojVar = new zzgoj();
        for (int i = 0; i < zzgmyVar.zza(); i++) {
            zzgfg zzb = zzgfiVar.zzb(i);
            if (zzb.zzc().equals(zzgfb.zza)) {
                zzgpv zzgpvVar = (zzgpv) zzgorVar.zza(zzb);
                zzgez zzb2 = zzb.zzb();
                if (zzb2 instanceof zzgqn) {
                    zzc = ((zzgqn) zzb2).zzd();
                } else {
                    if (!(zzb2 instanceof zzgnd)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzb2.getClass().getName() + " with parameters " + String.valueOf(zzb2.zza()));
                    }
                    zzc = ((zzgnd) zzb2).zzc();
                }
                zzgojVar.zza(zzc, zzgpvVar);
            }
        }
        return new zzgpw(zzgojVar.zzb(), (zzgpv) zzgorVar.zza(zzc2), null);
    }
}
