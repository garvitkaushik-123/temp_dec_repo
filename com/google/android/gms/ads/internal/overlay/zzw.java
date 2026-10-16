package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzw extends zzm {
    public zzw(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzm, com.google.android.gms.internal.ads.zzbtq
    public final void zzl(Bundle bundle) {
        com.google.android.gms.ads.internal.util.zze.zza("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzn = 4;
        this.zzb.finish();
    }
}
