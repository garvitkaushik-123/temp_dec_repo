package com.instagram.common.viewpoint.core;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.facebook.ads.redexgen.X.gC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1897gC {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 106);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{42, 49, 56, 84, 72, 47, Ascii.DC4, Ascii.ESC, Ascii.CAN, Ascii.SYN, Ascii.US, 90, Ascii.SO, Ascii.NAK, 90, Ascii.FS, 19, Ascii.DC4, Ascii.RS, 90, Ascii.FF, Ascii.ESC, Ascii.SYN, 19, Ascii.RS, 90, Ascii.EM, Ascii.US, 8, Ascii.SO, 19, Ascii.FS, 19, Ascii.EM, Ascii.ESC, Ascii.SO, Ascii.US, 90, Ascii.NAK, 8, 90, 10, Ascii.SI, Ascii.CAN, Ascii.SYN, 19, Ascii.EM, 90, 17, Ascii.US, 3, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A03(@Nullable HttpsURLConnection httpsURLConnection, @Nullable Set<String> set, Set<String> set2) throws Exception {
        String A002 = A00(0, 5, 19);
        try {
            for (Certificate certificate : httpsURLConnection.getServerCertificates()) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                String A01 = A01(x509Certificate.getEncoded(), A002);
                if (set != null && set.contains(A01)) {
                    return;
                }
                String A012 = A01(x509Certificate.getPublicKey().getEncoded(), A002);
                if (set2 != null && set2.contains(A012)) {
                    return;
                }
            }
            throw new CertificateException(A00(5, 47, 16));
        } catch (Exception e) {
            throw e;
        }
    }

    public static String A01(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(str);
        digest.reset();
        return Base64.encodeToString(digest.digest(bArr), 0);
    }
}
