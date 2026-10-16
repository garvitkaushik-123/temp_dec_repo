package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class u0 extends t0 {
    public u0(com.fyber.inneractive.sdk.ui.b bVar, Context context, com.fyber.inneractive.sdk.cache.b bVar2) {
        super(bVar, context, bVar2);
    }

    @Override // com.fyber.inneractive.sdk.network.t0, com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        n0 n0Var = new n0();
        try {
            InputStream inputStream = lVar.c;
            int a2 = s0.a(map);
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Bitmap decodeStream = BitmapFactory.decodeStream(new com.fyber.inneractive.sdk.util.t0(inputStream, atomicInteger));
            if (atomicInteger.get() != a2) {
                decodeStream = null;
            }
            if (decodeStream != null) {
                String a3 = com.fyber.inneractive.sdk.util.u0.a(decodeStream);
                n0Var.f1331a = decodeStream;
                n0Var.b = a3;
            }
            return n0Var;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            throw new m0(e);
        }
    }
}
