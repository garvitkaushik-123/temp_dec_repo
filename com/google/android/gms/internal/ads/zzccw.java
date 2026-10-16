package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzccw implements zzhgd {
    private final ByteBuffer zza;

    zzccw(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzhgd
    public final int zza(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBuffer2 = this.zza;
        if (byteBuffer2.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
        byte[] bArr = new byte[min];
        byteBuffer2.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzhgd
    public final long zzb() throws IOException {
        return this.zza.position();
    }

    @Override // com.google.android.gms.internal.ads.zzhgd
    public final long zzc() throws IOException {
        return this.zza.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzhgd
    public final ByteBuffer zzd(long j, long j2) throws IOException {
        ByteBuffer byteBuffer = this.zza;
        int position = byteBuffer.position();
        byteBuffer.position((int) j);
        ByteBuffer slice = byteBuffer.slice();
        slice.limit((int) j2);
        byteBuffer.position(position);
        return slice;
    }

    @Override // com.google.android.gms.internal.ads.zzhgd
    public final void zze(long j) throws IOException {
        this.zza.position((int) j);
    }
}
