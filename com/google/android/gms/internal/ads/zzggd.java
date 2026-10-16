package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzggd implements zzget {
    private final zzgom zza;

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzggc zzggcVar : this.zza.zza(bArr)) {
            try {
                byte[] zza = zzggcVar.zza.zza(bArr, bArr2);
                int i = zzggcVar.zzb;
                int length = bArr.length;
                return zza;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
