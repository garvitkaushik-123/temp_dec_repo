package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfzx extends zzfwr {
    final transient zzfwh zza;

    zzfzx(Map map, zzfwh zzfwhVar) {
        super(map);
        this.zza = zzfwhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr, com.google.android.gms.internal.ads.zzfxi
    protected final /* bridge */ /* synthetic */ Collection zza() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfxi, com.google.android.gms.internal.ads.zzfxl
    final Map zzj() {
        return zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzfxi, com.google.android.gms.internal.ads.zzfxl
    final Set zzl() {
        return zzm();
    }
}
