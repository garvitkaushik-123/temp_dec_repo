package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.u;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: StatusLine.java */
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final u f4840a;
    public final int b;
    public final String c;

    public k(u uVar, int i, String str) {
        this.f4840a = uVar;
        this.b = i;
        this.c = str;
    }

    public static k a(String str) throws IOException {
        u uVar;
        int i;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                uVar = u.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                uVar = u.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            uVar = u.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i + 4);
            }
            return new k(uVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4840a == u.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ').append(this.b);
        if (this.c != null) {
            sb.append(' ').append(this.c);
        }
        return sb.toString();
    }
}
