package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@18.2.1 */
/* loaded from: classes5.dex */
final class zzk implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzl zzb;

    zzk(zzl zzlVar, Task task) {
        this.zza = task;
        this.zzb = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.zzb.zzb;
        synchronized (obj) {
            zzl zzlVar = this.zzb;
            onFailureListener = zzlVar.zzc;
            if (onFailureListener != null) {
                onFailureListener2 = zzlVar.zzc;
                onFailureListener2.onFailure((Exception) Preconditions.checkNotNull(this.zza.getException()));
            }
        }
    }
}
