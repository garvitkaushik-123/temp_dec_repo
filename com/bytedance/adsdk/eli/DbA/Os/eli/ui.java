package com.bytedance.adsdk.eli.DbA.Os.eli;

import java.util.Deque;

/* loaded from: classes3.dex */
public class ui extends MGA {
    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        char eli;
        int i2 = i;
        while (true) {
            eli = eli(i2, str);
            if (!com.bytedance.adsdk.eli.DbA.ui.eli.DbA(eli) && !com.bytedance.adsdk.eli.DbA.ui.eli.Os(eli)) {
                break;
            }
            i2++;
        }
        if (eli != '(') {
            return eliVar.eli(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.eli.DbA.DbA.eli.aAs(str.substring(i, i2)));
        return i2 + 1;
    }
}
