package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzde {
    private static Executor zza;

    public static synchronized Executor zza() {
        Executor executor;
        synchronized (zzde.class) {
            if (zza == null) {
                zza = zzex.zzF("ExoPlayer:BackgroundExecutor");
            }
            executor = zza;
        }
        return executor;
    }
}
