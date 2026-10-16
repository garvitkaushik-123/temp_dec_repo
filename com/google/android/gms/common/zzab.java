package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
final class zzab extends zzad {
    private final Callable zzf;

    /* synthetic */ zzab(Callable callable, zzac zzacVar) {
        super();
        this.zzf = callable;
    }

    @Override // com.google.android.gms.common.zzad
    final String zza() {
        try {
            return (String) this.zzf.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
