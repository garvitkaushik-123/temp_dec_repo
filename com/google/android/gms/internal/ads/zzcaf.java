package com.google.android.gms.internal.ads;

import androidx.webkit.Profile;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcaf {
    public static final zzgdy zza;
    public static final zzgdy zzb;
    public static final zzgdy zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzgdz zze;
    public static final zzgdy zzf;
    public static final zzgdy zzg;

    static {
        ExecutorService threadPoolExecutor;
        ExecutorService executorService;
        ExecutorService executorService2;
        if (ClientLibraryUtils.isPackageSide()) {
            zzfrv.zza();
            threadPoolExecutor = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzcab(Profile.DEFAULT_PROFILE_NAME)));
        } else {
            if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlJ) != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlJ)).booleanValue()) {
                    if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlK) != null) {
                        if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlL) != null) {
                            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlK)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlK)).intValue(), 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcab(Profile.DEFAULT_PROFILE_NAME));
                            threadPoolExecutor2.allowCoreThreadTimeOut(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbde.zzlL)).booleanValue());
                            threadPoolExecutor = threadPoolExecutor2;
                        }
                    }
                }
            }
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcab(Profile.DEFAULT_PROFILE_NAME));
        }
        zzcae zzcaeVar = null;
        zza = new zzcad(threadPoolExecutor, zzcaeVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executorService = zzfrv.zza().zzc(5, new zzcab("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcab("Loader"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executorService = threadPoolExecutor3;
        }
        zzb = new zzcad(executorService, zzcaeVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executorService2 = zzfrv.zza().zzb(new zzcab("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcab("Activeview"));
            threadPoolExecutor4.allowCoreThreadTimeOut(true);
            executorService2 = threadPoolExecutor4;
        }
        zzc = new zzcad(executorService2, zzcaeVar);
        zzcaa zzcaaVar = new zzcaa(3, new zzcab("Schedule"));
        zzd = zzcaaVar;
        zze = zzgef.zzb(zzcaaVar);
        zzf = new zzcad(new zzcac(), zzcaeVar);
        zzg = new zzcad(zzgef.zzc(), zzcaeVar);
    }
}
