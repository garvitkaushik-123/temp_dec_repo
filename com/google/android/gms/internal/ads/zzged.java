package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcb;
import com.ironsource.C3040d4;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzged extends zzgcb.zzf implements Runnable {
    private final Runnable zza;

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final String zza() {
        return "task=[" + this.zza.toString() + C3040d4.i.e;
    }

    public zzged(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }
}
