package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.ignite.IgniteResponseOuterClass$IgniteResponse;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class y0 extends s0 {
    public final byte[] p;
    public final AtomicInteger q;

    public y0(com.fyber.inneractive.sdk.ignite.b bVar, byte[] bArr, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(bVar, f0.c.a(), rVar);
        this.q = new AtomicInteger();
        this.p = bArr;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        try {
            n0 n0Var = new n0();
            InputStream inputStream = lVar.c;
            if (inputStream != null) {
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
                String str = new String(byteArray, "UTF-8");
                IgniteResponseOuterClass$IgniteResponse parseFrom = IgniteResponseOuterClass$IgniteResponse.parseFrom(str.getBytes());
                n0Var.b = str;
                n0Var.f1331a = parseFrom;
            }
            return n0Var;
        } catch (Exception e) {
            IAlog.a("failed parse ignite network request", e, new Object[0]);
            throw new m0(e);
        } catch (Throwable th) {
            IAlog.a("failed parse ignite network request", th, new Object[0]);
            throw new m0("failed to parse ignite network request");
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final byte[] d() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return ((int) Math.pow(2.0d, this.q.get())) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String l() {
        return "application/x-protobuf; messageType=IgniteRequest";
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return "https://init-mp.fyber.com/init";
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return this.q.getAndIncrement() < 4;
    }
}
