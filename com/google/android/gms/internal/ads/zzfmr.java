package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfmr extends BroadcastReceiver {
    final /* synthetic */ zzfms zza;

    zzfmr(zzfms zzfmsVar) {
        Objects.requireNonNull(zzfmsVar);
        this.zza = zzfmsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        boolean z2;
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            zzfms zzfmsVar = this.zza;
            z2 = zzfmsVar.zzd;
            zzfmsVar.zzd(true, z2);
            zzfmsVar.zzc = true;
            return;
        }
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzfms zzfmsVar2 = this.zza;
            z = zzfmsVar2.zzd;
            zzfmsVar2.zzd(false, z);
            zzfmsVar2.zzc = false;
        }
    }
}
