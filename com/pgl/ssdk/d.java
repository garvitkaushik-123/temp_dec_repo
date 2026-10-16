package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public class d {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f6387a;
        private final q b;

        public a(long j, q qVar) {
            this.f6387a = j;
            this.b = qVar;
        }

        public q a() {
            return this.b;
        }

        public long b() {
            return this.f6387a;
        }
    }

    public static t a(q qVar) throws IOException, s {
        o<ByteBuffer, Long> a2 = p.a(qVar);
        if (a2 == null) {
            throw new s("ZIP End of Central Directory record not found");
        }
        ByteBuffer a3 = a2.a();
        long longValue = a2.b().longValue();
        a3.order(ByteOrder.LITTLE_ENDIAN);
        long c = p.c(a3);
        if (c > longValue) {
            throw new s("ZIP Central Directory start offset out of range: " + c + ". ZIP End of Central Directory offset: " + longValue);
        }
        long d = p.d(a3);
        long j = c + d;
        if (j <= longValue) {
            return new t(c, d, p.e(a3), longValue, a3);
        }
        throw new s("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + longValue);
    }

    public static a a(q qVar, t tVar) throws IOException, b {
        long a2 = tVar.a();
        long c = tVar.c() + a2;
        long e = tVar.e();
        if (c != e) {
            throw new b("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + c + ", EoCD start: " + e);
        }
        if (a2 >= 32) {
            ByteBuffer a3 = qVar.a(a2 - 24, 24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            a3.order(byteOrder);
            if (a3.getLong(8) == 2334950737559900225L && a3.getLong(16) == 3617552046287187010L) {
                long j = a3.getLong(0);
                if (j < a3.capacity() || j > 2147483639) {
                    throw new b("APK Signing Block size out of range: ".concat(String.valueOf(j)));
                }
                long j2 = (int) (8 + j);
                long j3 = a2 - j2;
                if (j3 >= 0) {
                    ByteBuffer a4 = qVar.a(j3, 8);
                    a4.order(byteOrder);
                    long j4 = a4.getLong(0);
                    if (j4 == j) {
                        return new a(j3, qVar.a(j3, j2));
                    }
                    throw new b("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
                }
                throw new b("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
            }
            throw new b("No APK Signing Block before ZIP Central Directory");
        }
        throw new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a2)));
    }
}
