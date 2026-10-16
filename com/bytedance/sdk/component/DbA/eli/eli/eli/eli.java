package com.bytedance.sdk.component.DbA.eli.eli.eli;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.sdk.component.DbA.eli.aGH {
    public static volatile aAs eli;
    private List<com.bytedance.sdk.component.DbA.eli.DbA> DbA = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.DbA.eli.DbA> Os = new CopyOnWriteArrayList();
    private ExecutorService aGH;

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public int eli() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public void eli(int i) {
    }

    public eli(ExecutorService executorService) {
        this.aGH = executorService;
    }

    public static void eli(aAs aas) {
        eli = aas;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public ExecutorService DbA() {
        ExecutorService eli2 = eli != null ? eli.eli() : null;
        return eli2 != null ? eli2 : this.aGH;
    }

    public boolean ui() {
        return (eli == null || eli.eli() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public List<com.bytedance.sdk.component.DbA.eli.DbA> Os() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.aGH
    public List<com.bytedance.sdk.component.DbA.eli.DbA> aGH() {
        return this.Os;
    }
}
