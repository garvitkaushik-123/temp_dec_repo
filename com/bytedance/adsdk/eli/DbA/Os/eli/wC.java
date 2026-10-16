package com.bytedance.adsdk.eli.DbA.Os.eli;

import com.bytedance.adsdk.eli.DbA.DbA.eli.aqO;
import java.util.Deque;

/* loaded from: classes3.dex */
public class wC extends MGA {
    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        if (!com.bytedance.adsdk.eli.DbA.ui.eli.aGH(eli(i, str))) {
            return eliVar.eli(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{eli(i, str), eli(i2, str)});
        if (com.bytedance.adsdk.eli.DbA.aGH.Os.eli(str2) != null) {
            deque.push(new aqO(com.bytedance.adsdk.eli.DbA.aGH.Os.eli(str2)));
            return i + 2;
        }
        String valueOf = String.valueOf(eli(i, str));
        if (com.bytedance.adsdk.eli.DbA.aGH.Os.eli(valueOf) != null) {
            deque.push(new aqO(com.bytedance.adsdk.eli.DbA.aGH.Os.eli(valueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + valueOf + "examine:" + str.substring(0, i));
    }
}
