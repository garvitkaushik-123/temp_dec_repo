package com.bytedance.sdk.component.wC;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public class kb<V> extends FutureTask<V> implements Comparable<kb<V>> {
    private int DbA;
    private int eli;

    public kb(Callable<V> callable, int i, int i2) {
        super(callable);
        this.eli = i == -1 ? 5 : i;
        this.DbA = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(kb kbVar) {
        if (eli() < kbVar.eli()) {
            return 1;
        }
        return eli() > kbVar.eli() ? -1 : 0;
    }

    public int eli() {
        return this.eli;
    }
}
