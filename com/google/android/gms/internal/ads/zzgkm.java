package com.google.android.gms.internal.ads;

import android.os.Build;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgkm {
    private static final ThreadLocal zza = new zzgkl();

    public static AlgorithmParameterSpec zza(byte[] bArr, int i, int i2) {
        int i3 = zzgpj.zza;
        Integer valueOf = !Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT);
        if (valueOf != null) {
            valueOf.intValue();
        }
        return new GCMParameterSpec(128, bArr, i, 12);
    }

    public static Cipher zzb() {
        return (Cipher) zza.get();
    }

    public static SecretKey zzc(byte[] bArr) throws GeneralSecurityException {
        zzgxc.zza(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }
}
