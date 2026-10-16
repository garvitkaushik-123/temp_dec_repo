package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* compiled from: IOSerialExecutor.java */
/* loaded from: classes3.dex */
public class c implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f978a;

    public static c a() {
        if (f978a == null) {
            synchronized (c.class) {
                if (f978a == null) {
                    f978a = new c();
                }
            }
        }
        return f978a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.t().execute(runnable);
    }
}
