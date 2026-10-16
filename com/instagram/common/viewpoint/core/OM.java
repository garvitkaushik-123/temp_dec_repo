package com.instagram.common.viewpoint.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import com.facebook.ads.internal.util.common.FbValidationUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class OM {
    public static byte[] A00;
    public static String[] A01 = {"NpBoDzCQyjOF8OFx9MsnsgXANanqzzj6", "RSaml0mwJ5MGBXbUX4Y7eJ496TcnwqpH", "O6M6", "HC1y", "xJAb", "6P21Vz3Cvscq5f42i51asuNZrA3r2siu", "D2rYJRkohSsxhH", "5Vn2BbDuwzZpkNg8pcGLkugAGTBH17kk"};
    public static final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Base64.padSymbol, 32, 32, 32, 48, 48, 48, 48, 48, 48, 48, 48, 48, 33, 33, 33, 33, 33, 33, 33, 33, 49, 49, 49, 44, 78, 101, 98, 104, 101, 98, 107, 44, 120, 99, 44, Byte.MAX_VALUE, 105, 126, 122, 101, 111, 105, 44, Byte.MAX_VALUE, 121, 111, 111, 105, Byte.MAX_VALUE, Byte.MAX_VALUE, 44, 49, 44, 44, 85, 66, 89, 83, 91, 82, 72, 82, 79, 67, 69, 86, 68, 72, 92, 82, 78, 73, 78, 72, 69, 73, 95, 72, 76, 83, 89, 95, 69, 95, 66, 78, 72, 91, 73, Ascii.DC2, Ascii.NAK, 19, Ascii.RS, Ascii.DC2, 4, 19, Ascii.ETB, 8, 2, 4, Ascii.RS, Ascii.DC2, 5, 10, Ascii.RS, Ascii.ETB, 4, 19, Ascii.DC2, 8, Ascii.SO, Ascii.SI, 77, 65, 67, 0, 72, 79, 77, 75, 76, 65, 65, 69, 0, 79, 74, 93, 0, 71, SignedBytes.MAX_POWER_OF_TWO, 90, 75, 92, SignedBytes.MAX_POWER_OF_TWO, 79, 66, 0, 71, 94, 77, 0, 111, 91, 74, 71, 75, SignedBytes.MAX_POWER_OF_TWO, 77, 75, 96, 75, 90, 89, 65, 92, 69, 124, 75, 67, 65, 90, 75, 125, 75, 92, 88, 71, 77, 75, Ascii.US, 19, 17, 82, Ascii.SUB, Ascii.GS, Ascii.US, Ascii.EM, Ascii.RS, 19, 19, Ascii.ETB, 82, Ascii.ETB, Ascii.GS, 8, Ascii.GS, Ascii.DC2, Ascii.GS};
    }

    static {
        A01();
        A02 = OM.class.getSimpleName();
    }

    public static void A02(C1925ge c1925ge, Message message) {
        Bundle bundle = message.getData().getBundle(A00(55, 17, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
        if (bundle != null) {
            U5.A06(c1925ge, bundle.getString(A00(90, 23, 32)), bundle.getString(A00(72, 18, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE)));
        }
    }

    public static boolean A03(Context context, String str) {
        PackageManager packageManager;
        if (!A00(171, 19, 29).equals(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            boolean validationPassed = FbValidationUtils.isFbSigningCertificateValid(FbValidationUtils.getSigningCertificate(packageManager.getPackageInfo(str, 64)));
            return validationPassed;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (r0 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A04(C1925ge c1925ge, boolean z, ServiceConnection serviceConnection) {
        boolean forceBypassValidation;
        boolean forceBypassValidation2;
        boolean forceBypassValidation3;
        boolean z2 = false;
        if (c1925ge.A05().AAO()) {
            if (!z) {
                boolean A1d = C1379Up.A1d(c1925ge);
                if (A01[1].charAt(26) == '5') {
                    throw new RuntimeException();
                }
                A01[7] = "wVoKdL5DefY3vFtz3wgH19EGFsYG1twM";
            }
            forceBypassValidation = true;
            if (!forceBypassValidation) {
                boolean forceBypassValidation4 = A03(c1925ge, AbstractC1382Us.A05(z));
                if (!forceBypassValidation4) {
                    forceBypassValidation2 = false;
                    if (!forceBypassValidation2) {
                        return false;
                    }
                    Intent intent = new Intent();
                    if (!z) {
                        boolean forceBypassValidation5 = c1925ge.A05().AAO();
                        if (forceBypassValidation5) {
                            boolean forceBypassValidation6 = C1379Up.A1d(c1925ge);
                        }
                        boolean bindService = c1925ge.bindService(intent.setComponent(new ComponentName(AbstractC1382Us.A05(z2), A00(113, 58, 79))), serviceConnection, 1);
                        forceBypassValidation3 = c1925ge.A05().AAO();
                        if (forceBypassValidation3) {
                            String str = A00(13, 42, 109) + bindService + A00(0, 13, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
                        }
                        return bindService;
                    }
                    z2 = true;
                    boolean bindService2 = c1925ge.bindService(intent.setComponent(new ComponentName(AbstractC1382Us.A05(z2), A00(113, 58, 79))), serviceConnection, 1);
                    forceBypassValidation3 = c1925ge.A05().AAO();
                    if (forceBypassValidation3) {
                    }
                    return bindService2;
                }
            }
            forceBypassValidation2 = true;
            if (!forceBypassValidation2) {
            }
        }
        forceBypassValidation = false;
        if (!forceBypassValidation) {
        }
        forceBypassValidation2 = true;
        if (!forceBypassValidation2) {
        }
    }
}
