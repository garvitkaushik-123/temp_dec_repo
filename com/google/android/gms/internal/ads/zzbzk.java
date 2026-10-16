package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbzk {
    final /* synthetic */ zzbzl zza;
    private long zzb;
    private long zzc;

    public zzbzk(zzbzl zzbzlVar) {
        Objects.requireNonNull(zzbzlVar);
        this.zza = zzbzlVar;
        this.zzb = -1L;
        this.zzc = -1L;
    }

    public final long zza() {
        return this.zzc;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }

    public final void zzc() {
        Clock clock;
        clock = this.zza.zza;
        this.zzc = clock.elapsedRealtime();
    }

    public final void zzd() {
        Clock clock;
        clock = this.zza.zza;
        this.zzb = clock.elapsedRealtime();
    }
}
