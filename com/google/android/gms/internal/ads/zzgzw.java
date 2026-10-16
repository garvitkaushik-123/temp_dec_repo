package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public class zzgzw extends IOException {
    private boolean zza;

    public zzgzw(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    final void zza() {
        this.zza = true;
    }

    final boolean zzb() {
        return this.zza;
    }

    public zzgzw(String str) {
        super(str);
    }
}
