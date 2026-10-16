package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzhs extends zzhm {
    public zzz zza;
    public final zzhp zzb = new zzhp();
    public ByteBuffer zzc;
    public boolean zzd;
    public long zze;
    public ByteBuffer zzf;
    private final int zzg;

    static {
        zzaq.zzb("media3.decoder");
    }

    public zzhs(int i, int i2) {
        this.zzg = i;
    }

    private final ByteBuffer zzm(int i) {
        int i2 = this.zzg;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.zzc;
        throw new zzhr(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public void zzb() {
        super.zzb();
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.zzd = false;
    }

    @EnsuresNonNull({"data"})
    public final void zzj(int i) {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer == null) {
            this.zzc = zzm(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (capacity >= i2) {
            this.zzc = byteBuffer;
            return;
        }
        ByteBuffer zzm = zzm(i2);
        zzm.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            zzm.put(byteBuffer);
        }
        this.zzc = zzm;
    }

    public final void zzk() {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean zzl() {
        return zzd(1073741824);
    }
}
