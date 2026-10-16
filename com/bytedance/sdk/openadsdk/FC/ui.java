package com.bytedance.sdk.openadsdk.FC;

import com.bytedance.sdk.component.ui.FC;
import com.bytedance.sdk.component.ui.QX;

/* loaded from: classes3.dex */
public class ui implements QX {
    private static int eli;
    private long DbA = 0;
    private long Os;
    private boolean aGH;
    private final String ui;

    private String Os(String str, FC fc) {
        return str;
    }

    public ui() {
        eli++;
        this.ui = "image_request_" + eli;
    }

    @Override // com.bytedance.sdk.component.ui.QX
    public void eli(String str, FC fc) {
        if (!this.aGH) {
            fc.eli();
            fc.DbA();
            fc.Os();
            this.aGH = true;
        }
        this.DbA = System.currentTimeMillis();
        Os(str, fc);
    }

    @Override // com.bytedance.sdk.component.ui.QX
    public void DbA(String str, FC fc) {
        this.Os += System.currentTimeMillis() - this.DbA;
        Os(str, fc);
    }
}
