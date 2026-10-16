package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbec extends CustomTabsCallback {
    final /* synthetic */ zzbed zza;

    zzbec(zzbed zzbedVar) {
        Objects.requireNonNull(zzbedVar);
        this.zza = zzbedVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        this.zza.zze(i);
    }
}
