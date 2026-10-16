package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgnv {
    private static final zzgnv zza = new zzgnv();
    private final AtomicReference zzb = new AtomicReference(new zzgov(new zzgos(null), null));

    zzgnv() {
    }

    public static zzgnv zza() {
        return zza;
    }

    public final Object zzb(zzgez zzgezVar, Class cls) throws GeneralSecurityException {
        return ((zzgov) this.zzb.get()).zzb(zzgezVar, cls);
    }

    public final synchronized void zzc(zzgoq zzgoqVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgos zzgosVar = new zzgos((zzgov) atomicReference.get(), null);
        zzgosVar.zza(zzgoqVar);
        atomicReference.set(new zzgov(zzgosVar, null));
    }

    public final synchronized void zzd(zzgow zzgowVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgos zzgosVar = new zzgos((zzgov) atomicReference.get(), null);
        zzgosVar.zzb(zzgowVar);
        atomicReference.set(new zzgov(zzgosVar, null));
    }
}
