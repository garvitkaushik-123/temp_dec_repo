package com.pgl.ssdk;

import com.pgl.ssdk.c;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class g {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return h.b(byteBuffer);
    }

    public static byte[] b(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return h.c(byteBuffer);
    }

    public static i a(q qVar, c.a aVar, int i) throws IOException, a {
        try {
            return h.a(qVar, aVar, i);
        } catch (j e) {
            throw new a(e.getMessage());
        }
    }
}
