package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzazv implements Application.ActivityLifecycleCallbacks {
    private Activity zza;
    private Context zzb;
    private Runnable zzh;
    private long zzj;
    private final Object zzc = new Object();
    private boolean zzd = true;
    private boolean zze = false;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private boolean zzi = false;

    zzazv() {
    }

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    ((zzbak) it.next()).zzb();
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                }
            }
        }
        this.zze = true;
        if (this.zzh != null) {
            com.google.android.gms.ads.internal.util.zzs.zza.removeCallbacks(this.zzh);
        }
        zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzazu zzazuVar = new zzazu(this);
        this.zzh = zzazuVar;
        zzfrwVar.postDelayed(zzazuVar, this.zzj);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z = this.zzd;
        this.zzd = true;
        if (this.zzh != null) {
            com.google.android.gms.ads.internal.util.zzs.zza.removeCallbacks(this.zzh);
        }
        synchronized (this.zzc) {
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    ((zzbak) it.next()).zzc();
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                }
            }
            if (z) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("App is still foreground.");
            } else {
                Iterator it2 = this.zzf.iterator();
                while (it2.hasNext()) {
                    try {
                        ((zzazw) it2.next()).zza(true);
                    } catch (Exception e2) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzazw zzazwVar) {
        synchronized (this.zzc) {
            this.zzf.add(zzazwVar);
        }
    }

    public final void zzg(Application application, Context context) {
        if (this.zzi) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            zzk((Activity) context);
        }
        this.zzb = application;
        this.zzj = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbg)).longValue();
        this.zzi = true;
    }

    public final void zzh(zzazw zzazwVar) {
        synchronized (this.zzc) {
            this.zzf.remove(zzazwVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 == null) {
                return;
            }
            if (activity2.equals(activity)) {
                this.zza = null;
            }
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    if (((zzbak) it.next()).zza()) {
                        it.remove();
                    }
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                }
            }
        }
    }
}
