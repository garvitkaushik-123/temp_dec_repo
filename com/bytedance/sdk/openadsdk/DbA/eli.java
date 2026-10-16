package com.bytedance.sdk.openadsdk.DbA;

import com.bytedance.sdk.component.utils.kb;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class eli {
    protected boolean eli = false;
    private final ExecutorService DbA = Executors.newSingleThreadExecutor();

    protected abstract void eli(List<File> list);

    protected abstract boolean eli(long j, int i);

    protected abstract boolean eli(File file, long j, int i);

    public void eli(File file) throws IOException {
        this.DbA.submit(new CallableC0155eli(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(File file) throws IOException {
        if (this.eli) {
            List<File> eli = kb.eli(file);
            new Object[]{"touchInBackground", eli.toString()};
            eli(eli);
        } else {
            try {
                kb.DbA(file);
            } catch (Throwable unused) {
            }
            eli(kb.eli(file.getParentFile()));
        }
    }

    long DbA(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.DbA.eli$eli, reason: collision with other inner class name */
    private class CallableC0155eli implements Callable<Void> {
        private final File DbA;

        private CallableC0155eli(File file) {
            this.DbA = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            eli.this.DbA(this.DbA);
            return null;
        }
    }
}
