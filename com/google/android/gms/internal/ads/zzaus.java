package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaus {
    static boolean zza = false;
    public static final /* synthetic */ int zzc = 0;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    static zzaug zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector zzc2 = zzc(bArr, 255);
        if (zzc2 == null || zzc2.isEmpty()) {
            return null;
        }
        zzaug zza2 = zzauh.zza();
        int size = zzc2.size();
        for (int i = 0; i < size; i++) {
            zza2.zza(zzgxz.zzv(zzh((byte[]) zzc2.get(i), str, false), 0, 256));
        }
        byte[] zzf2 = zzf(bArr);
        zzgxz zzgxzVar = zzgxz.zzb;
        zza2.zzb(zzgxz.zzv(zzf2, 0, zzf2.length));
        return zza2;
    }

    static String zzb(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        zzaug zza2 = zza(bArr, str);
        return zzaul.zza(zza2 == null ? zzh(zzg(4096).zzaV(), str, true) : ((zzauh) zza2.zzbr()).zzaV(), true);
    }

    static Vector zzc(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i2 = length + 254;
        Vector vector = new Vector();
        for (int i3 = 0; i3 < i2 / 255; i3++) {
            int i4 = i3 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i4 > 255) {
                    length2 = i4 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i4, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    static void zze() {
        synchronized (zzf) {
            if (!zza) {
                zza = true;
                new Thread(new zzauq(null)).start();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        r1.reset();
        r1.update(r6);
        r6 = com.google.android.gms.internal.ads.zzaus.zzd.digest();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] zzf(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        MessageDigest messageDigest;
        synchronized (zze) {
            zze();
            MessageDigest messageDigest2 = null;
            try {
                if (zzb.await(2L, TimeUnit.SECONDS) && (messageDigest = zzd) != null) {
                    messageDigest2 = messageDigest;
                }
            } catch (InterruptedException unused) {
            }
            throw new NoSuchAlgorithmException("Cannot compute hash");
        }
        return digest;
        throw new NoSuchAlgorithmException("Cannot compute hash");
    }

    static zzatq zzg(int i) {
        zzast zza2 = zzatq.zza();
        zza2.zzB(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return (zzatq) zza2.zzbr();
    }

    private static byte[] zzh(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int length = bArr.length;
        int i = true != z ? 255 : 239;
        if (length > i) {
            bArr = zzg(4096).zzaV();
        }
        int i2 = i + 1;
        int length2 = bArr.length;
        byte b = (byte) length2;
        if (length2 < i) {
            byte[] bArr2 = new byte[i - length2];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i2).put(b).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i2).put(b).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(zzf(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        zzaut[] zzautVarArr = new zzavh().zzcG;
        int length3 = zzautVarArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzautVarArr[i3].zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzauj(str.getBytes("UTF-8")).zza(bArr3);
        }
        return bArr3;
    }
}
