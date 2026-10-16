package com.google.android.gms.internal.games_v2;

import android.app.Application;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
public final class zzas {
    private static final AtomicReference zza = new AtomicReference();
    private final zzar zzb;
    private final zzaw zzc;

    zzas(Application application, zzaw zzawVar) {
        this.zzb = new zzar(this, application, null);
        this.zzc = zzawVar;
    }

    static zzas zza(Application application) {
        AtomicReference atomicReference = zza;
        zzas zzasVar = (zzas) atomicReference.get();
        if (zzasVar != null) {
            return zzasVar;
        }
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, new zzas(application, zzay.zza(application)));
        return (zzas) Preconditions.checkNotNull((zzas) atomicReference.get());
    }

    public final void zzb() {
        zzfn.zza("AutomaticGamesAuthenticator", "startWatching()");
        this.zzb.zza();
    }

    final /* synthetic */ zzaw zzc() {
        return this.zzc;
    }
}
