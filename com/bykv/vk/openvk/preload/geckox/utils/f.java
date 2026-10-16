package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* compiled from: PiecemealSerialExecutor.java */
/* loaded from: classes3.dex */
public class f implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f980a;

    public static f a() {
        if (f980a == null) {
            synchronized (f.class) {
                if (f980a == null) {
                    f980a = new f();
                }
            }
        }
        return f980a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.t().execute(runnable);
    }
}
