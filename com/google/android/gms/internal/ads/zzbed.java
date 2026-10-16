package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbed extends CustomTabsServiceConnection {
    public static final /* synthetic */ int zza = 0;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private Context zzc;
    private zzdsj zzd;
    private CustomTabsSession zze;
    private CustomTabsClient zzf;

    public static /* synthetic */ void zzb(zzbed zzbedVar, int i) {
        zzdsj zzdsjVar = zzbedVar.zzd;
        if (zzdsjVar != null) {
            zzdsi zza2 = zzdsjVar.zza();
            zza2.zzb("action", "cct_nav");
            zza2.zzb("cct_navs", String.valueOf(i));
            zza2.zzj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(Context context) {
        String packageName;
        if (this.zzf != null || context == null || (packageName = CustomTabsClient.getPackageName(context, null)) == null || packageName.equals(context.getPackageName())) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(context, packageName, this);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        this.zzf = customTabsClient;
        customTabsClient.warmup(0L);
        this.zze = customTabsClient.newSession(new zzbec(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzf = null;
        this.zze = null;
    }

    public final CustomTabsSession zza() {
        if (this.zze == null) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbeb
                @Override // java.lang.Runnable
                public final void run() {
                    r0.zzf(zzbed.this.zzc);
                }
            });
        }
        return this.zze;
    }

    public final void zzd(Context context, zzdsj zzdsjVar) {
        if (this.zzb.getAndSet(true)) {
            return;
        }
        this.zzc = context;
        this.zzd = zzdsjVar;
        zzf(context);
    }

    public final void zze(final int i) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeS)).booleanValue() || this.zzd == null) {
            return;
        }
        zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbea
            @Override // java.lang.Runnable
            public final void run() {
                zzbed.zzb(zzbed.this, i);
            }
        });
    }
}
