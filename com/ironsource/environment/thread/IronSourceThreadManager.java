package com.ironsource.environment.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ironsource.C3260q4;
import com.ironsource.I9;
import com.ironsource.Qd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class IronSourceThreadManager {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3282a;
    private static final Handler c;
    private static final I9 d;
    private static final I9 e;
    private static final I9 f;
    private static final Lazy g;
    private static final Lazy h;
    public static final IronSourceThreadManager INSTANCE = new IronSourceThreadManager();
    private static final Handler b = new Handler(Looper.getMainLooper());

    static final class a extends Lambda implements Function0<Qd> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3283a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Qd invoke() {
            return new Qd(0, null, null, 7, null);
        }
    }

    static final class b extends Lambda implements Function0<I9> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3284a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final I9 invoke() {
            I9 i9 = new I9("managersThread");
            i9.start();
            i9.a();
            return i9;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        handlerThread.start();
        c = new Handler(handlerThread.getLooper());
        I9 i9 = new I9("mediationBackground");
        i9.start();
        i9.a();
        d = i9;
        I9 i92 = new I9("adapterBackground");
        i92.start();
        i92.a();
        e = i92;
        I9 i93 = new I9("publisher-callbacks");
        i93.start();
        i93.a();
        f = i93;
        g = LazyKt.lazy(a.f3283a);
        h = LazyKt.lazy(b.f3284a);
    }

    private IronSourceThreadManager() {
    }

    private final Qd a() {
        return (Qd) g.getValue();
    }

    public static /* synthetic */ void postAdapterBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postAdapterBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postMediationBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postMediationBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postOnUiThreadTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postOnUiThreadTask(runnable, j);
    }

    public static /* synthetic */ void postPublisherCallback$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postPublisherCallback(runnable, j);
    }

    public final void executeTasks(boolean z, boolean z2, List<? extends Runnable> tasks) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        if (!z) {
            Iterator<? extends Runnable> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            return;
        }
        if (!z2) {
            Iterator<? extends Runnable> it2 = tasks.iterator();
            while (it2.hasNext()) {
                postMediationBackgroundTask$default(INSTANCE, it2.next(), 0L, 2, null);
            }
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(tasks.size());
        for (final Runnable runnable : tasks) {
            postMediationBackgroundTask$default(INSTANCE, new Runnable() { // from class: com.ironsource.environment.thread.IronSourceThreadManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    IronSourceThreadManager.a(runnable, countDownLatch);
                }
            }, 0L, 2, null);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            C3260q4.d().a(e2);
        }
    }

    public final Handler getInitHandler() {
        return c;
    }

    public final I9 getSharedManagersThread() {
        return (I9) h.getValue();
    }

    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
    }

    public final boolean getUseSharedExecutorService() {
        return f3282a;
    }

    public final void postAdapterBackgroundTask(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        postAdapterBackgroundTask$default(this, action, 0L, 2, null);
    }

    public final void postMediationBackgroundTask(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        postMediationBackgroundTask$default(this, action, 0L, 2, null);
    }

    public final void postOnUiThreadTask(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        postOnUiThreadTask$default(this, action, 0L, 2, null);
    }

    public final void postPublisherCallback(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        postPublisherCallback$default(this, action, 0L, 2, null);
    }

    public final void removeAdapterBackgroundTask(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (a(action)) {
            a().remove(action);
        } else {
            e.b(action);
        }
    }

    public final void removeMediationBackgroundTask(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (a(action)) {
            a().remove(action);
        } else {
            d.b(action);
        }
    }

    public final void removeUiThreadTask(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        b.removeCallbacks(action);
    }

    public final void setUseSharedExecutorService(boolean z) {
        f3282a = z;
    }

    private final boolean a(Runnable runnable) {
        return f3282a && a().getQueue().contains(runnable);
    }

    public final void postAdapterBackgroundTask(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (f3282a) {
            a().schedule(action, j, TimeUnit.MILLISECONDS);
        } else {
            e.a(action, j);
        }
    }

    public final void postMediationBackgroundTask(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (f3282a) {
            a().schedule(action, j, TimeUnit.MILLISECONDS);
        } else {
            d.a(action, j);
        }
    }

    public final void postOnUiThreadTask(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        b.postDelayed(action, j);
    }

    public final void postPublisherCallback(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        f.a(action, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Runnable it, final CountDownLatch latch) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(latch, "$latch");
        it.run();
        new Runnable() { // from class: com.ironsource.environment.thread.IronSourceThreadManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IronSourceThreadManager.a(latch);
            }
        }.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CountDownLatch latch) {
        Intrinsics.checkNotNullParameter(latch, "$latch");
        latch.countDown();
    }
}
