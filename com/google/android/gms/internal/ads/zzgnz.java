package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgnz {
    public static final zzgxe zza = zzgxe.zzb(new byte[0]);

    public static final zzgxe zza(int i) {
        return zzgxe.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzgxe zzb(int i) {
        return zzgxe.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
