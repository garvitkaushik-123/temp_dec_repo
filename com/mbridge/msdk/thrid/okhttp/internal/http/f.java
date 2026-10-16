package com.mbridge.msdk.thrid.okhttp.internal.http;

/* compiled from: HttpMethod.java */
/* loaded from: classes6.dex */
public final class f {
    public static boolean a(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean b(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean c(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
