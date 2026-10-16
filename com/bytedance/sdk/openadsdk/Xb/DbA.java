package com.bytedance.sdk.openadsdk.Xb;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DbA {
    private wC DbA;
    private int aGH;
    private eli ui;
    private ScheduledExecutorService eli = null;
    private long Os = 0;

    public interface eli {
    }

    public DbA(wC wCVar, int i) {
        this.DbA = wCVar;
        this.aGH = i;
    }

    public void eli(long j) {
        this.Os = j;
    }

    public void eli(int i) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.eli = newScheduledThreadPool;
        newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.DbA.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                long unused = DbA.this.Os;
                if (System.currentTimeMillis() - DbA.this.Os > DbA.this.aGH) {
                    DbA.this.eli.shutdown();
                    if (DbA.this.DbA != null) {
                        DbA.this.DbA.DbA(0, "Automatic detection of stuck");
                    }
                    if (DbA.this.ui != null) {
                        eli unused2 = DbA.this.ui;
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void eli() {
        ScheduledExecutorService scheduledExecutorService = this.eli;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean DbA() {
        ScheduledExecutorService scheduledExecutorService = this.eli;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
