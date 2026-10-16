package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes6.dex */
public abstract class p {
    public static o<ByteBuffer, Long> a(q qVar) throws IOException {
        if (qVar.a() < 22) {
            return null;
        }
        o<ByteBuffer, Long> a2 = a(qVar, 0);
        return a2 != null ? a2 : a(qVar, 65535);
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        for (int i2 = 0; i2 <= min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && a(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static long c(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    public static long d(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    public static int e(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return a(byteBuffer, byteBuffer.position() + 10);
    }

    private static o<ByteBuffer, Long> a(q qVar, int i) throws IOException {
        if (i >= 0 && i <= 65535) {
            long a2 = qVar.a();
            if (a2 < 22) {
                return null;
            }
            int min = ((int) Math.min(i, a2 - 22)) + 22;
            long j = a2 - min;
            ByteBuffer a3 = qVar.a(j, min);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            a3.order(byteOrder);
            int b = b(a3);
            if (b == -1) {
                return null;
            }
            a3.position(b);
            ByteBuffer slice = a3.slice();
            slice.order(byteOrder);
            return o.a(slice, Long.valueOf(j + b));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
    }

    static long b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int a(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }
}
