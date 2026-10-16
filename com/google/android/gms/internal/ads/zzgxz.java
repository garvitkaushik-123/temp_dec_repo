package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.slf4j.Marker;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgxz implements Iterable<Byte>, Serializable {
    public static final zzgxz zzb = new zzgxw(zzgzu.zzb);
    private int zza = 0;

    static {
        int i = zzgxm.zza;
    }

    zzgxz() {
    }

    public static zzgxx zzt() {
        return new zzgxx(128);
    }

    public static zzgxz zzu(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzb : zzc(iterable.iterator(), size);
    }

    public static zzgxz zzv(byte[] bArr, int i, int i2) {
        zzq(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzgxw(bArr2);
    }

    public static zzgxz zzw(String str) {
        return new zzgxw(str.getBytes(zzgzu.zza));
    }

    static void zzy(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzd = zzd();
            i = zzi(zzd, 0, zzd);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzhbv.zza(this) : zzhbv.zza(zzk(0, 47)).concat("..."));
    }

    public final byte[] zzA() {
        int zzd = zzd();
        if (zzd == 0) {
            return zzgzu.zzb;
        }
        byte[] bArr = new byte[zzd];
        zze(bArr, 0, 0, zzd);
        return bArr;
    }

    public abstract byte zza(int i);

    abstract byte zzb(int i);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i, int i2, int i3);

    protected abstract int zzf();

    protected abstract boolean zzh();

    protected abstract int zzi(int i, int i2, int i3);

    protected abstract int zzj(int i, int i2, int i3);

    public abstract zzgxz zzk(int i, int i2);

    public abstract zzgyf zzl();

    protected abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    abstract void zzo(zzgxq zzgxqVar) throws IOException;

    public abstract boolean zzp();

    protected final int zzr() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public zzgxu iterator() {
        return new zzgxr(this);
    }

    public final String zzx() {
        return zzd() == 0 ? "" : zzm(zzgzu.zza);
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i, int i2, int i3) {
        zzq(0, i3, zzd());
        zzq(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    private static zzgxz zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return (zzgxz) it.next();
        }
        int i2 = i >>> 1;
        zzgxz zzc = zzc(it, i2);
        zzgxz zzc2 = zzc(it, i - i2);
        if (Integer.MAX_VALUE - zzc.zzd() >= zzc2.zzd()) {
            return zzhbk.zzC(zzc, zzc2);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + zzc.zzd() + Marker.ANY_NON_NULL_MARKER + zzc2.zzd());
    }

    static int zzq(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
