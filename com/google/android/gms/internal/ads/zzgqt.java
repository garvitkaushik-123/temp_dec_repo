package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgqt implements zzgow {
    private static final zzgqt zza = new zzgqt();
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgqp
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgrn.zza((zzgnd) zzgezVar);
        }
    }, zzgnd.class, zzgfl.class);

    zzgqt() {
    }

    static void zzc() throws GeneralSecurityException {
        zzgnv.zza().zzd(zza);
        zzgnv.zza().zzc(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zza() {
        return zzgfl.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zzb() {
        return zzgfl.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final /* bridge */ /* synthetic */ Object zze(zzgmy zzgmyVar, zzgnh zzgnhVar, zzgor zzgorVar) throws GeneralSecurityException {
        zzgni zzgniVar;
        zzgni zzgniVar2;
        zzgxe zzc;
        zzgoj zzgojVar = new zzgoj();
        for (int i = 0; i < zzgmyVar.zza(); i++) {
            zzgfg zzb2 = ((zzgfi) zzgmyVar).zzb(i);
            if (zzb2.zzc().equals(zzgfb.zza)) {
                zzgfl zzgflVar = (zzgfl) zzgorVar.zza(zzb2);
                zzgez zzb3 = zzb2.zzb();
                if (zzb3 instanceof zzgqn) {
                    zzc = ((zzgqn) zzb3).zzd();
                } else {
                    if (!(zzb3 instanceof zzgnd)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzb3.getClass().getName() + " with parameters " + String.valueOf(zzb3.zza()));
                    }
                    zzc = ((zzgnd) zzb3).zzc();
                }
                zzgojVar.zza(zzc, new zzgqq(zzgflVar, zzb2.zza()));
            }
        }
        if (zzgnhVar.zza()) {
            zzgniVar = zzgnl.zza;
            zzgniVar2 = zzgniVar;
        } else {
            zzgnj zza2 = zzgnt.zzb().zza();
            zzgni zza3 = zza2.zza(zzgmyVar, zzgnhVar, "mac", "compute");
            zzgniVar2 = zza2.zza(zzgmyVar, zzgnhVar, "mac", "verify");
            zzgniVar = zza3;
        }
        zzgfi zzgfiVar = (zzgfi) zzgmyVar;
        return new zzgqr(new zzgqq((zzgfl) zzgorVar.zza(zzgfiVar.zzc()), zzgfiVar.zzc().zza()), zzgojVar.zzb(), zzgniVar, zzgniVar2, null);
    }
}
