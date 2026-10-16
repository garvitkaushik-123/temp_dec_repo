package com.bytedance.sdk.component.wC;

import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class eli extends ThreadPoolExecutor {
    private String eli;

    public eli(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.eli = str;
    }

    private void eli(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            eli(runnable, e);
        } catch (Throwable th) {
            eli(runnable, th);
        }
    }

    private void eli(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        eli(runnable, (Throwable) outOfMemoryError);
    }

    private void eli(Runnable runnable, Throwable th) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                runnable.run();
            } catch (Throwable unused) {
            }
        }
    }

    private void eli(BlockingQueue<Runnable> blockingQueue, int i) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i);
            new Object[]{"reduceCoreThreadSize: reduce poolType =  ", this.eli, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize())};
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void eli(BlockingQueue<Runnable> blockingQueue, int i, int i2) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() < i2) {
            return;
        }
        try {
            setCorePoolSize(i);
            new Object[]{"increaseCoreThreadSize: increase poolType =  ", this.eli, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize())};
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof wC) {
            eli(new DbA((wC) runnable, this));
        } else {
            eli(new DbA(new wC("unknown") { // from class: com.bytedance.sdk.component.wC.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (!MGA.kb() || TextUtils.isEmpty(this.eli) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.eli;
        str.hashCode();
        switch (str) {
            case "io":
                eli(queue, MGA.eli + 2, getCorePoolSize() * 2);
                break;
            case "log":
                eli(queue, 8, 8);
                break;
            case "aidl":
                eli(queue, 5, 5);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!MGA.kb() || TextUtils.isEmpty(this.eli) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.eli;
        str.hashCode();
        switch (str) {
            case "io":
                eli(queue, 2);
                break;
            case "log":
                eli(queue, 4);
                break;
            case "aidl":
                eli(queue, 2);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if ("io".equals(this.eli) || "aidl".equals(this.eli)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.eli) || "aidl".equals(this.eli)) {
            return;
        }
        super.shutdown();
    }

    public String eli() {
        return this.eli;
    }

    /* renamed from: com.bytedance.sdk.component.wC.eli$eli, reason: collision with other inner class name */
    public static class C0152eli {
        private RejectedExecutionHandler wC;
        private String eli = "io";
        private int DbA = 1;
        private long Os = 30;
        private TimeUnit aGH = TimeUnit.SECONDS;
        private int ui = Integer.MAX_VALUE;
        private BlockingQueue<Runnable> MGA = null;
        private ThreadFactory kb = null;
        private int FC = 5;

        public C0152eli eli(String str) {
            this.eli = str;
            return this;
        }

        public C0152eli eli(int i) {
            this.DbA = i;
            return this;
        }

        public C0152eli eli(long j) {
            this.Os = j;
            return this;
        }

        public C0152eli eli(TimeUnit timeUnit) {
            this.aGH = timeUnit;
            return this;
        }

        public C0152eli eli(BlockingQueue<Runnable> blockingQueue) {
            this.MGA = blockingQueue;
            return this;
        }

        public C0152eli eli(ThreadFactory threadFactory) {
            this.kb = threadFactory;
            return this;
        }

        public C0152eli eli(RejectedExecutionHandler rejectedExecutionHandler) {
            this.wC = rejectedExecutionHandler;
            return this;
        }

        public C0152eli DbA(int i) {
            this.FC = i;
            return this;
        }

        public eli eli() {
            if (this.kb == null) {
                this.kb = ui.eli().createThreadFactory(this.FC, this.eli);
            }
            if (this.wC == null) {
                this.wC = MGA.wC();
            }
            if (this.MGA == null) {
                this.MGA = new LinkedBlockingQueue();
            }
            return new eli(this.eli, this.DbA, this.ui, this.Os, this.aGH, this.MGA, this.kb, this.wC);
        }
    }
}
