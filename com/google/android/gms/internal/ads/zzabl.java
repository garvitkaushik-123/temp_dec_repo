package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzabl implements zzca {
    private final zzby zza = new zzabk(false);

    public zzabl(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzca
    public final zzcc zza(Context context, zzk zzkVar, zzn zznVar, zzcb zzcbVar, Executor executor, zzbv zzbvVar, List list, long j, boolean z) {
        try {
            return ((zzca) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(zzby.class).newInstance(this.zza)).zza(context, zzkVar, zznVar, zzcbVar, executor, zzbvVar, list, 0L, false);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
