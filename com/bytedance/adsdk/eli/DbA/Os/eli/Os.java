package com.bytedance.adsdk.eli.DbA.Os.eli;

import com.bytedance.adsdk.eli.DbA.DbA.eli.CMM;
import java.util.Deque;

/* loaded from: classes3.dex */
public class Os extends MGA {
    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        char eli = eli(i, str);
        if (!com.bytedance.adsdk.eli.DbA.ui.eli.DbA(eli) && eli != '$') {
            return eliVar.eli(str, i, deque);
        }
        return eli(str, i, deque);
    }

    private int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char eli = eli(i2, str);
            if (!com.bytedance.adsdk.eli.DbA.ui.eli.DbA(eli) && !com.bytedance.adsdk.eli.DbA.ui.eli.Os(eli) && '.' != eli && '[' != eli && ']' != eli && '_' != eli && '-' != eli && '$' != eli) {
                break;
            }
            i3++;
        }
        String substring = str.substring(i, i2);
        if (com.bytedance.adsdk.eli.DbA.aGH.eli.eli(substring) != null) {
            deque.push(new com.bytedance.adsdk.eli.DbA.DbA.eli.kb(substring));
            return i2;
        }
        deque.push(new CMM(substring));
        return i2;
    }
}
