package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.e1;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class b1 extends e1 implements c1 {
    private final HandlerThread b;

    b1(HandlerThread handlerThread, e1.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.b = handlerThread;
    }

    public void a(e1.a aVar) {
        this.f6392a = new WeakReference<>(aVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
