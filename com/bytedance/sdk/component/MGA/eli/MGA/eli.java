package com.bytedance.sdk.component.MGA.eli.MGA;

import com.bytedance.sdk.component.MGA.eli.wC;

/* loaded from: classes3.dex */
public class eli {
    private static volatile DbA eli;

    public static DbA eli() {
        if (eli == null) {
            synchronized (DbA.class) {
                if (eli == null) {
                    eli = new Os(wC.kb().MGA(), new MGA(wC.kb().MGA()));
                }
            }
        }
        return eli;
    }
}
