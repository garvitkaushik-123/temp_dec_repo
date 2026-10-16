package com.bytedance.adsdk.eli.DbA.Os.eli;

import com.bytedance.adsdk.eli.DbA.DbA.eli.Xb;
import java.util.Deque;

/* loaded from: classes3.dex */
public class DbA extends MGA {
    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        if ('\'' != eli(i, str)) {
            return eliVar.eli(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && eli(i3, str) != '\'') {
            i3++;
        }
        if (eli(i3, str) != '\'') {
            throw new com.bytedance.adsdk.eli.eli.eli("String expression not surrounded by '", str.substring(i));
        }
        deque.push(new Xb(str.substring(i2, i3)));
        return i3 + 1;
    }
}
