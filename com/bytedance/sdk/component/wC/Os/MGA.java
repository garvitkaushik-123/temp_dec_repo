package com.bytedance.sdk.component.wC.Os;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MGA extends ThreadPoolExecutor {
    private int DbA;
    private int Os;
    private int aGH;
    private final String eli;
    private boolean ui;

    private MGA(eli eliVar) {
        super(eliVar.DbA, Integer.MAX_VALUE, eliVar.ui, eliVar.kb, (BlockingQueue<Runnable>) eliVar.FC, eliVar.aAs);
        this.ui = false;
        new Object[]{"create poolType = ", eliVar.eli, " coreSize=", Integer.valueOf(eliVar.DbA), " maxSize=", Integer.valueOf(eliVar.Os), " keepAlive=", Long.valueOf(eliVar.ui), " createSize=", Integer.valueOf(eliVar.aGH), " isUseConfig=", Boolean.valueOf(eliVar.wC), "  workQueue", eliVar.FC};
        this.eli = eliVar.eli;
        this.DbA = eliVar.DbA;
        this.Os = eliVar.Os;
        this.aGH = eliVar.aGH;
        allowCoreThreadTimeOut(eliVar.MGA);
        this.ui = eliVar.wC;
    }

    public void eli(eli eliVar) {
        try {
            if (eliVar.DbA >= 0 && this.DbA != eliVar.DbA) {
                int i = eliVar.DbA;
                this.DbA = i;
                setCorePoolSize(i);
            }
            this.Os = eliVar.Os;
            this.aGH = eliVar.aGH;
            allowCoreThreadTimeOut(eliVar.MGA);
            this.ui = eliVar.wC;
        } catch (Throwable th) {
            th.getMessage();
        }
        new Object[]{"update poolType = ", eliVar.eli, " coreSize=", Integer.valueOf(eliVar.DbA), " maxSize=", Integer.valueOf(eliVar.Os), " keepAlive=", Long.valueOf(eliVar.ui), " createSize=", Integer.valueOf(eliVar.aGH), " isUseConfig=", Boolean.valueOf(eliVar.wC), "  workQueue", eliVar.FC};
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof DbA) {
            ((DbA) runnable).DbA(SystemClock.elapsedRealtime());
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        boolean z = runnable instanceof DbA;
        if (z) {
            ((DbA) runnable).Os(SystemClock.elapsedRealtime());
        }
        super.afterExecute(runnable, th);
        if (z) {
            DbA dbA = (DbA) runnable;
            new Object[]{"submit  poolType = ", this.eli, " taskName=", dbA.DbA(), "    ", "priority = ", Integer.valueOf(dbA.eli()), " SubmitTimestamp=", Long.valueOf(dbA.Os()), "  BeforeTimestamp=", Long.valueOf(dbA.aGH()), "  AfterTimestamp=", Long.valueOf(dbA.ui())};
        }
        Os();
    }

    private void DbA() {
        int corePoolSize;
        try {
            if (this.DbA != 0 && (corePoolSize = getCorePoolSize()) < this.Os) {
                int size = getQueue().size();
                if (getActiveCount() < this.DbA || size < this.aGH) {
                    return;
                }
                setCorePoolSize(this.Os);
                new Object[]{this.eli, " increaseToMaxThread  queueSize=", Integer.valueOf(size), "    ", Integer.valueOf(corePoolSize), " --> ", Integer.valueOf(this.Os)};
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void Os() {
        int corePoolSize;
        int size;
        try {
            if (this.DbA != 0 && (corePoolSize = getCorePoolSize()) > this.DbA && (size = getQueue().size()) == 0) {
                setCorePoolSize(this.DbA);
                new Object[]{this.eli, " reduceToCoreThread  queueSize=", Integer.valueOf(size), "    ", Integer.valueOf(corePoolSize), " --> ", Integer.valueOf(this.DbA)};
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        int i;
        String str;
        runnable.getClass();
        final RunnableFuture newTaskFor = newTaskFor(runnable, null);
        if (!(runnable instanceof DbA)) {
            i = 6;
            str = "";
        } else {
            DbA dbA = (DbA) runnable;
            i = dbA.eli();
            str = dbA.DbA();
        }
        if (i == 0 || TextUtils.isEmpty(str)) {
            new RuntimeException();
        }
        execute(new DbA(i, str) { // from class: com.bytedance.sdk.component.wC.Os.MGA.1
            @Override // java.lang.Runnable
            public void run() {
                newTaskFor.run();
            }
        });
        return newTaskFor;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bytedance.sdk.component.wC.Os.eli eli2;
        if (!(runnable instanceof DbA)) {
            runnable = new DbA("unknown", runnable) { // from class: com.bytedance.sdk.component.wC.Os.MGA.2
                @Override // java.lang.Runnable
                public void run() {
                    Runnable MGA = MGA();
                    if (MGA != null) {
                        MGA.run();
                    }
                }
            };
        }
        if (!"cache".equals(this.eli)) {
            String name = Thread.currentThread().getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(aGH.eli(this.eli)) && (eli2 = Os.eli()) != null) {
                eli2.eli(this, (DbA) runnable);
            }
        }
        ((DbA) runnable).eli(SystemClock.elapsedRealtime());
        try {
            super.execute(runnable);
            DbA();
        } catch (Throwable th) {
            eli(runnable, th);
        }
    }

    private void eli(Runnable runnable, Throwable th) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Handler DbA = Os.DbA();
                if (DbA != null) {
                    DbA.post(runnable);
                    return;
                }
                return;
            }
            runnable.run();
        } catch (Throwable unused) {
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if ("aidl".equals(this.eli)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("aidl".equals(this.eli)) {
            return;
        }
        super.shutdown();
    }

    public boolean eli() {
        return this.ui;
    }

    public static class eli {
        private String eli = "cache";
        private int DbA = 4;
        private int Os = 100;
        private int aGH = 0;
        private long ui = 30000;
        private boolean MGA = false;
        private TimeUnit kb = TimeUnit.MILLISECONDS;
        private boolean wC = false;
        private BlockingQueue<Runnable> FC = new PriorityBlockingQueue();
        private ThreadFactory aAs = null;

        public eli aGH(int i) {
            return this;
        }

        public eli ui(int i) {
            return this;
        }

        public eli eli(String str) {
            this.eli = str;
            return this;
        }

        public eli eli(int i) {
            this.DbA = i;
            return this;
        }

        public eli DbA(int i) {
            this.Os = i;
            return this;
        }

        public eli Os(int i) {
            this.aGH = i;
            return this;
        }

        public eli eli(long j) {
            this.ui = j;
            return this;
        }

        public eli eli(boolean z) {
            this.MGA = z;
            return this;
        }

        public eli DbA(boolean z) {
            this.wC = z;
            return this;
        }

        public MGA eli() {
            if (this.aAs == null) {
                this.aAs = new aGH(this.eli);
            }
            if (this.DbA < 0) {
                this.DbA = 8;
            }
            if (this.DbA == 0) {
                this.FC = new SynchronousQueue();
            }
            if (this.FC == null) {
                this.FC = new LinkedBlockingQueue();
            }
            if (this.Os > 100) {
                this.Os = 100;
            }
            int i = this.Os;
            int i2 = this.DbA;
            if (i < i2) {
                this.Os = i2;
            }
            return new MGA(this);
        }
    }
}
