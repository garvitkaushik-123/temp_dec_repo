package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzazj implements zzazp {
    final /* synthetic */ Activity zza;

    zzazj(zzazq zzazqVar, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(zzazqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}
