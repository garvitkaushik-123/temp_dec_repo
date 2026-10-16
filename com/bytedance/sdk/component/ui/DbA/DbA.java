package com.bytedance.sdk.component.ui.DbA;

import com.bytedance.sdk.component.ui.nn;
import com.bytedance.sdk.component.ui.ui;

/* loaded from: classes3.dex */
public class DbA implements ui {
    private boolean DbA;
    private boolean Os;
    private nn aGH;
    private String eli;

    public DbA(String str, boolean z, boolean z2, nn nnVar) {
        this.eli = str;
        this.DbA = z;
        this.Os = z2;
        this.aGH = nnVar;
    }

    @Override // com.bytedance.sdk.component.ui.ui
    public String eli() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.ui.ui
    public boolean DbA() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.ui.ui
    public boolean Os() {
        return this.Os;
    }
}
