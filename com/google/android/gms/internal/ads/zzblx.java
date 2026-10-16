package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzblx extends zzblu {
    final /* synthetic */ zzcak zza;

    zzblx(zzbly zzblyVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzblyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(parcelFileDescriptor);
    }
}
