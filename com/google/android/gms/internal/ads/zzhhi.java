package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhhi extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzhhi(zzbef zzbefVar) {
        this.zza = new WeakReference(zzbefVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbef zzbefVar = (zzbef) this.zza.get();
        if (zzbefVar != null) {
            zzbefVar.zzc(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbef zzbefVar = (zzbef) this.zza.get();
        if (zzbefVar != null) {
            zzbefVar.zzd();
        }
    }
}
