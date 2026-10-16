package com.fyber.inneractive.sdk.network;

import android.util.Base64;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a1 extends s0 {
    public final String p;

    public a1(e0 e0Var, String str, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(e0Var, f0.c.a(), rVar);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public n0 a(l lVar, Map map, int i) {
        n0 n0Var = new n0();
        try {
            InputStream inputStream = lVar.c;
            List list = map != null ? (List) map.get("Content-Type") : null;
            String str = list != null ? (String) list.get(0) : null;
            ByteBuffer byteBuffer = (ByteBuffer) com.fyber.inneractive.sdk.util.f.b.f1757a.poll();
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocateDirect(16384);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] array = (byteBuffer == null || !byteBuffer.hasArray()) ? new byte[8192] : byteBuffer.array();
            while (true) {
                int read = inputStream.read(array, 0, array.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(array, 0, read);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.fyber.inneractive.sdk.util.t.b(byteArrayOutputStream);
            com.fyber.inneractive.sdk.util.f.b.f1757a.offer(byteBuffer);
            String encodeToString = Base64.encodeToString(byteArray, 0);
            if (str == null) {
                str = "image/png";
            }
            n0Var.f1331a = "data:" + str + ";base64, " + encodeToString;
            return n0Var;
        } catch (Exception unused) {
            IAlog.a("failed to fetch and encode the image.", new Object[0]);
            return n0Var;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return false;
    }
}
