package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzqt extends zzco {
    private int[] zzd;
    private int[] zze;

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int[] iArr2 = iArr;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
        while (position < limit) {
            for (int i : iArr2) {
                int zzk = (zzex.zzk(this.zzb.zzd) * i) + position;
                int i2 = this.zzb.zzd;
                if (i2 != 2) {
                    if (i2 == 3) {
                        zzj.put(byteBuffer.get(zzk));
                    } else if (i2 != 4) {
                        if (i2 != 21) {
                            if (i2 != 22) {
                                if (i2 != 268435456) {
                                    if (i2 != 1342177280) {
                                        if (i2 != 1610612736) {
                                            throw new IllegalStateException("Unexpected encoding: " + i2);
                                        }
                                    }
                                }
                            }
                            zzj.putInt(byteBuffer.getInt(zzk));
                        }
                        byte b = byteBuffer.get(byteBuffer.order() == ByteOrder.BIG_ENDIAN ? zzk : zzk + 2);
                        byte b2 = byteBuffer.get(zzk + 1);
                        if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
                            zzk += 2;
                        }
                        int i3 = ((b << Ascii.CAN) & (-16777216)) | ((b2 << Ascii.DLE) & 16711680) | ((byteBuffer.get(zzk) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
                        int i4 = i3 >> 8;
                        zzdd.zze((i4 & (-16777216)) == 0 || (i4 & (-8388608)) == -8388608, "Value out of range of 24-bit integer: ".concat(String.valueOf(Integer.toHexString(i4))));
                        zzdd.zzd(zzj.remaining() >= 3);
                        zzj.put((byte) (zzj.order() == ByteOrder.BIG_ENDIAN ? (i3 >> 24) & 255 : i4 & 255)).put((byte) ((i3 >> 16) & 255)).put((byte) (zzj.order() == ByteOrder.BIG_ENDIAN ? i4 & 255 : (i3 >> 24) & 255));
                    } else {
                        zzj.putFloat(byteBuffer.getFloat(zzk));
                    }
                }
                zzj.putShort(byteBuffer.getShort(zzk));
            }
            position += this.zzb.zze;
        }
        byteBuffer.position(limit);
        zzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzcl.zza;
        }
        int i = zzclVar.zzd;
        if (!zzex.zzK(i)) {
            throw new zzcm("Unhandled input format:", zzclVar);
        }
        int i2 = zzclVar.zzc;
        boolean z = i2 != iArr.length;
        int i3 = 0;
        while (true) {
            int length = iArr.length;
            if (i3 >= length) {
                return z ? new zzcl(zzclVar.zzb, length, i) : zzcl.zza;
            }
            int i4 = iArr[i3];
            if (i4 >= i2) {
                throw new zzcm("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", zzclVar);
            }
            z |= i4 != i3;
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    protected final void zzk() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    protected final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
