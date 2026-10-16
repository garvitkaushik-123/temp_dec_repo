package com.bytedance.sdk.component.ui.aGH.Os.eli.DbA;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ui.dV;

/* loaded from: classes3.dex */
public class Os implements dV {
    private final com.bytedance.sdk.component.ui.aGH.Os.eli.eli DbA;
    private final dV eli;

    public Os(dV dVVar) {
        this(dVVar, null);
    }

    public Os(dV dVVar, com.bytedance.sdk.component.ui.aGH.Os.eli.eli eliVar) {
        this.eli = dVVar;
        this.DbA = eliVar;
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
