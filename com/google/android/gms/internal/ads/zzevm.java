package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzevm implements zzeuc {
    private final zzbzs zza;
    private final ScheduledExecutorService zzb;
    private final zzgdy zzc;

    zzevm(String str, zzbbf zzbbfVar, zzbzs zzbzsVar, ScheduledExecutorService scheduledExecutorService, zzgdy zzgdyVar) {
        this.zza = zzbzsVar;
        this.zzb = scheduledExecutorService;
        this.zzc = zzgdyVar;
    }

    public static /* synthetic */ zzevn zzc(zzevm zzevmVar, Exception exc) {
        zzevmVar.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzevn(null, -1);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 43;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdh)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdm)).booleanValue()) {
                ListenableFuture zza = zzfsj.zza(Tasks.forResult(null), null);
                zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzevk
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgdn.zzh(new zzevn(null, -1)) : zzgdn.zzh(new zzevn(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                };
                zzgdy zzgdyVar = this.zzc;
                ListenableFuture zzn = zzgdn.zzn(zza, zzgcuVar, zzgdyVar);
                if (((Boolean) zzber.zza.zze()).booleanValue()) {
                    zzn = zzgdn.zzo(zzn, ((Long) zzber.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgdn.zze(zzn, Exception.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzevl
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return zzevm.zzc(zzevm.this, (Exception) obj);
                    }
                }, zzgdyVar);
            }
        }
        return zzgdn.zzh(new zzevn(null, -1));
    }
}
