package com.bytedance.sdk.component.wC.Os;

/* loaded from: classes3.dex */
public abstract class DbA implements Comparable<DbA>, Runnable {
    private String DbA;
    private long MGA;
    private Runnable Os;
    private long aGH;
    private int eli;
    private long ui;

    public DbA(String str) {
        this.eli = 5;
        this.DbA = str;
    }

    public DbA(int i, String str) {
        this.eli = i;
        this.DbA = str;
    }

    public DbA(String str, Runnable runnable) {
        this.eli = 5;
        this.DbA = str;
        this.Os = runnable;
    }

    public void eli(int i) {
        this.eli = i;
    }

    public int eli() {
        return this.eli;
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(DbA dbA) {
        if (eli() < dbA.eli()) {
            return 1;
        }
        return eli() >= dbA.eli() ? -1 : 0;
    }

    public String DbA() {
        return this.DbA;
    }

    public long Os() {
        return this.aGH;
    }

    public void eli(long j) {
        this.aGH = j;
    }

    public long aGH() {
        return this.ui;
    }

    public void DbA(long j) {
        this.ui = j;
    }

    public long ui() {
        return this.MGA;
    }

    public void Os(long j) {
        this.MGA = j;
    }

    public Runnable MGA() {
        return this.Os;
    }
}
