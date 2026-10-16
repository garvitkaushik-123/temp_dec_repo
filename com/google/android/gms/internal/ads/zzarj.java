package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzarj implements zzaqy {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzarj(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
