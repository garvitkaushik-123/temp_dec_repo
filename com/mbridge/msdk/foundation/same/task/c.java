package com.mbridge.msdk.foundation.same.task;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CommonTaskLoaderThreadPool.java */
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f4336a;

    /* compiled from: CommonTaskLoaderThreadPool.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("mb-task-loader-thread");
            return thread;
        }
    }

    private static ThreadFactory a() {
        return new a();
    }

    public static ThreadPoolExecutor b() {
        c();
        if (f4336a == null) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f4336a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), a(), new ThreadPoolExecutor.DiscardPolicy());
            f4336a.allowCoreThreadTimeOut(true);
        }
        return f4336a;
    }

    private static void c() {
        if (f4336a != null) {
            return;
        }
        int a2 = a(10, "c_t_l_t_p_c");
        int a3 = a(50, "c_t_l_t_p_m");
        int a4 = a(5, "c_t_l_t_p_t");
        int i = a3 < a2 ? a2 : a3;
        try {
            if (MBridgeConstans.DEBUG) {
                p0.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor for core " + a2 + " max " + i + " timeout " + a4);
            }
            long j = a4;
            if (j <= 0) {
                j = 1;
            }
            f4336a = new ThreadPoolExecutor(a2, i, j, TimeUnit.SECONDS, new LinkedBlockingDeque(), a(), new ThreadPoolExecutor.DiscardPolicy());
            f4336a.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor failed ", e);
            }
        }
    }

    private static int a(int i, String str) {
        int b;
        try {
            b = r0.a().b(str, i);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonTaskLoaderThreadPool", e.getMessage());
            }
        }
        return b <= 0 ? i : b;
    }
}
