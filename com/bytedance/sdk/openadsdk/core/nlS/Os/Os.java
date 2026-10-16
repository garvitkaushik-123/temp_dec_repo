package com.bytedance.sdk.openadsdk.core.nlS.Os;

import com.bytedance.sdk.component.utils.kb;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.sdk.openadsdk.DbA.DbA {
    public Os(int i, int i2) {
        super(i, i2);
    }

    public Os(int i, int i2, boolean z) {
        super(i, i2);
        this.eli = z;
    }

    @Override // com.bytedance.sdk.openadsdk.DbA.DbA, com.bytedance.sdk.openadsdk.DbA.eli
    protected void eli(List<File> list) {
        int size = list.size();
        if (eli(0L, size)) {
            return;
        }
        for (File file : list) {
            kb.Os(file);
            size--;
            if (eli(file, 0L, size)) {
                return;
            }
        }
    }
}
