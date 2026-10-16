package com.bytedance.adsdk.eli.DbA.Os.eli;

import com.bytedance.adsdk.eli.DbA.DbA.eli.bf;
import java.util.Deque;

/* loaded from: classes3.dex */
public class eli extends MGA {
    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        if (',' != eli(i, str)) {
            return eliVar.eli(str, i, deque);
        }
        deque.push(new bf(com.bytedance.adsdk.eli.DbA.aGH.aGH.COMMA));
        return i + 1;
    }
}
