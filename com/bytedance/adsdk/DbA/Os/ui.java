package com.bytedance.adsdk.DbA.Os;

import com.bytedance.adsdk.DbA.nn;

/* loaded from: classes3.dex */
public class ui {
    private static final ui eli = new ui();
    private final nn<String, com.bytedance.adsdk.DbA.kb> DbA = new nn<>(20);

    public static ui eli() {
        return eli;
    }

    ui() {
    }

    public com.bytedance.adsdk.DbA.kb eli(String str) {
        if (str == null) {
            return null;
        }
        return this.DbA.eli((nn<String, com.bytedance.adsdk.DbA.kb>) str);
    }

    public void eli(String str, com.bytedance.adsdk.DbA.kb kbVar) {
        if (str == null) {
            return;
        }
        this.DbA.eli(str, kbVar);
    }
}
