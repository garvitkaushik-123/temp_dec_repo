package com.mbridge.msdk.foundation.same.threadpool;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f4337a;
    private static ThreadPoolExecutor b;
    private static Handler c;
    private static ThreadPoolExecutor d;
    private static ThreadPoolExecutor e;
    private static ThreadPoolExecutor f;

    /* compiled from: ThreadPoolUtils.java */
    /* renamed from: com.mbridge.msdk.foundation.same.threadpool.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0341a implements ThreadFactory {
        ThreadFactoryC0341a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("BitmapThreadPool");
            return newThread;
        }
    }

    /* compiled from: ThreadPoolUtils.java */
    class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("CommonThreadPool");
            return newThread;
        }
    }

    /* compiled from: ThreadPoolUtils.java */
    class c implements ThreadFactory {
        c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("NwtThreadPool");
            return newThread;
        }
    }

    /* compiled from: ThreadPoolUtils.java */
    class d implements ThreadFactory {
        d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("ReportThreadPool");
            return newThread;
        }
    }

    /* compiled from: ThreadPoolUtils.java */
    class e implements ThreadFactory {
        e() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("rv-load-tread");
            return thread;
        }
    }

    /* compiled from: ThreadPoolUtils.java */
    private static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public static ThreadPoolExecutor a() {
        if (b == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new ThreadFactoryC0341a(), new ThreadPoolExecutor.DiscardPolicy());
            b = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return b;
    }

    public static ThreadPoolExecutor b() {
        if (f4337a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 25, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new b(), new ThreadPoolExecutor.DiscardPolicy());
            f4337a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f4337a;
    }

    public static Handler c() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    public static ThreadPoolExecutor d() {
        if (d == null) {
            d = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new c(), new ThreadPoolExecutor.DiscardPolicy());
        }
        return d;
    }

    public static ThreadPoolExecutor e() {
        if (e == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new d(), new ThreadPoolExecutor.DiscardPolicy());
            e = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return e;
    }

    public static ThreadPoolExecutor f() {
        if (f == null) {
            e eVar = new e();
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), eVar, new ThreadPoolExecutor.DiscardPolicy());
            f = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f;
    }
}
