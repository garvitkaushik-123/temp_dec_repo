package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzrx extends zzco {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzo(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer zzj;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.zzb.zzd;
        if (i2 == 21) {
            zzj = zzj((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), zzj);
                position += 3;
            }
        } else if (i2 == 22) {
            zzj = zzj(i);
            while (position < limit) {
                int i3 = byteBuffer.get(position) & 255;
                int i4 = (byteBuffer.get(position + 1) & 255) << 8;
                zzo(i3 | i4 | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), zzj);
                position += 4;
            }
        } else if (i2 == 1342177280) {
            zzj = zzj((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), zzj);
                position += 3;
            }
        } else {
            if (i2 != 1610612736) {
                throw new IllegalStateException();
            }
            zzj = zzj(i);
            while (position < limit) {
                int i5 = byteBuffer.get(position + 3) & 255;
                int i6 = (byteBuffer.get(position + 2) & 255) << 8;
                zzo(i5 | i6 | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), zzj);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        zzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        int i = zzclVar.zzd;
        String str = zzex.zza;
        if (i == 21 || i == 1342177280 || i == 22 || i == 1610612736) {
            return new zzcl(zzclVar.zzb, zzclVar.zzc, 4);
        }
        if (i == 4) {
            return zzcl.zza;
        }
        throw new zzcm("Unhandled input format:", zzclVar);
    }
}
