package com.fyber.inneractive.sdk.util;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public final class f {
    public static final f b = new f();

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f1757a = new ConcurrentLinkedQueue();

    public f() {
        for (int i = 0; i < 2; i++) {
            this.f1757a.offer(ByteBuffer.allocateDirect(16384));
        }
    }
}
