package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzej extends BroadcastReceiver {
    final /* synthetic */ zzel zza;

    /* synthetic */ zzej(zzel zzelVar, zzek zzekVar) {
        Objects.requireNonNull(zzelVar);
        this.zza = zzelVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, Intent intent) {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzei
            @Override // java.lang.Runnable
            public final void run() {
                zzel.zzd(zzej.this.zza, context);
            }
        });
    }
}
