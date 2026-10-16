package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgmb extends ThreadLocal {
    zzgmb() {
    }

    @Nullable
    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgwm.zza.zza("AES/GCM-SIV/NoPadding");
            if (zzgks.zzb(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    @Nullable
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
