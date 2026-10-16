package com.bytedance.sdk.component.FC.eli;

/* loaded from: classes3.dex */
public class eli {
    private static volatile eli DbA;
    private volatile DbA eli;

    private eli() {
    }

    public static eli eli() {
        if (DbA == null) {
            synchronized (eli.class) {
                if (DbA == null) {
                    DbA = new eli();
                }
            }
        }
        return DbA;
    }

    public void eli(DbA dbA) {
        this.eli = dbA;
    }

    public DbA DbA() {
        return this.eli;
    }
}
