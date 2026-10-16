package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgky extends ThreadLocal {
    zzgky() {
    }

    @Nullable
    protected static final Cipher zza() {
        boolean zzf;
        try {
            Cipher cipher = (Cipher) zzgwm.zza.zza("ChaCha20-Poly1305");
            zzf = zzgkz.zzf(cipher);
            if (zzf) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Override // java.lang.ThreadLocal
    @Nullable
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
