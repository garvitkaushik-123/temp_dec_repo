package com.bytedance.adsdk.DbA;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public class NU<T> {
    public static Executor eli = Executors.newCachedThreadPool();
    private final Set<du<T>> DbA;
    private final Set<du<Throwable>> Os;
    private final Handler aGH;
    private volatile nlS<T> ui;

    public NU(Callable<nlS<T>> callable) {
        this(callable, false);
    }

    NU(Callable<nlS<T>> callable, boolean z) {
        this.DbA = new LinkedHashSet(1);
        this.Os = new LinkedHashSet(1);
        this.aGH = new Handler(Looper.getMainLooper());
        this.ui = null;
        if (z) {
            try {
                eli((nlS) callable.call());
                return;
            } catch (Throwable th) {
                eli((nlS) new nlS<>(th));
                return;
            }
        }
        eli.execute(new eli(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(nlS<T> nls) {
        if (this.ui != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ui = nls;
        eli();
    }

    public synchronized NU<T> eli(du<T> duVar) {
        nlS<T> nls = this.ui;
        if (nls != null && nls.eli() != null) {
            duVar.eli(nls.eli());
        }
        this.DbA.add(duVar);
        return this;
    }

    public synchronized NU<T> DbA(du<T> duVar) {
        this.DbA.remove(duVar);
        return this;
    }

    public synchronized NU<T> Os(du<Throwable> duVar) {
        nlS<T> nls = this.ui;
        if (nls != null && nls.DbA() != null) {
            duVar.eli(nls.DbA());
        }
        this.Os.add(duVar);
        return this;
    }

    public synchronized NU<T> aGH(du<Throwable> duVar) {
        this.Os.remove(duVar);
        return this;
    }

    private void eli() {
        this.aGH.post(new Runnable() { // from class: com.bytedance.adsdk.DbA.NU.1
            @Override // java.lang.Runnable
            public void run() {
                nlS nls = NU.this.ui;
                if (nls == null) {
                    return;
                }
                if (nls.eli() != null) {
                    NU.this.eli((NU) nls.eli());
                } else {
                    NU.this.eli(nls.DbA());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eli(T t) {
        Iterator it = new ArrayList(this.DbA).iterator();
        while (it.hasNext()) {
            ((du) it.next()).eli(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eli(Throwable th) {
        ArrayList arrayList = new ArrayList(this.Os);
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((du) it.next()).eli(th);
        }
    }

    private class eli extends FutureTask<nlS<T>> {
        eli(Callable<nlS<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                NU.this.eli((nlS) get());
            } catch (InterruptedException | ExecutionException e) {
                NU.this.eli(new nlS(e));
            }
        }
    }
}
