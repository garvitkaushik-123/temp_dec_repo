package com.bytedance.sdk.component.wC;

/* loaded from: classes3.dex */
public abstract class wC implements Comparable<wC>, Runnable {
    private String DbA;
    private int eli;

    public wC(String str, int i) {
        this.eli = 0;
        this.eli = i == 0 ? 5 : i;
        this.DbA = str;
    }

    public wC(String str) {
        this.eli = 5;
        this.DbA = str;
    }

    public void setPriority(int i) {
        this.eli = i;
    }

    public int getPriority() {
        return this.eli;
    }

    @Override // java.lang.Comparable
    public int compareTo(wC wCVar) {
        if (getPriority() < wCVar.getPriority()) {
            return 1;
        }
        return getPriority() >= wCVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.DbA;
    }
}
