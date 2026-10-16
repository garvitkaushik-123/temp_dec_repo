package com.bytedance.sdk.component.ui.ui;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class Os extends eli {
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        if (TextUtils.isEmpty(os.aAs())) {
            com.bytedance.sdk.component.ui.nlS MGA = os.nGm().MGA();
            os.DbA(MGA.eli(os));
            os.eli(MGA.DbA(os));
        }
        os.eli(new kb());
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "generate_key";
    }
}
