package com.bytedance.adsdk.eli.DbA.Os.eli;

import java.util.Deque;

/* loaded from: classes3.dex */
public abstract class MGA {
    public abstract int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar);

    protected char eli(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    protected int DbA(int i, String str) {
        while (com.bytedance.adsdk.eli.DbA.ui.eli.eli(eli(i, str))) {
            i++;
        }
        return i;
    }
}
