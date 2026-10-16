package com.bytedance.sdk.component.MGA.eli.ui;

import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class ui implements Comparable<ui>, Runnable {
    private String Os;
    private int eli = 5;
    private String DbA = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public ui(String str) {
        this.Os = str;
    }

    public void eli(int i) {
        this.eli = i;
    }

    public int eli() {
        return this.eli;
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(ui uiVar) {
        if (eli() < uiVar.eli()) {
            return 1;
        }
        return eli() >= uiVar.eli() ? -1 : 0;
    }
}
