package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class wC {
    private final List<eli<Integer, Integer>> DbA;
    private final List<com.bytedance.adsdk.DbA.Os.DbA.wC> Os;
    private final List<eli<com.bytedance.adsdk.DbA.Os.DbA.nn, Path>> eli;

    public wC(List<com.bytedance.adsdk.DbA.Os.DbA.wC> list) {
        this.Os = list;
        this.eli = new ArrayList(list.size());
        this.DbA = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.eli.add(list.get(i).DbA().eli());
            this.DbA.add(list.get(i).Os().eli());
        }
    }

    public List<com.bytedance.adsdk.DbA.Os.DbA.wC> eli() {
        return this.Os;
    }

    public List<eli<com.bytedance.adsdk.DbA.Os.DbA.nn, Path>> DbA() {
        return this.eli;
    }

    public List<eli<Integer, Integer>> Os() {
        return this.DbA;
    }
}
