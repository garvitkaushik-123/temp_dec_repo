package com.bytedance.sdk.component.wC.eli;

import com.bytedance.sdk.component.wC.eli.Os;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class aGH<T extends Os> {
    private BlockingQueue<T> DbA = new LinkedBlockingQueue();
    private int eli;

    public static aGH eli(int i) {
        return new aGH(i);
    }

    private aGH(int i) {
        this.eli = i;
    }

    public T eli() {
        return this.DbA.poll();
    }

    public boolean eli(T t) {
        if (t == null) {
            return false;
        }
        t.eli();
        if (this.DbA.size() >= this.eli) {
            return false;
        }
        return this.DbA.offer(t);
    }
}
