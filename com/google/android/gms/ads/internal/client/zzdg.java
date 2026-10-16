package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzdg extends zzde {
    private final MuteThisAdListener zza;

    public zzdg(MuteThisAdListener muteThisAdListener) {
        this.zza = muteThisAdListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdf
    public final void zze() {
        this.zza.onAdMuted();
    }
}
