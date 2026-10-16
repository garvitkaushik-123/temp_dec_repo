package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class zzbae {
    private static MessageDigest zzb;
    protected final Object zza = new Object();

    abstract byte[] zzb(String str);

    protected final MessageDigest zza() {
        synchronized (this.zza) {
            MessageDigest messageDigest = zzb;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzb = MessageDigest.getInstance(SameMD5.TAG);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzb;
        }
    }
}
