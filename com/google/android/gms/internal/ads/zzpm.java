package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzpm extends BroadcastReceiver {
    final /* synthetic */ zzpo zza;

    /* synthetic */ zzpm(zzpo zzpoVar, zzpn zzpnVar) {
        Objects.requireNonNull(zzpoVar);
        this.zza = zzpoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zze zzeVar;
        zzpp zzppVar;
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzpo zzpoVar = this.zza;
        zzeVar = zzpoVar.zzh;
        zzppVar = zzpoVar.zzg;
        zzpoVar.zzk(zzpj.zzd(context, intent, zzeVar, zzppVar));
    }
}
