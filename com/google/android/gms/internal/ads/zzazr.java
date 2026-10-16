package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzazr extends com.google.android.gms.ads.internal.client.zzcn {
    private final AppEventListener zza;

    public zzazr(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final AppEventListener zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzc(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}
