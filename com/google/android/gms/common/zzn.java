package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
final class zzn extends zzm {
    private final byte[] zza;

    zzn(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzm
    final byte[] zzf() {
        return this.zza;
    }
}
