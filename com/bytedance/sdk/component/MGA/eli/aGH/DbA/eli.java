package com.bytedance.sdk.component.MGA.eli.aGH.DbA;

/* loaded from: classes3.dex */
public class eli {
    private int DbA;
    private int eli;

    public int eli() {
        return this.eli;
    }

    public int DbA() {
        return this.DbA;
    }

    eli(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.eli = i;
        this.DbA = i2;
    }

    public static eli Os() {
        return new eli(1, 100, 172800000L);
    }

    public static eli aGH() {
        return new eli(1, 100, -1L);
    }

    public static eli ui() {
        return new eli(3, 100, 172800000L);
    }
}
