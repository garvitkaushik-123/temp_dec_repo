package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfsf extends zzfsd {
    private static zzfsf zzd;

    private zzfsf(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfsf zzi(Context context) {
        zzfsf zzfsfVar;
        synchronized (zzfsf.class) {
            if (zzd == null) {
                zzd = new zzfsf(context);
            }
            zzfsfVar = zzd;
        }
        return zzfsfVar;
    }

    public final zzfsa zzh(long j, boolean z) throws IOException {
        synchronized (zzfsf.class) {
            if (this.zzc.zzd()) {
                return zzb(null, null, j, z);
            }
            return new zzfsa();
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfsf.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }
}
