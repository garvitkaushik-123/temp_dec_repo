package com.ironsource.sdk.controller;

import com.ironsource.C3260q4;
import com.ironsource.C3283rb;
import com.ironsource.mediationsdk.logger.IronLog;
import java.security.MessageDigest;
import java.util.UUID;

/* loaded from: classes6.dex */
final class s {
    private static final String b = "MD5";

    /* renamed from: a, reason: collision with root package name */
    private String f3774a;

    s(String str) {
        this.f3774a = str;
    }

    static String a() {
        return UUID.randomUUID().toString();
    }

    private String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    private String a(String str) {
        try {
            return C3283rb.a(str);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return b(str);
        }
    }

    private String a(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    String b() {
        return this.f3774a;
    }

    boolean a(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(a(str + str2 + this.f3774a));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }
}
