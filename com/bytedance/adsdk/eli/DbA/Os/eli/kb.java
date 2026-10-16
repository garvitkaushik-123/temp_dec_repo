package com.bytedance.adsdk.eli.DbA.Os.eli;

import com.bytedance.adsdk.eli.DbA.DbA.eli.Dfc;
import java.util.Deque;

/* loaded from: classes3.dex */
public class kb extends MGA {
    private boolean eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque) {
        if ('-' == eli(i, str)) {
            if (deque.peek() != null && !com.bytedance.adsdk.eli.DbA.aGH.Os.eli(deque.peek().eli())) {
                return false;
            }
            if (com.bytedance.adsdk.eli.DbA.ui.eli.Os(eli(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.bytedance.adsdk.eli.DbA.ui.eli.Os(eli(i, str));
    }

    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        char eli;
        if (!eli(str, i, deque)) {
            return eliVar.eli(str, i, deque);
        }
        int i2 = eli(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            eli = eli(i2, str);
            if (com.bytedance.adsdk.eli.DbA.ui.eli.Os(eli) || (!z && eli == '.')) {
                i2++;
                if (eli == '.') {
                    z = true;
                }
            }
        }
        if (eli == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new Dfc(str.substring(i, i2)));
        return i2;
    }
}
