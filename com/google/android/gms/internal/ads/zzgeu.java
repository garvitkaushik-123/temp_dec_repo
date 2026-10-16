package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgeu {
    private final InputStream zza;

    private zzgeu(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgeu zzb(byte[] bArr) {
        return new zzgeu(new ByteArrayInputStream(bArr));
    }

    public final zzgun zza() throws IOException {
        try {
            return zzgun.zzg(this.zza, zzgyr.zza());
        } finally {
            this.zza.close();
        }
    }
}
