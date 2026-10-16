package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdxt implements zzdyw {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdwu zzb;
    private final zzgdy zzc;
    private final zzfcw zzd;
    private final ScheduledExecutorService zze;
    private final zzeaw zzf;
    private final zzfhu zzg;
    private final Context zzh;

    zzdxt(Context context, zzfcw zzfcwVar, zzdwu zzdwuVar, zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzeaw zzeawVar, zzfhu zzfhuVar) {
        this.zzh = context;
        this.zzd = zzfcwVar;
        this.zzb = zzdwuVar;
        this.zzc = zzgdyVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzeawVar;
        this.zzg = zzfhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyw
    public final ListenableFuture zzc(zzbvq zzbvqVar) {
        Context context = this.zzh;
        ListenableFuture zzc = this.zzb.zzc(zzbvqVar);
        zzfhj zza2 = zzfhi.zza(context, 11);
        zzfht.zzd(zzc, zza2);
        ListenableFuture zzn = zzgdn.zzn(zzc, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxq
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                ListenableFuture zzh;
                zzh = zzgdn.zzh(new zzfcn(new zzfck(zzdxt.this.zzd), zzfcm.zza(new InputStreamReader(r2.zzb()), ((zzdyy) obj).zza().zzm)));
                return zzh;
            }
        }, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfR)).booleanValue()) {
            zzn = zzgdn.zzf(zzgdn.zzo(zzn, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxr
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzgdn.zzg(new zzdwm(5));
                }
            }, zzcaf.zzg);
        }
        zzfht.zza(zzn, this.zzg, zza2);
        zzgdn.zzr(zzn, new zzdxs(this), zzcaf.zzg);
        return zzn;
    }
}
