package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzevc implements zzeuc {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbzj zzg;

    zzevc(zzbzj zzbzjVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbzjVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdu)).booleanValue() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdt)).booleanValue() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ zzevd zzc(zzevc zzevcVar, AdvertisingIdClient.Info info) {
        zzfsa zzfsaVar = new zzfsa();
        if (zzevcVar.zze) {
        }
        try {
            Context context = zzevcVar.zza;
            zzfsaVar = zzfse.zzj(context).zzi((String) Objects.requireNonNull(((AdvertisingIdClient.Info) Objects.requireNonNull(info)).getId()), context.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdz)).longValue(), zzevcVar.zzf);
        } catch (IOException | IllegalArgumentException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdIdInfoSignalSource.getPaidV1");
            zzfsaVar = new zzfsa();
        }
        return new zzevd(info, null, zzfsaVar);
    }

    public static /* synthetic */ zzevd zzd(zzevc zzevcVar, Throwable th) {
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        ContentResolver contentResolver = zzevcVar.zza.getContentResolver();
        return new zzevd(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfsa());
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzgde zzw = zzgde.zzw(this.zzg.zza(this.zza, this.zzd));
        zzfve zzfveVar = new zzfve() { // from class: com.google.android.gms.internal.ads.zzeva
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzevc.zzc(zzevc.this, (AdvertisingIdClient.Info) obj);
            }
        };
        Executor executor = this.zzc;
        return (zzgde) zzgdn.zze((zzgde) zzgdn.zzo((zzgde) zzgdn.zzm(zzw, zzfveVar, executor), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzevb
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzevc.zzd(zzevc.this, (Throwable) obj);
            }
        }, executor);
    }
}
