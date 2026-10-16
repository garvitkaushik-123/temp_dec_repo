package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.y;
import java.util.List;

/* compiled from: HttpHeaders.java */
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final com.mbridge.msdk.thrid.okio.f f4836a = com.mbridge.msdk.thrid.okio.f.c("\"\\");
    private static final com.mbridge.msdk.thrid.okio.f b = com.mbridge.msdk.thrid.okio.f.c("\t ,=");

    public static long a(y yVar) {
        return a(yVar.m());
    }

    public static boolean b(y yVar) {
        if (yVar.r().e().equals("HEAD")) {
            return false;
        }
        int k = yVar.k();
        return (((k >= 100 && k < 200) || k == 204 || k == 304) && a(yVar) == -1 && !"chunked".equalsIgnoreCase(yVar.b(HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static long a(p pVar) {
        return a(pVar.b(HttpHeaders.CONTENT_LENGTH));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(com.mbridge.msdk.thrid.okhttp.k kVar, q qVar, p pVar) {
        if (kVar == com.mbridge.msdk.thrid.okhttp.k.f4877a) {
            return;
        }
        List<com.mbridge.msdk.thrid.okhttp.j> a2 = com.mbridge.msdk.thrid.okhttp.j.a(qVar, pVar);
        if (a2.isEmpty()) {
            return;
        }
        kVar.a(qVar, a2);
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int b(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }
}
