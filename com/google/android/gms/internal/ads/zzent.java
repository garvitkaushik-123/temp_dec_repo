package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzent implements zzeuc {
    final zzbzs zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgdy zzd;
    private final Context zze;

    zzent(Context context, zzbzs zzbzsVar, ScheduledExecutorService scheduledExecutorService, zzgdy zzgdyVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdl)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbzsVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdh)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdm)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdi)).booleanValue()) {
                    return zzgdn.zzm(zzfsj.zza(this.zzb.getAppSetIdInfo(), null), new zzfve() { // from class: com.google.android.gms.internal.ads.zzenq
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                            return new zzenu(appSetIdInfo.getId(), appSetIdInfo.getScope());
                        }
                    }, zzcaf.zzg);
                }
                Task<AppSetIdInfo> zza = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdl)).booleanValue() ? zzfea.zza(this.zze) : this.zzb.getAppSetIdInfo();
                if (zza == null) {
                    return zzgdn.zzh(new zzenu(null, -1));
                }
                ListenableFuture zzn = zzgdn.zzn(zzfsj.zza(zza, null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzenr
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgdn.zzh(new zzenu(null, -1)) : zzgdn.zzh(new zzenu(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, zzcaf.zzg);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdj)).booleanValue()) {
                    zzn = zzgdn.zzo(zzn, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdk)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgdn.zze(zzn, Exception.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzens
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        zzent.this.zza.zzw((Exception) obj, "AppSetIdInfoSignal");
                        return new zzenu(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgdn.zzh(new zzenu(null, -1));
    }
}
