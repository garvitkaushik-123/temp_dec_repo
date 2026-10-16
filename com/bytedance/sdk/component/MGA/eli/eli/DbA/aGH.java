package com.bytedance.sdk.component.MGA.eli.eli.DbA;

import com.bytedance.sdk.component.MGA.eli.aGH.eli;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public abstract class aGH<T extends com.bytedance.sdk.component.MGA.eli.aGH.eli> {
    private Queue<T> DbA = new ConcurrentLinkedQueue();
    private Queue<String> Os;
    private String aGH;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eli;

    public aGH(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar, Queue<String> queue, String str) {
        this.eli = eliVar;
        this.Os = queue;
        this.aGH = str;
    }

    public void eli(T t) {
        Queue<T> queue = this.DbA;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public synchronized List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(int i, int i2) {
        if (!DbA(i, i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.eli.eli());
        do {
            T poll = this.DbA.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        } while (arrayList.size() != this.eli.DbA());
        return arrayList;
    }

    public synchronized void eli(int i, List<T> list) {
        if (i == -1 || i == 200 || i == 509) {
            this.DbA.size();
        } else {
            this.DbA.addAll(list);
        }
    }

    public synchronized boolean DbA(int i, int i2) {
        int size = this.DbA.size();
        int eli = this.eli.eli();
        return (i == 2 || i == 1) ? com.bytedance.sdk.component.MGA.eli.Os.eli.Os() ? size > 0 : size >= eli : size >= eli;
    }
}
