package com.fyber.inneractive.sdk.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class c1 extends s0 {
    public final String p;

    public c1(com.fyber.inneractive.sdk.flow.endcard.loaders.companion.d dVar, String str, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(dVar, f0.c.a(), rVar);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        n0 n0Var = new n0();
        b1 b1Var = new b1();
        try {
            InputStream inputStream = lVar.c;
            if (inputStream != null) {
                int a2 = s0.a(map);
                AtomicInteger atomicInteger = new AtomicInteger(0);
                Bitmap decodeStream = BitmapFactory.decodeStream(new com.fyber.inneractive.sdk.util.t0(inputStream, atomicInteger));
                if (atomicInteger.get() != a2) {
                    decodeStream = null;
                }
                Bitmap bitmap = decodeStream;
                if (bitmap != null) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int i2 = width * height;
                    int[] iArr = new int[i2];
                    bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                    int i3 = -1;
                    for (int i4 = 0; i4 < i2; i4++) {
                        int i5 = iArr[i4];
                        if (i4 != 0) {
                            if (i5 != i3) {
                                b1Var.f1313a = bitmap;
                                IAlog.a("SimpleImageLoader: Got a valid bitmap %s", this.p);
                                break;
                            }
                        } else {
                            i3 = i5;
                        }
                    }
                }
                IAlog.a("SimpleImageLoader: Got an invalid bitmap", new Object[0]);
                b1Var.b = "Got an invalid bitmap";
            }
        } catch (Exception e) {
            IAlog.c("SimpleImageLoader: Exception on load image %s %s", e.getMessage(), e.toString());
            b1Var.b = e.getMessage();
        } catch (OutOfMemoryError e2) {
            IAlog.c("SimpleImageLoader: OutOfMemoryError on load image %s", e2.getMessage());
            Bitmap bitmap2 = b1Var.f1313a;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            b1Var.b = e2.getMessage();
        }
        n0Var.f1331a = b1Var;
        return n0Var;
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
