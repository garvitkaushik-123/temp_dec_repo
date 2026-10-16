package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class XU {
    public static byte[] A00;
    public static String[] A01 = {"5C7rQEQBWVsJnjqAAZN8QBBHoCwRHOvI", "Z88WY3x8uhcakMWroAcOyZwbMrMcyrD2", "GaS", "RG8mqKBY9oxpM4ff8ZCXkeRJBSL2fzwW", "fRGWN", "iBM9tWQPO6zus77B3DN", "tCaEdKrWlrqf6UeRmfN", "xklax2dJWvUCBWRx1N6eQvQBJ1IZxl6t"};

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 62);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-73, -5, 1, -5, -4, -19, -11, -73, -23, -8, -8, -73, -37, -3, -8, -19, -6, -3, -5, -19, -6, -74, -23, -8, -13, -99, -121, -1, -16, 3, -9, Ascii.CR, 2, -5, -21, -77, -119, -112, -117, -108, 1, -1, 8, -1, Ascii.FF, 3, -3, -1, 1, 42, Ascii.ESC, 41, 42, -29, 33, Ascii.ESC, 47, 41};
    }

    static {
        A05();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:11:0x0021, B:14:0x0024), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:11:0x0021, B:14:0x0024), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static XT A00(T8 t8) {
        boolean isRooted;
        try {
            if (!A07() && !A06() && !A08(A01(47, 2, 78))) {
                isRooted = false;
                return !isRooted ? XT.A03 : XT.A05;
            }
            isRooted = true;
            if (!isRooted) {
            }
        } catch (Throwable t) {
            t8.A08().ABC(A01(40, 7, 92), AbstractC1341Td.A1M, new C1342Te(t));
            return XT.A04;
        }
    }

    public static String A02(Context context, String str) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, CertificateException {
        StringBuilder sb = new StringBuilder();
        PackageManager pm = context.getPackageManager();
        if (pm == null) {
            return A01(0, 0, 69);
        }
        Signature[] signatureArr = pm.getPackageInfo(str, 64).signatures;
        if (A01[7].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "ikpGaBwLfx1blWCv8PE";
        strArr[5] = "NCTJdZrpEYM5ZpFC5qB";
        for (Signature signature : signatureArr) {
            sb.append(C1437Xa.A04(MessageDigest.getInstance(A01(31, 4, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE)).digest(A04(signature).getEncoded())));
            sb.append(A01(26, 1, 14));
        }
        return sb.toString();
    }

    public static String A03(T8 t8, String str) {
        try {
            return A02(t8, str);
        } catch (Exception e) {
            t8.A08().ABC(A01(40, 7, 92), AbstractC1341Td.A1M, new C1342Te(e));
            return null;
        }
    }

    public static PublicKey A04(Signature signature) throws CertificateException {
        return CertificateFactory.getInstance(A01(35, 5, 29)).generateCertificate(new ByteArrayInputStream(signature.toByteArray())).getPublicKey();
    }

    public static boolean A06() {
        String str = Build.TAGS;
        if (str != null) {
            String buildTags = A01(49, 9, 120);
            if (str.contains(buildTags)) {
                return true;
            }
        }
        return false;
    }

    public static boolean A07() {
        File superUserApk = new File(A01(0, 25, 74));
        return superUserApk.exists();
    }

    public static boolean A08(String str) {
        for (String str2 : System.getenv(A01(27, 4, 113)).split(A01(25, 1, 37))) {
            File file = new File(str2);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                String[] strArr = A01;
                if (strArr[1].charAt(17) != strArr[3].charAt(17)) {
                    String[] strArr2 = A01;
                    strArr2[6] = "JMsPqsjcaxLCD34xTC2";
                    strArr2[5] = "FbRxT8DL2tHORlKIcuM";
                    if (listFiles == null) {
                        continue;
                    } else {
                        for (File file2 : listFiles) {
                            boolean equals = file2.getName().equals(str);
                            if (A01[7].length() != 32) {
                                throw new RuntimeException();
                            }
                            String[] strArr3 = A01;
                            strArr3[1] = "YF7GaC3noAI93Jw6Jae3mccsHUmdiEJo";
                            strArr3[3] = "xQd2jFuSOpS96vzWuZJNzWBfXSKKA4my";
                            if (equals) {
                                return true;
                            }
                        }
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return false;
    }
}
