package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzp extends BroadcastReceiver {
    /* synthetic */ zzp(zzs zzsVar, zzr zzrVar) {
        Objects.requireNonNull(zzsVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        com.google.android.gms.ads.internal.util.client.zzl.zzi();
        zzd.zza(context);
    }
}
