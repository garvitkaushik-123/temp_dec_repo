package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA {
    private final List<bf> eli = new ArrayList();

    void eli(bf bfVar) {
        this.eli.add(bfVar);
    }

    public void eli(Path path) {
        for (int size = this.eli.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.DbA.MGA.MGA.eli(path, this.eli.get(size));
        }
    }
}
