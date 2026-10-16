package com.google.android.gms.games.internal;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
public final class zzao {
    private static final zzao zza = new zzao();
    private volatile boolean zzb = false;

    zzao() {
    }

    public static zzao zza() {
        return zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final void zzc() {
        this.zzb = true;
    }
}
