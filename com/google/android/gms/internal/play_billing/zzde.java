package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzcj;
import com.ironsource.C3040d4;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzde extends zzcq {
    private zzcz zzd;
    private ScheduledFuture zze;

    private zzde(zzcz zzczVar) {
        this.zzd = zzczVar;
    }

    static zzcz zzs(zzcz zzczVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzde zzdeVar = new zzde(zzczVar);
        zzdb zzdbVar = new zzdb(zzdeVar);
        zzdeVar.zze = scheduledExecutorService.schedule(zzdbVar, 28500L, timeUnit);
        zzczVar.zzb(zzdbVar, zzcp.INSTANCE);
        return zzdeVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    protected final String zzd() {
        zzcz zzczVar = this.zzd;
        ScheduledFuture scheduledFuture = this.zze;
        if (zzczVar == null) {
            return null;
        }
        String str = "inputFuture=[" + zzczVar.toString() + C3040d4.i.e;
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    protected final void zzg() {
        zzcz zzczVar = this.zzd;
        if ((this.valueField instanceof zzcj.zza) & (zzczVar != null)) {
            Object obj = this.valueField;
            zzczVar.cancel((obj instanceof zzcj.zza) && ((zzcj.zza) obj).zzc);
        }
        ScheduledFuture scheduledFuture = this.zze;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzd = null;
        this.zze = null;
    }
}
