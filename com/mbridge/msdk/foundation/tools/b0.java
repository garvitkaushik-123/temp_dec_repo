package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: FastKVConfig.java */
/* loaded from: classes6.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    static volatile Executor f4354a;
    static FastKV.c b = new a();

    /* compiled from: FastKVConfig.java */
    class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "mb-sp-handler");
        }
    }

    private b0() {
    }

    static Executor a() {
        if (f4354a == null) {
            synchronized (b0.class) {
                if (f4354a == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new b(), new ThreadPoolExecutor.DiscardPolicy());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f4354a = threadPoolExecutor;
                }
            }
        }
        return f4354a;
    }

    /* compiled from: FastKVConfig.java */
    class a implements FastKV.c {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.tools.FastKV.c
        public void a(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                p0.c("FastKVConfig", str + " " + str2);
            }
        }

        @Override // com.mbridge.msdk.foundation.tools.FastKV.c
        public void b(String str, Exception exc) {
            if (MBridgeConstans.DEBUG) {
                p0.b("FastKVConfig", str, exc);
            }
        }

        @Override // com.mbridge.msdk.foundation.tools.FastKV.c
        public void a(String str, Exception exc) {
            if (MBridgeConstans.DEBUG) {
                p0.c("FastKVConfig", str, exc);
            }
        }
    }
}
