package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaru extends zzhfy {
    public zzaru(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhfy
    public final void zze(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
