package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbbv extends PushbackInputStream {
    final /* synthetic */ zzbbw zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbbv(zzbbw zzbbwVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        Objects.requireNonNull(zzbbwVar);
        this.zza = zzbbwVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        zzbby.zze(this.zza.zzc);
        super.close();
    }
}
