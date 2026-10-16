package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfsb {
    private static zzfsb zzb;
    final zzfsc zza;

    private zzfsb(Context context) {
        this.zza = zzfsc.zzb(context);
    }

    public static final zzfsb zza(Context context) {
        zzfsb zzfsbVar;
        synchronized (zzfsb.class) {
            if (zzb == null) {
                zzb = new zzfsb(context);
            }
            zzfsbVar = zzb;
        }
        return zzfsbVar;
    }

    public final void zzb(boolean z) throws IOException {
        synchronized (zzfsb.class) {
            this.zza.zzd("paidv2_user_option", Boolean.valueOf(z));
        }
    }

    public final void zzc(boolean z) throws IOException {
        synchronized (zzfsb.class) {
            zzfsc zzfscVar = this.zza;
            zzfscVar.zzd("paidv2_publisher_option", Boolean.valueOf(z));
            if (!z) {
                zzfscVar.zze("paidv2_creation_time");
                zzfscVar.zze("paidv2_id");
                zzfscVar.zze("vendor_scoped_gpid_v2_id");
                zzfscVar.zze("vendor_scoped_gpid_v2_creation_time");
            }
        }
    }

    public final boolean zzd() {
        boolean zzf;
        synchronized (zzfsb.class) {
            zzf = this.zza.zzf("paidv2_publisher_option", true);
        }
        return zzf;
    }

    public final boolean zze() {
        boolean zzf;
        synchronized (zzfsb.class) {
            zzf = this.zza.zzf("paidv2_user_option", true);
        }
        return zzf;
    }
}
