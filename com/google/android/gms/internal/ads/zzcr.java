package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcr extends zzco {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea A[ADDED_TO_REGION, LOOP:6: B:42:0x00ea->B:43:0x00ec, LOOP_START, PHI: r0
      0x00ea: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:13:0x003e, B:43:0x00ec] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.zzb.zzd;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 21) {
                    if (i3 != 22) {
                        if (i3 != 268435456) {
                            if (i3 != 1342177280) {
                                if (i3 != 1610612736) {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                        ByteBuffer zzj = zzj(i2);
                        i = this.zzb.zzd;
                        if (i == 3) {
                            while (position < limit) {
                                zzj.put((byte) 0);
                                zzj.put((byte) ((byteBuffer.get(position) & 255) + RangingPosition.RSSI_UNKNOWN));
                                position++;
                            }
                        } else if (i == 4) {
                            while (position < limit) {
                                float f = byteBuffer.getFloat(position);
                                String str = zzex.zza;
                                short max = (short) (Math.max(-1.0f, Math.min(f, 1.0f)) * 32767.0f);
                                zzj.put((byte) (max & 255));
                                zzj.put((byte) ((max >> 8) & 255));
                                position += 4;
                            }
                        } else if (i == 21) {
                            while (position < limit) {
                                zzj.put(byteBuffer.get(position + 1));
                                zzj.put(byteBuffer.get(position + 2));
                                position += 3;
                            }
                        } else if (i == 22) {
                            while (position < limit) {
                                zzj.put(byteBuffer.get(position + 2));
                                zzj.put(byteBuffer.get(position + 3));
                                position += 4;
                            }
                        } else if (i == 268435456) {
                            while (position < limit) {
                                zzj.put(byteBuffer.get(position + 1));
                                zzj.put(byteBuffer.get(position));
                                position += 2;
                            }
                        } else if (i == 1342177280) {
                            while (position < limit) {
                                zzj.put(byteBuffer.get(position + 1));
                                zzj.put(byteBuffer.get(position));
                                position += 3;
                            }
                        } else {
                            if (i != 1610612736) {
                                throw new IllegalStateException();
                            }
                            while (position < limit) {
                                zzj.put(byteBuffer.get(position + 1));
                                zzj.put(byteBuffer.get(position));
                                position += 4;
                            }
                        }
                        byteBuffer.position(byteBuffer.limit());
                        zzj.flip();
                    }
                }
                i2 /= 3;
            }
            i2 /= 2;
            ByteBuffer zzj2 = zzj(i2);
            i = this.zzb.zzd;
            if (i == 3) {
            }
            byteBuffer.position(byteBuffer.limit());
            zzj2.flip();
        }
        i2 += i2;
        ByteBuffer zzj22 = zzj(i2);
        i = this.zzb.zzd;
        if (i == 3) {
        }
        byteBuffer.position(byteBuffer.limit());
        zzj22.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        int i = zzclVar.zzd;
        if (i != 3) {
            if (i == 2) {
                return zzcl.zza;
            }
            if (i != 268435456 && i != 21 && i != 1342177280 && i != 22 && i != 1610612736 && i != 4) {
                throw new zzcm("Unhandled input format:", zzclVar);
            }
        }
        return new zzcl(zzclVar.zzb, zzclVar.zzc, 2);
    }
}
