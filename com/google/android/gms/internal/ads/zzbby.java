package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbby {
    private zzbbn zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzbby(Context context) {
        this.zzc = context;
    }

    final Future zzc(zzbbo zzbboVar) {
        zzbbs zzbbsVar = new zzbbs(this);
        zzbbw zzbbwVar = new zzbbw(this, zzbboVar, zzbbsVar);
        zzbbx zzbbxVar = new zzbbx(this, zzbbsVar);
        synchronized (this.zzd) {
            zzbbn zzbbnVar = new zzbbn(this.zzc, com.google.android.gms.ads.internal.zzv.zzv().zzb(), zzbbwVar, zzbbxVar);
            this.zza = zzbbnVar;
            zzbbnVar.checkAvailabilityAndConnect();
        }
        return zzbbsVar;
    }

    static /* bridge */ /* synthetic */ void zze(zzbby zzbbyVar) {
        synchronized (zzbbyVar.zzd) {
            zzbbn zzbbnVar = zzbbyVar.zza;
            if (zzbbnVar == null) {
                return;
            }
            zzbbnVar.disconnect();
            zzbbyVar.zza = null;
            Binder.flushPendingCommands();
        }
    }
}
