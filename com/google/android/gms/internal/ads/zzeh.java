package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeh {
    final /* synthetic */ zzel zza;
    private final WeakReference zzb;
    private final Executor zzc;

    public zzeh(zzel zzelVar, zzzn zzznVar, Executor executor) {
        Objects.requireNonNull(zzelVar);
        this.zza = zzelVar;
        this.zzb = new WeakReference(zzznVar);
        this.zzc = executor;
    }

    public static /* synthetic */ void zza(zzeh zzehVar) {
        zzzn zzznVar = (zzzn) zzehVar.zzb.get();
        if (zzznVar != null) {
            zzznVar.zza.zzl(zzehVar.zza.zza());
        }
    }

    public final void zzb() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeg
            @Override // java.lang.Runnable
            public final void run() {
                zzeh.zza(zzeh.this);
            }
        });
    }

    public final boolean zzc() {
        return this.zzb.get() == null;
    }
}
