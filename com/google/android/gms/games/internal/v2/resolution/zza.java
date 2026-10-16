package com.google.android.gms.games.internal.v2.resolution;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.google.android.gms.internal.games_v2.zzfr;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
final class zza extends ResultReceiver {
    private final TaskCompletionSource zza;

    public zza() {
        super(new zzfr(Looper.getMainLooper()));
        this.zza = new TaskCompletionSource();
    }

    @Override // android.os.ResultReceiver
    protected final void onReceiveResult(int i, Bundle bundle) {
        Intent intent;
        super.onReceiveResult(i, bundle);
        Boolean valueOf = Boolean.valueOf(i == -1);
        if (bundle == null) {
            intent = new Intent();
        } else {
            intent = (Intent) bundle.getParcelable("resultData");
            if (intent == null) {
                intent = new Intent();
            }
        }
        this.zza.trySetResult(valueOf.booleanValue() ? zzc.zza(intent) : zzc.zzb(intent));
    }

    public final Task zza() {
        return this.zza.getTask();
    }
}
