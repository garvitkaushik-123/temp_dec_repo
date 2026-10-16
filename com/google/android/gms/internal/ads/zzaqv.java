package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaqv implements zzaqy {
    final /* synthetic */ File zza;

    zzaqv(zzaqz zzaqzVar, File file) {
        this.zza = file;
        Objects.requireNonNull(zzaqzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final File zza() {
        return this.zza;
    }
}
