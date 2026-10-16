package com.bytedance.sdk.component.ui.Os.eli.DbA;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ui.dV;

/* loaded from: classes3.dex */
public class aGH implements dV {
    private final com.bytedance.sdk.component.ui.Os.eli.DbA DbA;
    private final dV eli;

    public aGH(dV dVVar) {
        this(dVVar, null);
    }

    public aGH(dV dVVar, com.bytedance.sdk.component.ui.Os.eli.DbA dbA) {
        this.eli = dVVar;
        this.DbA = dbA;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, Bitmap bitmap) {
        boolean eli = this.eli.eli(str, bitmap);
        if (this.DbA != null) {
            Boolean.valueOf(eli);
        }
        return eli;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public Bitmap eli(String str) {
        return this.eli.eli(str);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean DbA(String str) {
        return this.eli.DbA(str);
    }
}
