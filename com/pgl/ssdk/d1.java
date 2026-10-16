package com.pgl.ssdk;

import com.pgl.ssdk.c1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes6.dex */
public class d1<T extends c1> {

    /* renamed from: a, reason: collision with root package name */
    private int f6389a;
    private BlockingQueue<T> b = new LinkedBlockingQueue();

    private d1(int i) {
        this.f6389a = i;
    }

    public static d1 a(int i) {
        return new d1(i);
    }

    public T a() {
        return this.b.poll();
    }
}
