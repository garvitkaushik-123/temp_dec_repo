package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgli extends zzglj {
    public zzgli(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzglj
    final zzglh zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzglg(bArr, i);
    }
}
