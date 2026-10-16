package com.bytedance.sdk.component.DbA.eli.eli.eli;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.sdk.component.DbA.eli.aGH {
    private List<com.bytedance.sdk.component.DbA.eli.DbA> DbA = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.DbA.eli.DbA> Os = new CopyOnWriteArrayList();
    private AtomicInteger aGH = new AtomicInteger(64);
    private ExecutorService eli;

    public MGA() {
        if (this.eli == null) {
            this.eli = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.DbA.eli.eli.eli.MGA.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, "systemHttp Dispatcher");
                    thread.setDaemon(false);
                    thread.setPriority(10);
                    return thread;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public ExecutorService DbA() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public void eli(int i) {
        this.aGH.set(i);
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public List<com.bytedance.sdk.component.DbA.eli.DbA> Os() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public List<com.bytedance.sdk.component.DbA.eli.DbA> aGH() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public int eli() {
        return this.aGH.get();
    }
}
