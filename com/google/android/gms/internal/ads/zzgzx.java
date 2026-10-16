package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgzx extends InputStream {
    private Iterator zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    zzgzx(Iterable iterable) {
        this.zza = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzc++;
        }
        this.zzd = -1;
        if (zzb()) {
            return;
        }
        this.zzb = zzgzu.zzc;
        this.zzd = 0;
        this.zze = 0;
        this.zzi = 0L;
    }

    private final void zza(int i) {
        int i2 = this.zze + i;
        this.zze = i2;
        if (i2 == this.zzb.limit()) {
            zzb();
        }
    }

    private final boolean zzb() {
        ByteBuffer byteBuffer;
        do {
            this.zzd++;
            if (!this.zza.hasNext()) {
                return false;
            }
            byteBuffer = (ByteBuffer) this.zza.next();
            this.zzb = byteBuffer;
        } while (!byteBuffer.hasRemaining());
        this.zze = this.zzb.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzhce.zze(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            int i = this.zzg[this.zze + this.zzh] & 255;
            zza(1);
            return i;
        }
        int zza = zzhce.zza(this.zze + this.zzi) & 255;
        zza(1);
        return zza;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int limit = this.zzb.limit();
        int i3 = this.zze;
        int i4 = limit - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i3 + this.zzh, bArr, i, i2);
            zza(i2);
            return i2;
        }
        int position = this.zzb.position();
        this.zzb.position(this.zze);
        this.zzb.get(bArr, i, i2);
        this.zzb.position(position);
        zza(i2);
        return i2;
    }
}
