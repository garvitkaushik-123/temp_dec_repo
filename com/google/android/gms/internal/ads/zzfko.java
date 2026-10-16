package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfko extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzfkp zza;

    zzfko(zzfkp zzfkpVar) {
        Objects.requireNonNull(zzfkpVar);
        this.zza = zzfkpVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzr(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzr(false);
    }
}
