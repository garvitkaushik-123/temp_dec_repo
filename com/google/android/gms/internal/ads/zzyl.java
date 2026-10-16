package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzyl implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzyu zza;

    zzyl(zzym zzymVar, zzyu zzyuVar) {
        this.zza = zzyuVar;
        Objects.requireNonNull(zzymVar);
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }
}
