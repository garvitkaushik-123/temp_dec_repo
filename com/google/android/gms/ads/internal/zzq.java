package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzavt;
import com.google.android.gms.internal.ads.zzavu;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzq implements Callable {
    final /* synthetic */ zzu zza;

    zzq(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        VersionInfoParcel versionInfoParcel;
        Context context;
        zzu zzuVar = this.zza;
        versionInfoParcel = zzuVar.zza;
        String str = versionInfoParcel.afmaVersion;
        context = zzuVar.zzd;
        int i = zzavt.zzw;
        return new zzavu(zzavt.zzt(context, new zzavr(str, false)));
    }
}
