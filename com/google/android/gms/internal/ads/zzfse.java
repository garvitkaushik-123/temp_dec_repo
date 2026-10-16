package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfse extends zzfsd {
    private static zzfse zzd;

    private zzfse(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfse zzj(Context context) {
        zzfse zzfseVar;
        synchronized (zzfse.class) {
            if (zzd == null) {
                zzd = new zzfse(context);
            }
            zzfseVar = zzd;
        }
        return zzfseVar;
    }

    public final zzfsa zzh(long j, boolean z) throws IOException {
        zzfsa zzb;
        synchronized (zzfse.class) {
            zzb = zzb(null, null, j, z);
        }
        return zzb;
    }

    public final zzfsa zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfsa zzb;
        synchronized (zzfse.class) {
            zzb = zzb(str, str2, j, z);
        }
        return zzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfse.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfse.class) {
            zzf(true);
        }
    }
}
