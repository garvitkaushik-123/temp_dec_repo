package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzegl {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcrd zzc;
    private final zzehb zzd;
    private final zzfju zze;
    private final zzgeh zzf = zzgeh.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzegm zzh;
    private zzfcn zzi;

    zzegl(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrd zzcrdVar, zzehb zzehbVar, zzfju zzfjuVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcrdVar;
        this.zzd = zzehbVar;
        this.zze = zzfjuVar;
    }

    private final synchronized ListenableFuture zzd(zzfca zzfcaVar) {
        Iterator it = zzfcaVar.zza.iterator();
        while (it.hasNext()) {
            zzedm zza = this.zzc.zza(zzfcaVar.zzb, (String) it.next());
            if (zza != null && zza.zzb(this.zzi, zzfcaVar)) {
                return zzgdn.zzo(zza.zza(this.zzi, zzfcaVar), zzfcaVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgdn.zzg(new zzdwm(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzfca zzfcaVar) {
        ListenableFuture zzd = zzd(zzfcaVar);
        this.zzd.zzf(this.zzi, zzfcaVar, zzd, this.zze);
        zzgdn.zzr(zzd, new zzegk(this, zzfcaVar), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfcn zzfcnVar) {
        if (!this.zzg.getAndSet(true)) {
            List list = zzfcnVar.zzb.zza;
            if (list.isEmpty()) {
                this.zzf.zzd(new zzehf(3, zzehi.zzc(zzfcnVar)));
            } else {
                this.zzi = zzfcnVar;
                zzehb zzehbVar = this.zzd;
                this.zzh = new zzegm(zzfcnVar, zzehbVar, this.zzf);
                zzehbVar.zzk(list);
                zzfca zza = this.zzh.zza();
                while (zza != null) {
                    zze(zza);
                    zza = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }
}
