package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfle {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ScheduledExecutorService zzc;
    private final ClientApi zzd = new ClientApi();
    private zzbpq zze;
    private final Clock zzf;

    zzfle(Context context, VersionInfoParcel versionInfoParcel, ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = scheduledExecutorService;
        this.zzf = clock;
    }

    private static zzfkg zzd() {
        return new zzfkg(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzB)).longValue(), 2.0d, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzC)).longValue(), 0.2d);
    }

    public final zzfld zza(com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
        if (adFormat == null) {
            return null;
        }
        int ordinal = adFormat.ordinal();
        if (ordinal == 1) {
            return new zzfki(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzceVar, this.zzc, zzd(), this.zzf);
        }
        if (ordinal == 2) {
            return new zzflh(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzceVar, this.zzc, zzd(), this.zzf);
        }
        if (ordinal != 5) {
            return null;
        }
        return new zzfkf(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzceVar, this.zzc, zzd(), this.zzf);
    }

    public final zzfld zzb(String str, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar) {
        AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
        if (adFormat == null) {
            return null;
        }
        int ordinal = adFormat.ordinal();
        if (ordinal == 1) {
            return new zzfki(str, this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzchVar, this.zzc, zzd(), this.zzf);
        }
        if (ordinal == 2) {
            return new zzflh(str, this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzchVar, this.zzc, zzd(), this.zzf);
        }
        if (ordinal != 5) {
            return null;
        }
        return new zzfkf(str, this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzchVar, this.zzc, zzd(), this.zzf);
    }

    public final void zzc(zzbpq zzbpqVar) {
        this.zze = zzbpqVar;
    }
}
