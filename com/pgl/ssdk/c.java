package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public abstract class c {

    public static class a extends t {
        public a(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
            super(j, j2, i, j3, byteBuffer);
        }
    }

    public static a a(q qVar) throws IOException, s {
        t a2 = d.a(qVar);
        return new a(a2.a(), a2.c(), a2.b(), a2.e(), a2.d());
    }
}
